package com.example.p2energie.model;

import com.example.p2energie.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
     * Add Usage to Usage table in database
     * @param usage Usage
     * @return
     */
    public Boolean addUsage(Usage usage) {

        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO usage (energyUsage, gasUsage, week) VALUES (?, ?, ?)");
            statement.setFloat(1, usage.getEnergyUsage());
            statement.setFloat(2, usage.getGasUsage());
            statement.setString(3, usage.getWeek());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
