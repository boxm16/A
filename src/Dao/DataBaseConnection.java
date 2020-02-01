package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MISHA
 */
public class DataBaseConnection {

    private static DataBaseConnection DBCInstance;
    private static Connection connection;

    private DataBaseConnection() {

    }

    public static DataBaseConnection getDBCInstance() {
        if (DBCInstance == null) {
            DBCInstance = new DataBaseConnection();
        }
        return DBCInstance;
    }

    public Connection getConnection() {

        if (connection == null) {
            try {

                System.out.println("----Creating a connection.----");

                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://remotemysql.com/2cMB8HiJvS?useSSL=false";
                String username = "2cMB8HiJvS";
                String password = "rcYF70B1fj";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);

                System.out.println("----Database connection established.----"+new Date());

            } catch (ClassNotFoundException | SQLException ex) {

                Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("+++++Database connection failed.+++++");

            }

        }

        return connection;
    }

}
