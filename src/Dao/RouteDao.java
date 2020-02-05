/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Report;
import Models.Route;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class RouteDao {

    Connection connection;

    public RouteDao() {
    }

    public void saveRout(Route rout) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String routQuery = "INSERT INTO rout (name, day_1, day_2, day_3, day_4, day_5, day_6, day_7)"
                + " VALUES (?,?,?,?,?,?,?,?);";
        String last_rout_id_query = "SELECT MAX(id) AS AUTO_INCREMENT FROM rout";
        String lotQuery = "INSERT INTO rout_lot (rout, lot) VALUES (?,?)";
        try (PreparedStatement ps_rout = connection.prepareStatement(routQuery);
                PreparedStatement ps_rout_lot = connection.prepareStatement(lotQuery);
                Statement last_rout_id_st = connection.createStatement();) {
            ps_rout.setString(1, rout.getName());
            ps_rout.setBoolean(2, rout.isDay_1());
            ps_rout.setBoolean(3, rout.isDay_2());
            ps_rout.setBoolean(4, rout.isDay_3());
            ps_rout.setBoolean(5, rout.isDay_4());
            ps_rout.setBoolean(6, rout.isDay_5());
            ps_rout.setBoolean(7, rout.isDay_6());
            ps_rout.setBoolean(8, rout.isDay_7());
            ps_rout.execute();

            ResultSet rs = last_rout_id_st.executeQuery(last_rout_id_query);
            int increment_number = 0;
            while (rs.next()) {
                increment_number = rs.getInt("AUTO_INCREMENT");
            }
            for (Integer lot : rout.getLotSet()) {
                ps_rout_lot.setInt(1, increment_number);
                ps_rout_lot.setInt(2, lot);
                ps_rout_lot.addBatch();
            }
            ps_rout_lot.executeBatch();

        } catch (Exception ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Route> getExistingRouts() {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        ArrayList<Route> existingRouts = new ArrayList<>();
        String query = "SELECT * FROM rout";
        String lotQuery = "SELECT lot FROM rout_lot WHERE rout=?";
        Route rout;
        try (Statement statement = connection.createStatement();
                PreparedStatement ps = connection.prepareStatement(lotQuery);) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                rout = new Route();
                rout.setId(rs.getInt("id"));
                rout.setName(rs.getString("name"));
                rout.setDay_1(rs.getBoolean("day_1"));
                rout.setDay_2(rs.getBoolean("day_2"));
                rout.setDay_3(rs.getBoolean("day_3"));
                rout.setDay_4(rs.getBoolean("day_4"));
                rout.setDay_5(rs.getBoolean("day_5"));
                rout.setDay_6(rs.getBoolean("day_6"));
                rout.setDay_7(rs.getBoolean("day_7"));

                ps.setInt(1, rs.getInt("id"));
                ResultSet rs1 = ps.executeQuery();
                HashSet<Integer> lots = new HashSet<>();
                while (rs1.next()) {
                    lots.add(rs1.getInt("lot"));
                }
                rout.setLotSet(lots);
                existingRouts.add(rout);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return existingRouts;
    }

    public void deleteRout(int rout_id) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String query = "DELETE FROM rout WHERE id=" + rout_id + "";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public Route getRout(int routId) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String query = "SELECT * FROM rout WHERE id=" + routId + "";
        String lotQuery = "SELECT lot FROM rout_lot WHERE rout=?";
        Route rout = null;
        try (Statement statement = connection.createStatement();
                PreparedStatement ps = connection.prepareStatement(lotQuery);) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                rout = new Route();
                rout.setId(rs.getInt("id"));
                rout.setName(rs.getString("name"));
                rout.setDay_1(rs.getBoolean("day_1"));
                rout.setDay_2(rs.getBoolean("day_2"));
                rout.setDay_3(rs.getBoolean("day_3"));
                rout.setDay_4(rs.getBoolean("day_4"));
                rout.setDay_5(rs.getBoolean("day_5"));
                rout.setDay_6(rs.getBoolean("day_6"));
                rout.setDay_7(rs.getBoolean("day_7"));

                ps.setInt(1, rs.getInt("id"));
                ResultSet rs1 = ps.executeQuery();
                HashSet<Integer> lots = new HashSet<>();
                while (rs1.next()) {
                    lots.add(rs1.getInt("lot"));
                }
                rout.setLotSet(lots);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return rout;
    }

    public ArrayList<Route> getAvailableRoutsForDistrict(String postal_code) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        ArrayList<Route> availableRouts = new ArrayList<>();
        String query = "SELECT *  FROM rout "
                + "INNER JOIN rout_lot ON rout.id=rout_lot.rout "
                + "INNER JOIN post_box ON rout_lot.lot=post_box.lot "
                + "WHERE post_box.postal_code='" + postal_code + "' "
                + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Route rout = new Route();
                rout.setId(rs.getInt("id"));
                rout.setName(rs.getString("name"));
                rout.setDay_1(rs.getBoolean("day_1"));
                rout.setDay_2(rs.getBoolean("day_2"));
                rout.setDay_3(rs.getBoolean("day_3"));
                rout.setDay_4(rs.getBoolean("day_4"));
                rout.setDay_5(rs.getBoolean("day_5"));
                rout.setDay_6(rs.getBoolean("day_6"));
                rout.setDay_7(rs.getBoolean("day_7"));
                availableRouts.add(rout);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return availableRouts;
    }

    public int getD_Rout(int routId, String date) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        int dRoutId = 0;
        String query = "SELECT id FROM d_rout WHERE rout_id=" + routId + " and date='" + date + "'";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                dRoutId = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return dRoutId;

    }

    public void insertDRout(int routId, String date) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String query = "INSERT INTO d_rout (rout_id, date) VALUES (" + routId + ", '" + date + "');";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void insertDRout_Report(int DRoutId, int report_id) {
        connection = ConnectionsDispatcher.getDispatcherInstance().getConnection();

        String query = "INSERT INTO d_rout_report (d_rout_id, report_id) VALUES (" + DRoutId + "," + report_id + ")";
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
