package com.example.p2energie.model;

import java.util.ArrayList;

public class Gas {

    private String gasUsage, week;

    private static ArrayList gasList = new ArrayList<Gas>();

    public static void addGasList(Gas gas) {
        gasList.add(gas);
    }

    public static ArrayList getInstance(){
        return gasList;
    }


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
}
