/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Customer;
import Models.Item;
import Models.Report;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class ReportDao {

    Connection connection;

    public ReportDao() {
        connection = DataBaseConnection.getDBCInstance().getConnection();
    }

    public void saveReport(Report report) {

        String reportQuery = "INSERT INTO report (date, number, customer_id, type, status) "
                + "VALUES (?,?,?,?,?);";
        String last_report_id_query = "SELECT MAX(id) AS AUTO_INCREMENT FROM report";
        String itemQuery = "INSERT INTO item (product_id, item_code, item_year, cleaning, storing, mending, receiving_report_id, note, status)"
                + " VALUES (?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery);
                PreparedStatement ps_item = connection.prepareStatement(itemQuery);
                Statement last_report_id_st = connection.createStatement();) {
            ps_report.setString(1, getStringFromDate(report.getDate()));
            ps_report.setInt(2, report.getNumber());
            ps_report.setInt(3, report.getCustomer().getId());
            ps_report.setString(4, report.getType().toString());
            ps_report.setString(5, "completed");
            ps_report.execute();

            ResultSet rs = last_report_id_st.executeQuery(last_report_id_query);
            int increment_number = 0;
            while (rs.next()) {
                increment_number = rs.getInt("AUTO_INCREMENT");
            }
            for (Item item : report.getItems()) {

                ps_item.setInt(1, item.getId());
                ps_item.setInt(2, item.getCode());
                ps_item.setString(3, "2019");
                System.out.println("need work here too ReportDao- 59");
                if (item.isForCleaning()) {
                    ps_item.setInt(4, 1);
                } else {
                    ps_item.setInt(4, 0);
                }
                if (item.isForStoring()) {
                    ps_item.setInt(5, 1);
                } else {
                    ps_item.setInt(5, 0);
                }
                if (item.isForMending()) {
                    ps_item.setInt(6, 1);
                } else {
                    ps_item.setInt(6, 0);
                }
                ps_item.setInt(7, increment_number);
                ps_item.setString(8, item.getNote());
                ps_item.setString(9, "processing");
                ps_item.addBatch();
            }
            ps_item.executeBatch();

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private String getStringFromDate(Date date) {
        String stringDate = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        stringDate = dateFormat.format(date);

        return stringDate;
    }

    public int insertDeliveryReport(Report report) {
        int reportId = 0;
        String reportQuery = "INSERT INTO report (date, customer_id, type, status) "
                + "VALUES (?,?,?,?);";
        String last_report_id_query = "SELECT MAX(id) AS AUTO_INCREMENT FROM report";
        String itemQuery = "UPDATE item SET delivery_report_id=?, status=? WHERE item_code=? and item_year=?;";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery);
                PreparedStatement ps_item = connection.prepareStatement(itemQuery);
                Statement last_report_id_st = connection.createStatement();) {
            ps_report.setString(1, getStringFromDate(report.getDate()));
            //   ps_report.setInt(2, report.getNumber());
            ps_report.setInt(2, report.getCustomer().getId());
            ps_report.setString(3, report.getType().toString());
            ps_report.setString(4, "scheduled");
            ps_report.execute();

            ResultSet rs = last_report_id_st.executeQuery(last_report_id_query);

            while (rs.next()) {
                reportId = rs.getInt("AUTO_INCREMENT");
            }
            for (Item item : report.getItems()) {

                ps_item.setInt(1, reportId);
                ps_item.setString(2, "on_rout");
                ps_item.setInt(3, item.getCode());
                ps_item.setInt(4, item.getYear());

                ps_item.addBatch();
            }
            ps_item.executeBatch();

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return reportId;
    }

    public HashMap<Integer, Report> getReportsForDate(Date date) {
        HashMap<Integer, Report> reports = new HashMap<>();

        //   ArrayList<Report> reports = new ArrayList<>();
        String string_date = getStringFromDate(date);

        String reportQuery = "SELECT first_name, last_name, landline_phone, mobile_phone,    "
                + "street, district, floor, postal_code, bell_name, customer.note, "
                + "product_description, item_code, item_year, length, width, "
                + "cleaning_charge, storing_charge, mending_charge,"
                + " id   "
                + " FROM customer  "
                + "INNER JOIN report r ON customer.customer_id=r.customer_id "
                + "INNER JOIN item i ON i.delivery_report_id=r.id "
                + "INNER JOIN product p ON p.product_id=i.product_id "
                + "WHERE r.date='" + string_date + "' and r.status='scheduled';";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(reportQuery);

            while (rs.next()) {

                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String landline_phone = rs.getString("landline_phone");
                String mobile_phone = rs.getString("mobile_phone");
                String street = rs.getString("street");
                String district = rs.getString("district");
                String postal_code = rs.getString("postal_code");
                String floor = rs.getString("floor");
                String bell_name = rs.getString("bell_name");
                String note = rs.getString("customer.note");
                String product_description = rs.getString("product_description");
                int item_code = rs.getInt("item_code");
                int item_year = rs.getInt("item_year");
                BigDecimal length = rs.getBigDecimal("length");
                BigDecimal width = rs.getBigDecimal("width");

                BigDecimal cleaning_charge = rs.getBigDecimal("cleaning_charge");
                BigDecimal storing_charge = rs.getBigDecimal("storing_charge");
                BigDecimal mending_charge = rs.getBigDecimal("mending_charge");
                int id = rs.getInt("id");

                Report report = new Report();
                report.setId(id);
                if (!reports.containsKey(id)) {

                    Customer customer = new Customer();

                    customer.setFirstName(first_name);
                    customer.setLastName(last_name);
                    customer.setLandlinePhone(landline_phone);
                    customer.setMobilePhone(mobile_phone);
                    customer.setDistrict(district);
                    customer.setStreet(street);
                    customer.setPostalCode(postal_code);
                    customer.setFloor(floor);
                    customer.setBellName(bell_name);
                    report.setCustomer(customer);
                    reports.put(id, report);
                }

                Item item = new Item();
                item.setDescription(product_description);
                item.setCode(item_code);
                item.setYear(item_year);
                item.setLength(length);
                item.setWidth(width);
                item.setCleaningCharge(cleaning_charge);
                item.setStoringCharge(storing_charge);
                item.setMendingCharge(mending_charge);

                reports.get(id).getItems().add(item);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return reports;

    }

    public void cancelReport(String reportId) {

        String reportQuery = "UPDATE report SET status='canceled' WHERE id=?;";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery)) {
            ps_report.setString(1, reportId);

            ps_report.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void deliverReport(String reportId, String deliveryReceiptNumber) {

        String reportQuery = "UPDATE report SET status='delivered', number=? WHERE id=?;";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery)) {
            ps_report.setString(1, deliveryReceiptNumber);
            ps_report.setString(2, reportId);

            ps_report.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
