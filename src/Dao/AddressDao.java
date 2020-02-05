/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class AddressDao {

    Connection connection;

    public AddressDao() {

    }

    public HashMap<String, ArrayList> getDistrictList() {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();
//i use linkedHashMap because it preserve insertion order, while simple hashMap does 
        LinkedHashMap<String, ArrayList> districtsList = new LinkedHashMap<>();
        String query = " SELECT district, postal_code FROM post_box   GROUP BY district, postal_code ORDER BY district ASC, postal_code ASC;";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String district = rs.getString("district");
                String postal_code = rs.getString("postal_code");

                if (districtsList.containsKey(district)) {
                    districtsList.get(district).add(postal_code);
                } else {
                    ArrayList<String> postal_codes = new ArrayList();
                    postal_codes.add(postal_code);

                    districtsList.put(district, postal_codes);

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return districtsList;
    }

    public ArrayList<String> getPostalCodesList(String district) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

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
