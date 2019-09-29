/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class AddressDao {

    Connection connection;

    public AddressDao() {

        connection = DataBaseConnection.getDBCInstance().getConnection();
    }

    public ArrayList<String> getDistrictList() {
        ArrayList<String> districtsList = new ArrayList<>();
        String query = " SELECT district FROM post_box  GROUP BY district ORDER BY MAX(district) ASC";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                districtsList.add(rs.getString("district"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return districtsList;
    }

    public ArrayList<String> getPostalCodesList(String district) {

        ArrayList<String> postal_codesList = new ArrayList<>();
        String query = " SELECT postal_code FROM post_box WHERE district='" + district + "'  "
                + "GROUP BY postal_code ORDER BY MAX(postal_code) ASC";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                postal_codesList.add(rs.getString("postal_code"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return postal_codesList;

    }

}
