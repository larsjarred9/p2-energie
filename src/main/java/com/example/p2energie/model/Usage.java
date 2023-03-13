package com.example.p2energie.model;

public class Usage {

    public static Gas _instance;

    public static Gas getInstance(){
        if (_instance == null) {
            _instance = new Gas();
        }

        return _instance;
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

    public static Gas get_instance() {
        return _instance;
    }

    public static void set_instance(Gas _instance) {
        Usage._instance = _instance;
    }
}
