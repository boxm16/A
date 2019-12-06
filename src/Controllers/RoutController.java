/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.RoutDao;
import Models.Report;
import Models.Rout;
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
public class RoutController {

    RoutDao routDao;
    ArrayList<Rout> existingRouts;
    ArrayList<Integer> availableRoutsId;
    ArrayList<String> availableRoutsDate;

    public RoutController() {
        routDao = new RoutDao();
        availableRoutsId = new ArrayList<>();
        availableRoutsDate = new ArrayList<>();

    }

    public void saveRout(Rout rout) {
        routDao.saveRout(rout);
    }

    public ArrayList<Rout> getExistingRouts() {
        existingRouts = routDao.getExistingRouts();

        return existingRouts;
    }

    public void deleteRout(int rout_id) {
        routDao.deleteRout(rout_id);
    }

    public Rout getRout(int routId) {
        return routDao.getRout(routId);
    }

    public ArrayList<String> getAvailableRoutForDistrict(String district) {
        ArrayList<Rout> availableRouts = routDao.getAvailableRoutsForDistrict(district);
        ZoneId athensZone = ZoneId.of("Europe/Athens");
        LocalDate fromDate = LocalDate.now(athensZone);
        LocalDate tillDate = fromDate.plusDays(14);
        ArrayList<String> availableDays = new ArrayList<>();
        availableRoutsId.clear();
        availableRoutsDate.clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        for (Rout rout : availableRouts) {

            for (LocalDate x = fromDate; x.isBefore(tillDate); x = x.plusDays(1)) {
                if (x.getDayOfWeek() == DayOfWeek.MONDAY && rout.isDay_1()) {

                    availableDays.add(formatter.format(x) + "-ΔΕΥΤΕΡΑ " + ":" + rout.getName());
                    availableRoutsId.add(rout.getId());
                    availableRoutsDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.TUESDAY && rout.isDay_2()) {
                    availableDays.add(formatter.format(x) + "-ΤΡΙΤΗ " + ":" + rout.getName());
                    availableRoutsId.add(rout.getId());
                    availableRoutsDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.WEDNESDAY && rout.isDay_3()) {
                    availableDays.add(formatter.format(x) + "-ΤΕΤΑΡΤΗ " + ":" + rout.getName());
                    availableRoutsId.add(rout.getId());
                    availableRoutsDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.THURSDAY && rout.isDay_4()) {
                    availableDays.add(formatter.format(x) + "-ΠΕΜΠΤΗ " + ":" + rout.getName());
                    availableRoutsId.add(rout.getId());
                    availableRoutsDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.FRIDAY && rout.isDay_5()) {
                    availableDays.add(formatter.format(x) + "-ΠΑΡΑΣΚΕΥΗ " + ":" + rout.getName());
                    availableRoutsId.add(rout.getId());
                    availableRoutsDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.SATURDAY && rout.isDay_6()) {
                    availableDays.add(formatter.format(x) + "-ΣΑΒΒΑΤΟ " + ":" + rout.getName());
                    availableRoutsId.add(rout.getId());
                    availableRoutsDate.add(formatter2.format(x));
                }
                if (x.getDayOfWeek() == DayOfWeek.SUNDAY && rout.isDay_7()) {
                    availableDays.add(formatter.format(x) + "-ΚΥΡΙΑΚΗ " + ":" + rout.getName());
                    availableRoutsId.add(rout.getId());
                    availableRoutsDate.add(formatter2.format(x));
                }

            }
        }

        return availableDays;
    }

    public int insertDRout(int index) {
        int dRoutId = 0;
        int routId = availableRoutsId.get(index);
        String date = availableRoutsDate.get(index);

        dRoutId = routDao.getD_Rout(routId, date);
        if (dRoutId == 0) {
            routDao.insertDRout(routId, date);
        }
        dRoutId = routDao.getD_Rout(routId, date);
        return dRoutId;
    }

    public void inserDRout_Report(int DRoutId, int reportId) {

        routDao.insertDRout_Report(DRoutId, reportId);
    }

    public Date getDRoutDate(int index) {
        return Date.valueOf(availableRoutsDate.get(index));
    }
}
