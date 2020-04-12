/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Customer;
import Models.Item;
import Models.Report;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class ReportDao {

    Connection connection;

    public ReportDao() {
    }

    public void createAndSavePickUpReport(Report report) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String reportQuery = "INSERT INTO report (date, number, customer_id, type, status, rout_id) "
                + "VALUES (?,?,?,?,?,?);";
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
            ps_report.setInt(5, 0);
            ps_report.execute();

            ResultSet rs = last_report_id_st.executeQuery(last_report_id_query);
            int increment_number = 0;
            while (rs.next()) {
                increment_number = rs.getInt("AUTO_INCREMENT");
            }
            for (Item item : report.getItems()) {

                ps_item.setInt(1, item.getId());
                ps_item.setInt(2, item.getCode());
                ps_item.setString(3, "2020");
                System.out.println("need work here too ReportDao for year");
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
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

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

    public ArrayList<Report> getAllDeliveryReports() {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        //HashMap<Integer, Report> reports = new HashMap<>();
        ArrayList<Integer> IDs = new ArrayList();
        ArrayList<Report> reports = new ArrayList<>();

        String reportQuery = "SELECT first_name, last_name, landline_phone, mobile_phone,    "
                + "street, district, floor, postal_code, doorbell_name, customer.note, "
                + "product_description, spot, item_code, item_year, length, width, "
                + "cleaning, storing, "
                + "cleaning_price, storing_price, mending_charge, "
                + " r.id, date   "
                + " FROM customer  "
                + "INNER JOIN report r ON customer.id=r.customer_id "
                + "INNER JOIN item i ON i.delivery_report_id=r.id "
                + "INNER JOIN product p ON p.product_id=i.product_id "
                + "WHERE r.status='scheduled' ORDER BY date, r.id;";
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
                String bell_name = rs.getString("doorbell_name");
                String note = rs.getString("customer.note");
                String product_description = rs.getString("product_description");
                String spot = rs.getString("spot");
                int item_code = rs.getInt("item_code");
                int item_year = rs.getInt("item_year");
                BigDecimal length = rs.getBigDecimal("length");
                BigDecimal width = rs.getBigDecimal("width");
                boolean cleaning = rs.getBoolean("cleaning");
                boolean storing = rs.getBoolean("storing");

                BigDecimal cleaning_price = rs.getBigDecimal("cleaning_price");
                BigDecimal storing_price = rs.getBigDecimal("storing_price");
                BigDecimal mending_charge = rs.getBigDecimal("mending_charge");
                int id = rs.getInt("id");
                String strDate = rs.getString("date");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(strDate);

                Report report = new Report();
                report.setDate(date);
                report.setId(id);
                if (!IDs.contains(id)) {

                    Customer customer = new Customer();

                    customer.setFirstName(first_name);
                    customer.setLastName(last_name);
                    customer.setLandlinePhone(landline_phone);
                    customer.setMobilePhone(mobile_phone);
                    customer.setDistrict(district);
                    customer.setStreet(street);
                    customer.setPostalCode(postal_code);
                    customer.setFloor(floor);
                    customer.setDoorbellName(bell_name);
                    report.setCustomer(customer);

                    IDs.add(id);
                    reports.add(report);
                }

                Item item = new Item();
                item.setDescription(product_description);
                item.setSpot(spot);
                item.setCode(item_code);
                item.setYear(item_year);
                item.setLength(length);
                item.setWidth(width);
                item.setForCleaning(cleaning);
                item.setForStoring(storing);
                item.setCleaningPrice(cleaning_price);
                item.setStoringPrice(storing_price);
                item.setMendingCharge(mending_charge);

                int index = IDs.indexOf(id);
                reports.get(index).getItems().add(item);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ParseException ex) {
            Logger.getLogger(ReportDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reports;
    }

    public ArrayList<Report> getDeliveryReportsForDate(Date date) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        // HashMap<Integer, Report> reports = new HashMap<>();
        ArrayList<Integer> IDs = new ArrayList();
        ArrayList<Report> reports = new ArrayList<>();

        String string_date = getStringFromDate(date);

        String reportQuery = "SELECT first_name, last_name, landline_phone, mobile_phone,    "
                + "street, district, floor, postal_code, doorbell_name, customer.note, "
                + "product_description, spot, item_code, item_year, length, width, "
                + "cleaning, storing, "
                + "cleaning_price, storing_price, mending_charge, "
                + "  r.id  "
                + " FROM customer  "
                + "INNER JOIN report r ON customer.id=r.customer_id "
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
                String bell_name = rs.getString("doorbell_name");
                String note = rs.getString("customer.note");
                String product_description = rs.getString("product_description");
                String spot = rs.getString("spot");
                int item_code = rs.getInt("item_code");
                int item_year = rs.getInt("item_year");
                BigDecimal length = rs.getBigDecimal("length");
                BigDecimal width = rs.getBigDecimal("width");
                boolean cleaning = rs.getBoolean("cleaning");
                boolean storing = rs.getBoolean("storing");
                BigDecimal cleaning_price = rs.getBigDecimal("cleaning_price");
                BigDecimal storing_price = rs.getBigDecimal("storing_price");
                BigDecimal mending_charge = rs.getBigDecimal("mending_charge");

                int id = rs.getInt("id");

                Report report = new Report();
                report.setId(id);
                report.setDate(date);

                if (!IDs.contains(id)) {

                    Customer customer = new Customer();

                    customer.setFirstName(first_name);
                    customer.setLastName(last_name);
                    customer.setLandlinePhone(landline_phone);
                    customer.setMobilePhone(mobile_phone);
                    customer.setDistrict(district);
                    customer.setStreet(street);
                    customer.setPostalCode(postal_code);
                    customer.setFloor(floor);
                    customer.setDoorbellName(bell_name);
                    report.setCustomer(customer);

                    IDs.add(id);
                    reports.add(report);
                }

                Item item = new Item();
                item.setDescription(product_description);
                item.setSpot(spot);
                item.setCode(item_code);
                item.setYear(item_year);
                item.setLength(length);
                item.setWidth(width);
                item.setForCleaning(cleaning);
                item.setForStoring(storing);
                item.setCleaningPrice(cleaning_price);
                item.setStoringPrice(storing_price);
                item.setMendingCharge(mending_charge);

                int index = IDs.indexOf(id);
                reports.get(index).getItems().add(item);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return reports;

    }

    public void cancelDeliveryReport(String reportId) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String reportQuery = "UPDATE report SET status='canceled' WHERE id=?;";
        String itemQuery = "UPDATE item SET status='ready' WHERE delivery_report_id=?;";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery);
                PreparedStatement item_report = connection.prepareStatement(itemQuery);) {
            ps_report.setString(1, reportId);

            ps_report.execute();

            item_report.setString(1, reportId);
            item_report.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void deliverReport(String reportId, String deliveryReceiptNumber) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String reportQuery = "UPDATE report SET status='delivered', number=? WHERE id=?;";
        String itemQuery = "UPDATE item SET status='delivered' WHERE delivery_report_id=?;";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery);
                PreparedStatement item_report = connection.prepareStatement(itemQuery)) {
            ps_report.setString(1, deliveryReceiptNumber);
            ps_report.setString(2, reportId);

            ps_report.execute();

            item_report.setString(1, reportId);
            item_report.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void createPickUpReport(Report report) {

        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String reportQuery = "INSERT INTO report(date, number, customer_id, type, status, route_id) "
                + "VALUES(?,?,?,?,?,?);";

        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery)) {
            ps_report.setString(1, getStringFromDate(report.getDate()));
            ps_report.setInt(2, report.getNumber());
            ps_report.setInt(3, report.getCustomer().getId());
            ps_report.setString(4, report.getType().toString());
            ps_report.setString(5, "scheduled");
            ps_report.setInt(6, report.getRoute_id());
            ps_report.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void cancelPickUpReport(int report_id) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String reportQuery = "UPDATE report SET status='canceled' WHERE id=? ;";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery)) {
            ps_report.setInt(1, report_id);
            ps_report.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public LinkedHashMap<Integer, String> getScheduledPickUpList(int customer_id) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        LinkedHashMap<Integer, String> scheduledPickUpList = new LinkedHashMap();
        String reportQuery = "SELECT report.id, date, name FROM report"
                + " INNER JOIN rout ON rout.id=report.route_id"
                + " WHERE report.status='scheduled' AND report.type='PICKUP' AND report.customer_id=?; ";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery)) {
            ps_report.setInt(1, customer_id);
            ResultSet rs = ps_report.executeQuery();
            while (rs.next()) {
                int report_id = rs.getInt("id");
                String date = rs.getString("date");
                String name = rs.getString("name");
                String scheduledRoute = date + "-" + name;
                scheduledPickUpList.put(report_id, scheduledRoute);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return scheduledPickUpList;

    }

    public void savePickUpReport(Report report) {

        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String reportQuery = "UPDATE report SET  number=?, status=? WHERE id=?";
        String itemQuery = "INSERT INTO item (product_id, item_code, item_year, cleaning, storing, mending, receiving_report_id, note, status)"
                + " VALUES (?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery);
                PreparedStatement ps_item = connection.prepareStatement(itemQuery)) {
            ps_report.setInt(1, report.getNumber());
            ps_report.setString(2, "completed");
            ps_report.setInt(3, report.getId());
            ps_report.execute();
            for (Item item : report.getItems()) {

                ps_item.setInt(1, item.getId());
                ps_item.setInt(2, item.getCode());
                ps_item.setString(3, "2020");
                System.out.println("need work here too ReportDao for year");
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
                ps_item.setInt(7, report.getId());
                ps_item.setString(8, item.getNote());
                ps_item.setString(9, "processing");
                ps_item.addBatch();
            }
            ps_item.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public ArrayList<Report> getScheduledPickUps() {

        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        ArrayList<Report> scheduledPickUps = new ArrayList();

        String reportQuery = "SELECT  date, customer.id, last_name, first_name FROM report"
                + " INNER JOIN customer ON report.customer_id=customer.id"
                + " WHERE report.status='scheduled' AND report.type='PICKUP' ORDER BY date; ";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery)) {
            ResultSet rs = ps_report.executeQuery();
            while (rs.next()) {
                Report report = new Report();

                String string_date = rs.getString("date");
                DateFormat formatter = new SimpleDateFormat("yy-mm-dd");
                Date date = null;
                try {
                    date = formatter.parse(string_date);
                } catch (ParseException ex) {
                    Logger.getLogger(ReportDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                report.setDate(date);

                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setLastName(rs.getString("last_name"));
                customer.setFirstName(rs.getString("first_name"));

                report.setCustomer(customer);

                scheduledPickUps.add(report);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return scheduledPickUps;

    }

    public void saveAndCreateDeliveryReport(Report report) {

        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String reportQuery = "INSERT INTO report (date, number, customer_id, type, status, route_id) "
                + "VALUES (?,?,?,?,?,?);";
        String last_report_id_query = "SELECT MAX(id) AS AUTO_INCREMENT FROM report";
        String itemQuery = "UPDATE item SET delivery_report_id=?, status=? WHERE item_code=? and item_year=?";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery);
                PreparedStatement ps_item = connection.prepareStatement(itemQuery);
                Statement last_report_id_st = connection.createStatement();) {
            ps_report.setString(1, getStringFromDate(report.getDate()));
            ps_report.setInt(2, report.getNumber());
            ps_report.setInt(3, report.getCustomer().getId());
            ps_report.setString(4, report.getType().toString());
            ps_report.setString(5, "scheduled");
            ps_report.setInt(6, report.getRoute_id());
            ps_report.execute();

            ResultSet rs = last_report_id_st.executeQuery(last_report_id_query);
            int increment_number = 0;
            while (rs.next()) {
                increment_number = rs.getInt("AUTO_INCREMENT");
            }
            for (Item item : report.getItems()) {

                ps_item.setInt(1, increment_number);
                ps_item.setString(2, "delivery_scheduled");
                ps_item.setInt(3, item.getCode());
                ps_item.setInt(4, item.getYear());
                ps_item.addBatch();
            }
            ps_item.executeBatch();

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
