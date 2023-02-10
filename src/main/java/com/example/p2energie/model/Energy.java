package com.example.p2energie.model;

public class Energy {

    private final Float energyUsage;
    private final String startPeriod, endPeriod;

    /**
     * @param energyUsage energy usage
     * @param startPeriod start period
     * @param endPeriod end period
     */
    public Energy(Float energyUsage, String startPeriod, String endPeriod) {
        this.energyUsage = energyUsage;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }
}
