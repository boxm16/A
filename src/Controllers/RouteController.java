/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.RouteDao;
import Models.Report;
import Models.Route;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Michail Sitmalidis
 */
public class RouteController {

    RouteDao routeDao;
    ArrayList<Route> existingRoutes;
    ArrayList<Integer> availableRoutesId;
    ArrayList<String> availableRoutesDate;

    public RouteController() {
        routeDao = new RouteDao();
        availableRoutesId = new ArrayList<>();
        availableRoutesDate = new ArrayList<>();

    }

    public void saveRout(Route rout) {
        routeDao.saveRout(rout);
    }

    public ArrayList<Route> getExistingRouts() {
        existingRoutes = routeDao.getExistingRouts();

        return existingRoutes;
    }

    public void deleteRout(int rout_id) {
        routeDao.deleteRout(rout_id);
    }

    public Route getRout(int routId) {
        return routeDao.getRout(routId);
    }

    public ArrayList<String> getAvailableRoutForDistrict(String postal_code) {
        ArrayList<Route> availableRouts = routeDao.getAvailableRoutsForDistrict(postal_code);
        ZoneId athensZone = ZoneId.of("Europe/Athens");
        LocalDate fromDate = LocalDate.now(athensZone);
        LocalDate tillDate = fromDate.plusDays(14);
        ArrayList<String> availableDays = new ArrayList<>();
        availableRoutesId.clear();
        availableRoutesDate.clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        for (Route rout : availableRouts) {

            for (LocalDate x = fromDate; x.isBefore(tillDate); x = x.plusDays(1)) {
                if (x.getDayOfWeek() == DayOfWeek.MONDAY && rout.isDay_1()) {

                    availableDays.add(formatter.format(x) + "-ΔΕΥΤΕΡΑ " + ":" + rout.getName());
                    availableRoutesId.add(rout.getId());
                    availableRoutesDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.TUESDAY && rout.isDay_2()) {
                    availableDays.add(formatter.format(x) + "-ΤΡΙΤΗ " + ":" + rout.getName());
                    availableRoutesId.add(rout.getId());
                    availableRoutesDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.WEDNESDAY && rout.isDay_3()) {
                    availableDays.add(formatter.format(x) + "-ΤΕΤΑΡΤΗ " + ":" + rout.getName());
                    availableRoutesId.add(rout.getId());
                    availableRoutesDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.THURSDAY && rout.isDay_4()) {
                    availableDays.add(formatter.format(x) + "-ΠΕΜΠΤΗ " + ":" + rout.getName());
                    availableRoutesId.add(rout.getId());
                    availableRoutesDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.FRIDAY && rout.isDay_5()) {
                    availableDays.add(formatter.format(x) + "-ΠΑΡΑΣΚΕΥΗ " + ":" + rout.getName());
                    availableRoutesId.add(rout.getId());
                    availableRoutesDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.SATURDAY && rout.isDay_6()) {
                    availableDays.add(formatter.format(x) + "-ΣΑΒΒΑΤΟ " + ":" + rout.getName());
                    availableRoutesId.add(rout.getId());
                    availableRoutesDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.SUNDAY && rout.isDay_7()) {
                    availableDays.add(formatter.format(x) + "-ΚΥΡΙΑΚΗ " + ":" + rout.getName());
                    availableRoutesId.add(rout.getId());
                    availableRoutesDate.add(formatter2.format(x));
                }

            }
        }

        return availableDays;
    }

    public int insertDRout(int index) {
        int dRoutId = 0;
        int routId = availableRoutesId.get(index);
        String date = availableRoutesDate.get(index);

        dRoutId = routeDao.getD_Rout(routId, date);
        if (dRoutId == 0) {
            routeDao.insertDRout(routId, date);
        }
        dRoutId = routeDao.getD_Rout(routId, date);
        return dRoutId;
    }

    public void inserDRout_Report(int DRoutId, int reportId) {

        routeDao.insertDRout_Report(DRoutId, reportId);
    }

    public int getChosenRouteId(int index) {
        return availableRoutesId.get(index);
    }

    public Date getChosenRouteDate(int index) {

        return Date.valueOf(availableRoutesDate.get(index));
    }
}
