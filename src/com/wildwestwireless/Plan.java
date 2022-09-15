package com.wildwestwireless;

public class Plan {
    private double excessMinuteRate;
    private double basicMonthlyRate;
    private double additionalLineRate;
    private int includedMinutes;


    public Plan(double basicMonthlyRate, double additionalLineRate, double excessMinuteRate, int includedMinutes) {
        this.basicMonthlyRate = basicMonthlyRate;
        this.additionalLineRate = additionalLineRate;
        this.excessMinuteRate = excessMinuteRate;
        this.includedMinutes = includedMinutes;
    }

    public double getBasicMonthlyRate() {
        return this.basicMonthlyRate;
    }

    double additionalLineCharge(int numberOfLines) {
        double charge;
        double familyDiscountLineRate = 5.00;
        int familyDiscountThreshold = 3;

        if (numberOfLines <= familyDiscountThreshold) {
            charge = (numberOfLines - 1) * additionalLineRate;
        }
        else {
            charge = (familyDiscountThreshold - 1) * additionalLineRate;
            charge += (numberOfLines - familyDiscountThreshold) * familyDiscountLineRate;
        }
        return charge;
    }

    public Double excessMinutesCharge(int minutesUsed) {
        if (minutesUsed > this.includedMinutes) {
            return (minutesUsed - this.includedMinutes) * this.excessMinuteRate;
        }
        return 0D;
    }
}
