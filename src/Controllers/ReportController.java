/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.ReportDao;
import Models.Report;

/**
 *
 * @author Michail Sitmalidis
 */
public class ReportController {

    ReportDao reportDao;

    public ReportController() {
        reportDao = new ReportDao();

    }

    public void saveReport(Report report) {
        reportDao.saveReport(report);
    }

    public int insertDeliveryReport(Report report) {

        int reportId = reportDao.insertDeliveryReport(report);
        return reportId;
    }

}
