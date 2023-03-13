package com.example.p2energie.model;

public class Gas {

    public static Gas _instance;

    public static Gas getInstance(){
        if (_instance == null) {
            _instance = new Gas();
        }

        return _instance;
    }

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
}
