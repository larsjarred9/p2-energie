package com.example.p2energie.model;

import com.example.p2energie.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
