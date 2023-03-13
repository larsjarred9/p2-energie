package com.example.p2energie.model;

public class Energy {

    public static Energy _instance;

    public static Energy getInstance(){
        if (_instance == null) {
            _instance = new Energy();
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
