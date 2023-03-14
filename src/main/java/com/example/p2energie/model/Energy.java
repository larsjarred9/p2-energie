package com.example.p2energie.model;

import java.util.ArrayList;

public class Energy {

    private String energyUsage, week;

    private static ArrayList energyList = new ArrayList<Energy>();

    // Add energy to list
    public static void addEnergyList(Energy energy) {
        energyList.add(energy);
    }

    // Get energy list
    public static ArrayList getInstance(){
        return energyList;
    }

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
}
