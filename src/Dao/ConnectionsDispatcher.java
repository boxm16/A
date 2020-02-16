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
import javax.swing.JOptionPane;

/**
 *
 * @author Michail Sitmalidis
 */
public class ConnectionsDispatcher {

    private static ConnectionsDispatcher CD_Instance;

    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://remotemysql.com/2cMB8HiJvS?useSSL=false";
    private static final String USER = "2cMB8HiJvS";
    private static final String PASSWORD = "rcYF70B1fj";
    private static final int MINUTES = 5;

    private final int delay = 0;
    private static Date timeStamp;
    private static LinkedList<Connection> connectionsStack = new LinkedList();
    private Timer timer;

    private ConnectionsDispatcher() {
        timeStamp = new Date();

        connectionsStack = new LinkedList();
        connectionsStack.add(openConnection());
        connectionsStack.add(openConnection());

        timer = new Timer();
        timer.schedule(new ConnectionRenewal(), delay, MINUTES * 60000);
    }

    public static ConnectionsDispatcher getDispatcherInstance() {
        if (CD_Instance == null) {
            CD_Instance = new ConnectionsDispatcher();

        }
        return CD_Instance;
    }

    private static Connection openConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionsDispatcher.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new javax.swing.JFrame(),
                    "ΔΕΝ ΥΠΑΡΧΕΙ ΣΥΝΔΕΣΗ ΜΕ ΤΗ ΒΑΣΗ, ΣΥΣΤΗΜΑ ΠΡΟΣΠΑΘΕΙ ΝΑ ΦΙΑΞΕΙ ΣΥΝΔΕΣΗ.",
                    "DATABASE CONNECTION ERROR",
                    JOptionPane.ERROR_MESSAGE);
            renewConnectionsStack();
        }
        return connection;
    }

    public static Connection getConnection() {
        //if a connection wasnt requested for more than time that is defined in Timer (MINUTES)
        //(usually this happens when computer goes to sleep, so Timer dont fire his run method)
        //i need to close all connections in connectionsStack, clear the stack and refill it with new connections
        if (new Date().getTime() - timeStamp.getTime() > (MINUTES * 60000) + 1) {
            renewConnectionsStack();
        }
        return connectionsStack.peekLast();
    }

    private static void renewConnectionsStack() {
        for (Connection connection : connectionsStack) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionsDispatcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        connectionsStack.clear();
        connectionsStack.add(openConnection());
        connectionsStack.add(openConnection());
    }

    private class ConnectionRenewal extends TimerTask {

        @Override
        public void run() {
            System.out.println(new Date() + " Time for new connection!");
            System.out.println("Connections in connections Stack before renewal: " + connectionsStack.size());
            timeStamp = new Date();

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
