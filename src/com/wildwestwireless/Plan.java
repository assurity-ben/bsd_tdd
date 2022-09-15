package com.wildwestwireless;

public class Plan {
    private final double basicMonthlyRate;
    private final double additionalLineRate;
    private final int includedMinutes;
    private final double excessMinuteRate;

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
        int familyDiscountThreshold = 3;
        double familyDiscountLineRate = 5.00;

        if (numberOfLines <= familyDiscountThreshold) {
            charge = (numberOfLines - 1) * additionalLineRate;
        }
        else {
            charge = (familyDiscountThreshold - 1) * additionalLineRate;
            charge += (numberOfLines - familyDiscountThreshold) * familyDiscountLineRate;
        }
        return charge;
    }

    public double excessMinutesCharge(int minutesUsed) {
        if (minutesUsed > this.includedMinutes) {
            return (minutesUsed - this.includedMinutes) * this.excessMinuteRate;
        }
        return 0;
    }
}
