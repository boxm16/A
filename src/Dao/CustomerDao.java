/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Customer;
import java.beans.PropertyVetoException;
import java.io.IOException;
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
public class CustomerDao {

    Connection connection;

    public CustomerDao() {
    }

    public Customer getCustomerById(int id) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        Customer customer = null;
        String query = "SELECT * FROM customer WHERE id=" + id + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                customer = new Customer();
                customer.setId(id);
                customer.setEmailIdentifier(rs.getString("email_identifier"));
                customer.setPassword(rs.getString("password"));
                customer.setStatus(rs.getString("status"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setLandlinePhone(rs.getString("landline_phone"));
                customer.setMobilePhone(rs.getString("mobile_phone"));

                customer.setStreet(rs.getString("street"));
                customer.setDistrict(rs.getString("district"));
                customer.setPostalCode(rs.getString("postal_code"));
                customer.setFloor(rs.getString("floor"));
                customer.setDoorbellName(rs.getString("doorbell_name"));

                customer.setLongitude(rs.getString("longitude"));
                customer.setLatitude(rs.getString("latitude"));

                customer.setNote(rs.getString("note"));

            }
        } catch (SQLException ex) {

            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return customer;
    }

    public ArrayList<Customer> getCustomersByLastName(String lastName) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        ArrayList<Customer> customers = new ArrayList<>();
        String query = "SELECT id, first_name, last_name, landline_phone, mobile_phone, street, district "
                + "FROM customer WHERE LOWER(last_name) LIKE LOWER(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, lastName + "%");
            System.out.println(lastName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
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
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        ArrayList<Customer> customers = new ArrayList<>();
        String query = "SELECT id, first_name, last_name, landline_phone, mobile_phone, street, district "
                + "FROM customer WHERE landline_phone LIKE ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, landLine + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
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
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        ArrayList<Customer> customers = new ArrayList<>();
        String query = "SELECT id, first_name, last_name, landline_phone, mobile_phone, street, district "
                + "FROM customer WHERE mobile_phone LIKE ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, mobile + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
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

    public void saveCustomer(Customer customer) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String query = "INSERT INTO customer (email_identifier, password, status, "
                + "last_name, first_name, landline_phone, mobile_phone, note, "
                + "street, district, postal_code, floor, doorbell_name) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getEmailIdentifier());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getStatus());

            preparedStatement.setString(4, customer.getLastName());
            preparedStatement.setString(5, customer.getFirstName());
            preparedStatement.setString(6, customer.getLandlinePhone());
            preparedStatement.setString(7, customer.getMobilePhone());
            preparedStatement.setString(8, customer.getNote());
            preparedStatement.setString(9, customer.getStreet());
            preparedStatement.setString(10, customer.getDistrict());
            preparedStatement.setString(11, customer.getPostalCode());
            preparedStatement.setString(12, customer.getFloor());
            preparedStatement.setString(13, customer.getDoorbellName());

            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        System.out.println("fdfdf" + customer.getDistrict());
    }

    public void editCustomer(Customer customer) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String query = "UPDATE customer SET last_name=?, first_name=?, landline_phone=?, mobile_phone=?, note=?,"
                + " street=?, district=?, postal_code=?, floor=?, doorbell_name=?"
                + " WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getLastName());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLandlinePhone());
            preparedStatement.setString(4, customer.getMobilePhone());
            preparedStatement.setString(5, customer.getNote());
            preparedStatement.setString(6, customer.getStreet());
            preparedStatement.setString(7, customer.getDistrict());
            preparedStatement.setString(8, customer.getPostalCode());
            preparedStatement.setString(9, customer.getFloor());
            preparedStatement.setString(10, customer.getDoorbellName());

            preparedStatement.setInt(11, customer.getId());
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public ArrayList<Customer> getReadyToGoCustomers() {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        ArrayList<Customer> readyToGoCustomers = new ArrayList<>();
        String query = "SELECT customer.id, last_name, first_name FROM customer "
                + "Inner JOIN report ON customer.id=report.customer_id "
                + "INNER JOIN item ON report.id=item.receiving_report_id "
                + "WHERE NOT EXISTS (SELECT receiving_report_id FROM item where report.id=item.receiving_report_id and (status='processing' OR status='delivery_scheduled' OR status='delivered')) "
                + "GROUP BY customer.id;";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setLastName(rs.getString("last_name"));
                customer.setFirstName(rs.getString("first_name"));

                readyToGoCustomers.add(customer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return readyToGoCustomers;
    }

    public Customer getCustomerByIdentifier(String identifier) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        Customer customer = null;
        String query = "SELECT * FROM customer WHERE email_identifier='" + identifier + "';";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setEmailIdentifier(rs.getString("email_identifier"));
                customer.setPassword(rs.getString("password"));
                customer.setStatus(rs.getString("status"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setLandlinePhone(rs.getString("landline_phone"));
                customer.setMobilePhone(rs.getString("mobile_phone"));

                customer.setStreet(rs.getString("street"));
                customer.setDistrict(rs.getString("district"));
                customer.setPostalCode(rs.getString("postal_code"));
                customer.setFloor(rs.getString("floor"));
                customer.setDoorbellName(rs.getString("doorbell_name"));

                customer.setLongitude(rs.getString("long"));
                customer.setLatitude(rs.getString("lat"));

                customer.setNote(rs.getString("note"));

            }
        } catch (SQLException ex) {

            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return customer;
    }

    public HashMap<String, String> getPendingConfirmationRequests() {

        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        HashMap<String, String> pendingConfirmationRequests = new HashMap();
        String query = "SELECT * FROM verification_token WHERE status='letter_pending'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String token = rs.getString("url");//you may ask, why a save url+token
                //well because i dont know on which hoster i`m going to place my application

                pendingConfirmationRequests.put(email, token);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return pendingConfirmationRequests;

    }

    public void sendConfirmationRequests(String email) {

        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String query = "UPDATE verification_token SET status='letter_sent' WHERE email=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public int getConnectionsCount() {
        int connectionsCount = 0;
        try {

            connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();
            String query = "UPDATE verification_token SET status='letter_sent' WHERE email=?";
            String q = "SELECT COUNT(*) FROM information_schema.PROCESSLIST;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(q);
            while (rs.next()) {
                connectionsCount = rs.getInt("COUNT(*)");

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connectionsCount;
    }
}
