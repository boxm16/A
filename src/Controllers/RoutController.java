/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.RoutDao;
import Models.Rout;

/**
 *
 * @author Michail Sitmalidis
 */
public class RoutController {

    RoutDao routDao;

    public RoutController() {
        routDao = new RoutDao();
    }

    public void saveRout(Rout rout) {
        routDao.saveRout(rout);
    }
}
