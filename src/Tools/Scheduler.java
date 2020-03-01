/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Controllers.CustomerController;
import Dao.ConnectionsDispatcher;
import GUI.MainFrame;

import java.util.HashMap;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Michail Sitmalidis
 */
public class Scheduler {

    MainFrame mainFrame;
    private CustomerController customerController;

    private TimerTask task;
    private final int DELAY = 0;
    private final int PERIOD = 1 * 30000;

    public Scheduler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        customerController = new CustomerController();
        task = new TimerTask() {
            public void run() {
                HashMap<String, String> pendingConfirmationRequests = customerController.getPendingConfirmationRequests();
                if (pendingConfirmationRequests.size() > 0) {
                    customerController.sendConfirmationRequests(pendingConfirmationRequests);

                }
                int connectionsCount = customerController.getConectionsCount();
                mainFrame.showConnectionsCountOnMainFrameHeader(connectionsCount);
                if (connectionsCount == 0) {
                    mainFrame.connectionRed();
                    ConnectionsDispatcher.getDispatcherInstance().renewConnectionsStack();

                } else {
                    mainFrame.connectionGreen();
                }
            }
        };

    }

    public void startEmailCheckerScheduler() {
        Timer timer = new Timer("ConnectionTimer");

        timer.schedule(task, DELAY, PERIOD);
    }

}
