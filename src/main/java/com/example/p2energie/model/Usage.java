package com.example.p2energie.model;

import java.util.ArrayList;

public class Usage {

    private static ArrayList usageList = new ArrayList<Usage>();

    public static void addUsageToList(Usage usage) {
        usageList.add(usage);
    }

    public static ArrayList getInstance(){
        return usageList;
    }

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
}
