/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Michail Sitmalidis
 */
public class Report {

    private int id;
    private Date date;
    private int number;
    private Customer customer;

    public enum Type {
        PICKUP, DELIVERY
    }

    private Type type;

    private ArrayList<Item> items;
    private int route_id;

    public Report() {
        customer = new Customer();
        items = new ArrayList();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getRoute_id() {
        return route_id;
    }
    
    

}
