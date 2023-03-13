package com.example.p2energie.model;

public class Energy {

    public static Gas _instance;

    public static Gas getInstance(){
        if (_instance == null) {
            _instance = new Gas();
        }

        return _instance;
    }

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
