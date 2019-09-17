/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import java.util.ArrayList;

/**
 *
 * @author Michail Sitmalidis
 */
public class Report {

    private int id;

    private enum Type {
        RECEIVING, DELIVERY
    }
    private Type type;
    private String date;
    private int number;
    private Customer customer;
    private ArrayList<Item> items;

    public Report() {
    }

    public Report(Type type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDate(String date) {
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

    public String getDate() {
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



}
