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
public class Item extends Product {

    private int code;
    private int year;

    private BigDecimal length;
    private BigDecimal width;
    private boolean forCleaning;
    private boolean forStoring;
    private boolean forMending;
    private BigDecimal cleaningCharge;
    private BigDecimal storingCharge;
    private BigDecimal mendingCharge;
    private String note;

    private int receivingReportId;

    private String status;

    private int deliveryReportId;

    public void setCode(int code) {
        this.code = code;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public void setForCleaning(boolean forCleaning) {
        this.forCleaning = forCleaning;
    }

    public void setForStoring(boolean forStoring) {
        this.forStoring = forStoring;
    }

    public void setForMending(boolean forMending) {
        this.forMending = forMending;
    }

    public void setCleaningCharge(BigDecimal cleaningCharge) {
        this.cleaningCharge = cleaningCharge;
    }

    public void setStoringCharge(BigDecimal storingCharge) {
        this.storingCharge = storingCharge;
    }

    public void setMendingCharge(BigDecimal mendingCharge) {
        this.mendingCharge = mendingCharge;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setReceivingReportId(int receivingReportId) {
        this.receivingReportId = receivingReportId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeliveryReportId(int deliveryReportId) {
        this.deliveryReportId = deliveryReportId;
    }

    public int getCode() {
        return code;
    }

    public BigDecimal getLength() {
        return length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public boolean isForCleaning() {
        return forCleaning;
    }

    public boolean isForStoring() {
        return forStoring;
    }

    public boolean isForMending() {
        return forMending;
    }

    public BigDecimal getCleaningCharge() {
        return cleaningCharge;
    }

    public BigDecimal getStoringCharge() {
        return storingCharge;
    }

    public BigDecimal getMendingCharge() {
        return mendingCharge;
    }

    public String getNote() {
        return note;
    }

    public int getReceivingReportId() {
        return receivingReportId;
    }

    public String getStatus() {
        return status;
    }

    public int getDeliveryReportId() {
        return deliveryReportId;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

}
