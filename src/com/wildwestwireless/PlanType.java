package com.wildwestwireless;

public class PlanType {
    private double baseRate;
    double minuteRate;
    int includedMinutes;

    public PlanType(double baseRate, double minuteRate, int includedMinutes) {
        this.baseRate = baseRate;
        this.minuteRate = minuteRate;
        this.includedMinutes = includedMinutes;
    }
}
