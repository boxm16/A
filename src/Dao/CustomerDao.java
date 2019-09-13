/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class CustomerDao {

    Connection connection;

    public CustomerDao() {
        connection = DAO.DataBaseConnection.getDBCInstance().getConnection();
    }

    public Customer getCustomerById(int id) {
        Customer customer = null;
        String query = "SELECT * FROM customer WHERE customer_id=" + id + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                customer = new Customer();
                customer.setId(id);
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setLandlinePhone(rs.getString("landline_phone"));
                customer.setMobilePhone(rs.getString("mobile_phone"));
                customer.setStreet(rs.getString("street"));
                customer.setDistrict(rs.getString("district"));
                customer.setPostalCode(rs.getString("postal_code"));
                customer.setFloor(rs.getString("floor"));
                customer.setBellName(rs.getString("bell_name"));
                customer.setNote(rs.getString("note"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return customer;
    }

}
