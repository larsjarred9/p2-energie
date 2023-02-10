package com.example.p2energie.model;

public class Usage {
    private final Float energyUsage, gasUsage;
    private final String startPeriod, endPeriod;

    /**
     * @param energyUsage energy usage
     * @param gasUsage gas usage
     * @param startPeriod start period
     * @param endPeriod end period
     */
    public Usage(Float energyUsage, Float gasUsage, String startPeriod, String endPeriod) {
        this.energyUsage = energyUsage;
        this.gasUsage = gasUsage;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }


}
