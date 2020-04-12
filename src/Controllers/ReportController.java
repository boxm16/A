/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.ReportDao;
import Models.Report;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Michail Sitmalidis
 */
public class ReportController {

    ReportDao reportDao;

    public ReportController() {
        reportDao = new ReportDao();

    }

    public void savePickUpReport(Report report) {
        if (report.getId() == 0) {
            reportDao.createAndSavePickUpReport(report);
        }

        reportDao.savePickUpReport(report);
    }

    public int insertDeliveryReport(Report report) {

        int reportId = reportDao.insertDeliveryReport(report);
        return reportId;
    }

    public ArrayList<Report> getDeliveryReportsForDate(Date date) {

        ArrayList<Report> reports = reportDao.getDeliveryReportsForDate(date);

        return reports;
    }

    public void cancelDeliveryReport(String reportId) {

        reportDao.cancelDeliveryReport(reportId);

    }

    public void deliverReport(String reportId, String deliveryReceiptNumber) {
        reportDao.deliverReport(reportId, deliveryReceiptNumber);
    }

    public void createPickUpReport(Report report) {
        reportDao.createPickUpReport(report);
    }

    public void cancelPickUpReport(int report_id) {
        reportDao.cancelPickUpReport(report_id);
    }

    public LinkedHashMap<Integer, String> getSceduledPickUpList(int customer_id) {
        return reportDao.getScheduledPickUpList(customer_id);
    }

    public ArrayList<Report> getPickUpReports() {
        return reportDao.getScheduledPickUps();
    }

    public void createAndSaveDeliveryReport(Report report) {
        reportDao.saveAndCreateDeliveryReport(report);
    }

    public ArrayList< Report> getaAllDeliveryReports() {
        return reportDao.getAllDeliveryReports();
    }

}
