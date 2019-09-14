/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Customer;
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
                customer.setNote(rs.getString("note"));
                customer.setStreet(rs.getString("street"));
                customer.setDistrict(rs.getString("district"));
                customer.setPostalCode(rs.getString("postal_code"));
                customer.setFloor(rs.getString("floor"));
                customer.setBellName(rs.getString("bell_name"));
                customer.setAlternativeStreet(rs.getString("alternative_street"));
                customer.setAlternativeDistrict(rs.getString("alternative_district"));
                customer.setAlternativePostalCode(rs.getString("alternative_postal_code"));
                customer.setAlternativeFloor(rs.getString("alternative_floor"));
                customer.setAlternativeBellName(rs.getString("alternative_bell_name"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return customer;
    }

    public ArrayList<Customer> getCustomersByLastName(String lastName) {

        ArrayList<Customer> customers = new ArrayList();
        String query = "SELECT customer_id, first_name, last_name, landline_phone, mobile_phone, street, district "
                + "FROM customer WHERE LOWER(last_name) LIKE LOWER(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, lastName + "%");
            System.out.println(lastName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setLandlinePhone(rs.getString("landline_phone"));
                customer.setMobilePhone(rs.getString("mobile_phone"));
                customer.setStreet(rs.getString("street"));
                customer.setDistrict(rs.getString("district"));
                customers.add(customer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return customers;
    }

    public ArrayList<Customer> getCustomerByLandLineNumber(String landLine) {
        ArrayList<Customer> customers = new ArrayList();
        String query = "SELECT customer_id, first_name, last_name, landline_phone, mobile_phone, street, district "
                + "FROM customer WHERE landline_phone LIKE ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, landLine + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setLandlinePhone(rs.getString("landline_phone"));
                customer.setMobilePhone(rs.getString("mobile_phone"));
                customer.setStreet(rs.getString("street"));
                customer.setDistrict(rs.getString("district"));
                customers.add(customer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return customers;
    }

    public ArrayList<Customer> getCustomerByMobileNumber(String mobile) {
        ArrayList<Customer> customers = new ArrayList();
        String query = "SELECT customer_id, first_name, last_name, landline_phone, mobile_phone, street, district "
                + "FROM customer WHERE mobile_phone LIKE ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, mobile + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setLandlinePhone(rs.getString("landline_phone"));
                customer.setMobilePhone(rs.getString("mobile_phone"));
                customer.setStreet(rs.getString("street"));
                customer.setDistrict(rs.getString("district"));
                customers.add(customer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return customers;
    }
}
