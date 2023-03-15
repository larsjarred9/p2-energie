package com.example.p2energie.model;

import com.example.p2energie.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Energy {

    private String energyUsage, week;


    /**
     * @param energyUsage energy usage
     * @param week week
     */
    public Energy(String energyUsage, String week) {
        this.energyUsage = energyUsage;
        this.week = week;
    }

    public Energy(){
        this.energyUsage = null;
        this.week = null;
    }

    public Energy(ResultSet result) {
        try {
            this.energyUsage = result.getString("energyUsage");
            this.week = result.getString("week");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEnergyUsage() {
        return energyUsage;
    }

    public void setEnergyUsage(String energyUsage) {
        this.energyUsage = energyUsage;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    /**
     * Get all energy from database
     * @return ArrayList
     */
    public ArrayList<Object> getEnergy() {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM energy");
            ResultSet result = statement.executeQuery();

            ArrayList<Object> energy = new ArrayList<>();

            while (result.next()) {
                energy.add(new Energy(result));
            }

            return energy;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Add Energy to Enegery table in database
     * @param energy Energy
     * @return
     */
    public Boolean addEnergyPrice(Energy energy, Integer userId) {

        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO energy (customer, energyUsage, week) VALUES (?, ?, ?)");
            statement.setFloat(1, userId);
            statement.setString(3, energy.getEnergyUsage());
            statement.setString(2, energy.getWeek());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
