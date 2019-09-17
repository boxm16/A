/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.math.BigDecimal;

/**
 *
 * @author Michail Sitmalidis
 */
public class Product {

    private int id;
    private String description;
    private BigDecimal cleaningPrice;
    private BigDecimal storingPrice;

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCleaningPrice(BigDecimal cleaningPrice) {
        this.cleaningPrice = cleaningPrice;
    }

    public void setStoringPrice(BigDecimal storingPrice) {
        this.storingPrice = storingPrice;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getCleaningPrice() {
        return cleaningPrice;
    }

    public BigDecimal getStoringPrice() {
        return storingPrice;
    }

}
