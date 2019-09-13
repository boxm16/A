/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.CustomerDao;
import Models.Customer;

/**
 *
 * @author Michail Sitmalidis
 */
public class CustomerController {

    CustomerDao customerDao;

    public CustomerController() {
        customerDao = new CustomerDao();
    }

    public Customer getCustomerById(int id) {

        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

}
