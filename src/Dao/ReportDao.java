/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Item;
import Models.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        String reportQuery = "INSERT INTO report (date, number, customer_id, type) "
                + "VALUES (?,?,?,?);";
        String last_report_id_query = "SELECT MAX(id) AS AUTO_INCREMENT FROM report";
        String itemQuery = "INSERT INTO item (product_id, item_code, cleaning, storing, mending, receiving_report_id, note, status)"
                + " VALUES (?,?,?,?,?,?,?,?);";
        try (PreparedStatement ps_report = connection.prepareStatement(reportQuery);
                PreparedStatement ps_item = connection.prepareCall(itemQuery);
                Statement last_report_id_st = connection.createStatement();) {
            ps_report.setString(1, getStringFromDate(report.getDate()));
            ps_report.setInt(2, report.getNumber());
            ps_report.setInt(3, report.getCustomer().getId());
            ps_report.setString(4, report.getType().toString());
            ps_report.execute();

            ResultSet rs = last_report_id_st.executeQuery(last_report_id_query);
            int increment_number = 0;
            while (rs.next()) {
                increment_number = rs.getInt("AUTO_INCREMENT");
            }
            for (Item item : report.getItems()) {

                ps_item.setInt(1, item.getId());
                ps_item.setInt(2, item.getCode());
                if (item.isForCleaning()) {
                    ps_item.setInt(3, 1);
                } else {
                    ps_item.setInt(3, 0);
                }
                if (item.isForStoring()) {
                    ps_item.setInt(4, 1);
                } else {
                    ps_item.setInt(4, 0);
                }
                if (item.isForMending()) {
                    ps_item.setInt(5, 1);
                } else {
                    ps_item.setInt(5, 0);
                }
                ps_item.setInt(6, increment_number);
                ps_item.setString(7, item.getNote());
                ps_item.setString(8, "received");
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

}
