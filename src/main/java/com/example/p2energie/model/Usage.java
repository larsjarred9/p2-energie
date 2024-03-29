package com.example.p2energie.model;

import com.example.p2energie.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usage {

    private Float energyUsage, gasUsage;
    private String week;

    /**
     * @param energyUsage energy usage
     * @param gasUsage gas usage
     * @param week week
     */
    public Usage(Float energyUsage, Float gasUsage, String week) {
        this.energyUsage = energyUsage;
        this.gasUsage = gasUsage;
        this.week = week;
    }

    public Usage(){
        this.energyUsage = null;
        this.gasUsage = null;
        this.week = null;
    }

    public Usage(ResultSet result) {
        try {
            this.energyUsage = result.getFloat("energyUsage");
            this.gasUsage = result.getFloat("gasUsage");
            this.week = result.getString("week");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Float getEnergyUsage() {
        return energyUsage;
    }

    public void setEnergyUsage(Float energyUsage) {
        this.energyUsage = energyUsage;
    }

    public Float getGasUsage() {
        return gasUsage;
    }

    public void setGasUsage(Float gasUsage) {
        this.gasUsage = gasUsage;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    /**
     * Get all usages from database
     * @param userId Customer ID
     * @return ArrayList
     */
    public ArrayList<Object> getUsage(Integer userId) {

        ArrayList<Object> usage = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customeruse WHERE customer = ?");
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                usage.add(new Usage(result));
            }

            return usage;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usage;
    }


    /**
     * Add Usage to Usage table in database
     * @param usage Usage
     * @param userId User ID
     * @return
     */
    public Boolean addUsage(Usage usage, Integer userId) {

        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customeruse (customer, energyUsage, gasUsage, week) VALUES (?, ?, ?, ?)");
            statement.setInt(1, userId);
            statement.setFloat(2, usage.getEnergyUsage());
            statement.setFloat(3, usage.getGasUsage());
            statement.setString(4, usage.getWeek());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
