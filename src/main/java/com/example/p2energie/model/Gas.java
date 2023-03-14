package com.example.p2energie.model;

import com.example.p2energie.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Gas {

    private String gasUsage, week;


    /**
     * @param gasUsage gas usage
     * @param week weeknumber
     */
    public Gas(String gasUsage, String week) {
        this.gasUsage = gasUsage;
        this.week = week;
    }

    public Gas(){
        this.gasUsage = null;
        this.week = null;
    }

    public Gas(ResultSet result) {
        try {
            this.gasUsage = result.getString("gasUsage");
            this.week = result.getString("week");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setGasUsage(String gasUsage) {
        this.gasUsage = gasUsage;
    }

    public void setWeek(String week) {
        this.week = week;
    }


    public String getGasUsage() {
        return gasUsage;
    }

    public String getWeek() {
        return week;
    }

    /**
     * Get all Gas from database
     * @return ArrayList
     */
    public ArrayList<Object> getGas() {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gas");
            ResultSet result = statement.executeQuery();

            ArrayList<Object> gas = new ArrayList<>();

            while (result.next()) {
                gas.add(new Gas(result));
            }

            return gas;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Add Gas to Gas table in database
     * @param gas Energy
     * @return
     */
    public Boolean addGasPrice(Gas gas) {

        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO gas (gasUsage, week) VALUES (?, ?)");
            statement.setString(1, gas.getGasUsage());
            statement.setString(2, gas.getWeek());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
