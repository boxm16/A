/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class ItemDao {

    Connection connection;

    public ItemDao() {
        connection = DataBaseConnection.getDBCInstance().getConnection();
    }

    public ArrayList<Item> getCustomerItems(int customerId) {
        ArrayList<Item> customerItems = new ArrayList<Item>();
        String itemListQuery = "SELECT * FROM item "
                + "INNER JOIN product ON item.product_id=product.product_id "
                + "INNER JOIN receiving_report ON receiving_report.receiving_report_id=item.receiving_report_id"
                + " WHERE customer_id=?; ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(itemListQuery)) {
            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Item item = new Item();

                item.setId(rs.getInt("product_id"));
                item.setDescription(rs.getString("product_description"));
                item.setCode(rs.getInt("item_code"));
                item.setCleaningPrice(rs.getBigDecimal("cleaning_price"));
                item.setStoringPrice(rs.getBigDecimal("storing_price"));

                item.setLength(rs.getBigDecimal("length"));
                item.setWidth(rs.getBigDecimal("width"));
                System.out.println(rs.getBoolean("cleaning"));

                item.setForCleaning(rs.getBoolean("cleaning"));
                item.setForStoring(rs.getBoolean("storing"));

                item.setMendingCharge(rs.getBigDecimal("mending_charge"));

               item.setReceivingReportId(rs.getInt("receiving_report_id"));
                item.setStatus(rs.getString("status"));
                item.setNote(rs.getString("note"));
                customerItems.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return customerItems;
    }

}
