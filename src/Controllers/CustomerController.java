/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.CustomerDao;
import Models.Customer;
import Tools.Mail;
import Tools.NewCustomerIdentifier;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Michail Sitmalidis
 */
public class CustomerController {

    private CustomerDao customerDao;
    private Mail mail;

    public CustomerController() {
        customerDao = new CustomerDao();
        mail = new Mail();
    }

    public Customer getCustomerById(int id) {

        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    public ArrayList<Customer> getCustomerByLastName(String lastName) {
        ArrayList<Customer> customers = customerDao.getCustomersByLastName(lastName);
        return customers;
    }

    public ArrayList<Customer> getCustomerByLandLineNumber(String landLine) {
        ArrayList<Customer> customers = customerDao.getCustomerByLandLineNumber(landLine);
        return customers;
    }

    public ArrayList<Customer> getCustomerByMobileNumber(String mobile) {
        ArrayList<Customer> customers = customerDao.getCustomerByMobileNumber(mobile);
        return customers;
    }

    public String saveNewCustomer(Customer customer) {
        String identifier = NewCustomerIdentifier.getIdentifier();
        customer.setEmailIdentifier(identifier);
        customer.setPassword(identifier);
        customer.setStatus("temporary");
        customerDao.saveCustomer(customer);
        return identifier;//i return identifier so i can load new customer again for display,
        //  because he doesnt have id yet
    }

    public void editCustomer(Customer customer) {
        customerDao.editCustomer(customer);
    }

    public boolean checkCustomerById(int id) {
        Customer customer = getCustomerById(id);
        if (customer == null) {
            JOptionPane.showMessageDialog(null,
                    "ΔΕΝ ΥΠΑΡΧΕΙ ΠΕΛΑΤΗΣ ΜΕ ΑΥΤΟ ΤΟΝ ΚΩΔΙΚΟ",
                    "ΛΑΘΟΣ ΚΩΔΙΚΟΣ ΠΕΛΑΤΗ",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<Customer> getReadyToGoCustomers() {
        return customerDao.getReadyToGoCustomers();
    }

    public void initConnection() {
    }

    public Customer getCustomerByIdentifier(String identifier) {
        Customer customer = new Customer();
        customer = customerDao.getCustomerByIdentifier(identifier);
        return customer;
    }

    public HashMap<String, String> getPendingConfirmationRequests() {
        return customerDao.getPendingConfirmationRequests();
    }

    public void sendConfirmationRequests(HashMap<String, String> pendingConfirmationRequests) {

        for (String email : pendingConfirmationRequests.keySet()) {
            if (mail.confirmationMailSent(email, pendingConfirmationRequests.get(email))) {
                customerDao.sendConfirmationRequests(email);
            }
        }
    }

    public int getConectionsCount() {
        return customerDao.getConnectionsCount();
    }

}
