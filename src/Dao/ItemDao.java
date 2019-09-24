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
import java.sql.Statement;
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
                + "INNER JOIN report ON report.id=item.receiving_report_id"
                + " WHERE customer_id=?; ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(itemListQuery)) {
            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Item item = new Item();

                item.setId(rs.getInt("product_id"));
                item.setDescription(rs.getString("product_description"));
                item.setCode(rs.getInt("item_code"));
                item.setYear(rs.getInt("item_year"));
                item.setCleaningPrice(rs.getBigDecimal("cleaning_price"));
                item.setStoringPrice(rs.getBigDecimal("storing_price"));

                item.setLength(rs.getBigDecimal("length"));
                item.setWidth(rs.getBigDecimal("width"));
                //   System.out.println(rs.getBoolean("cleaning"));

                item.setForCleaning(rs.getBoolean("cleaning"));
                item.setForStoring(rs.getBoolean("storing"));
                item.setForMending(rs.getBoolean("mending"));

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

    public boolean itemCodeRegisteredInDb(int itemCode) {
        boolean registered = false;
        String query = "SELECT * FROM item WHERE item_code=" + itemCode + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                registered = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registered;
    }

    public Item getItemByCode(String code, String year) {
        Item item = null;
        String query = "SELECT * FROM item "
                + "INNER JOIN product ON item.product_id=product.product_id"
                + " WHERE item_code=? and item_year=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, year);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                item = new Item();

                item.setId(rs.getInt("product_id"));
                item.setDescription(rs.getString("product_description"));
                item.setCode(rs.getInt("item_code"));
                item.setYear(rs.getInt("item_year"));
                item.setCleaningPrice(rs.getBigDecimal("cleaning_price"));
                item.setStoringPrice(rs.getBigDecimal("storing_price"));

                item.setLength(rs.getBigDecimal("length"));
                item.setWidth(rs.getBigDecimal("width"));
                //   System.out.println(rs.getBoolean("cleaning"));

                item.setForCleaning(rs.getBoolean("cleaning"));
                item.setForStoring(rs.getBoolean("storing"));
                item.setForMending(rs.getBoolean("mending"));
                
                item.setCleaningCharge(rs.getBigDecimal("cleaning_charge"));
                item.setStoringCharge(rs.getBigDecimal("storing_charge"));
                item.setMendingCharge(rs.getBigDecimal("mending_charge"));

                item.setReceivingReportId(rs.getInt("receiving_report_id"));
                item.setStatus(rs.getString("status"));
                item.setNote(rs.getString("note"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return item;
    }

    public void updateItemDimensions(Item item) {

        String query = "UPDATE item SET length=?, width=? WHERE item_code=? and item_year=?;";
        
        if (!item.isForMending()||(item.isForMending()&&item.getMendingCharge() != null)) {//εαν den ειναι για επιδιορωθση 'η ε'ιναι και εχει γινει επιδιορθωση, πλεον ειναι ετοιμο γα παραδοση
            query = "UPDATE item SET length=?, width=?, status='ready' WHERE item_code=? and item_year=?;";
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBigDecimal(1, item.getLength());
            preparedStatement.setBigDecimal(2, item.getWidth());
            preparedStatement.setInt(3, item.getCode());
            preparedStatement.setInt(4, item.getYear());
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
