/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class ConnectionsDispatcher {

    private static ConnectionsDispatcher CD_Instance;

    private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://remotemysql.com/2cMB8HiJvS?useSSL=false";
    private final String USER = "2cMB8HiJvS";
    private final String PASSWORD = "rcYF70B1fj";
    private final int minutes = 5;
    private static LinkedList<Connection> connectionsStack = new LinkedList();
    private Timer timer;

    private ConnectionsDispatcher() {

        connectionsStack = new LinkedList();
        connectionsStack.add(openConnection());
        connectionsStack.add(openConnection());

        timer = new Timer();
        timer.schedule(new ConnectionRenewal(), minutes * 60000, minutes * 60000);
    }

    public static ConnectionsDispatcher getDispatcherInstance() {
        if (CD_Instance == null) {
            CD_Instance = new ConnectionsDispatcher();
        }
        return CD_Instance;
    }

    private Connection openConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionsDispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public static Connection getConnection() {

        return connectionsStack.peekLast();
    }

    private class ConnectionRenewal extends TimerTask {

        public void run() {
            System.out.println(new Date() + " Time for new connection!");
            System.out.println("Connections in connections Stack before renewal: " + connectionsStack.size());
            if (connectionsStack.size() < 2) {
                connectionsStack.add(openConnection());
            }
            connectionsStack.add(openConnection());
            Connection closingConnection = connectionsStack.removeFirst();
            System.out.println("Connections in connections Stack after renewal: " + connectionsStack.size());

            try {
                closingConnection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionsDispatcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
