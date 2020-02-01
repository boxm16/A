/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Dao.DataBaseConnection;
import java.sql.Connection;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Michail Sitmalidis
 */
public class Scheduler {

    Connection connection;
    TimerTask task;

    public Scheduler() {
        task = new TimerTask() {
            public void run() {
                connection = DataBaseConnection.getDBCInstance().getConnection();
            }
        };

    }

    public void startConnectionScheduler() {
        Timer timer = new Timer("ConnectionTimer");

        int delay = 1000;
        timer.schedule(task, delay);
    }

}
