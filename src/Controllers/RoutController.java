/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.RoutDao;
import Models.Rout;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michail Sitmalidis
 */
public class RoutController {

    RoutDao routDao;
    ArrayList<Rout> existingRouts;

    public RoutController() {
        routDao = new RoutDao();
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
      return  routDao.getRout(routId);
    }

}
