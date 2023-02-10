package com.example.p2energie.model;

public class Gas {
    private final Float gasUsage;
    private final String startPeriod, endPeriod;

    /**
     * @param gasUsage gas usage
     * @param startPeriod start period
     * @param endPeriod end period
     */
    public Gas(Float gasUsage, String startPeriod, String endPeriod) {
        this.gasUsage = gasUsage;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }
}
