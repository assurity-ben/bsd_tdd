package com.wildwestwireless;

public class Plan {

    private int numberOfLines;
    private String type;
    private int minutesUsed;

    public Plan() {
    }

    public Plan(String type, int numberOfLines) {
        this.type = type;
        this.numberOfLines = numberOfLines;
    }

    public Plan(String type, int numberOfLines, int minutesUsed) {
        this.type = type;
        this.numberOfLines = numberOfLines;
        this.minutesUsed = minutesUsed;
    }

    public double calculateBill() {
        double total = 0;
        if (this.type == "Gold") {
            total += 49.95;
        }
        else if (this.type == "Silver") {
            total += 29.95;
        }
        total += getAdditionalLineRate();
        total += excessMinutesCharge();
        return total;
    }

    private double excessMinutesCharge() {
        double goldMinuteRate = 0.45;
        int goldIncludedMinutes = 1000;
        double silverMinuteRate = 0.54;
        int silverIncludedMinutes = 500;
        if (this.type == "Gold") {
            return calculateExcessMinutesCharge(goldMinuteRate, goldIncludedMinutes);
        }
        else if (this.type == "Silver") {
            return calculateExcessMinutesCharge(silverMinuteRate, silverIncludedMinutes);
        }
        return 0;
    }

    private double calculateExcessMinutesCharge(double minuteRate, int includedMinutes) {
        if (this.minutesUsed > includedMinutes) {
            return (this.minutesUsed - includedMinutes) * minuteRate;
        }
        return 0;
    }

    private double getAdditionalLineRate() {
        double goldLineRate = 14.50;
        double silverLineRate = 21.50;

        if (this.type == "Gold") {
            return calculateLineRate(goldLineRate);
        }
        else if (this.type == "Silver") {
            return calculateLineRate(silverLineRate);
        }
        return 0;
    }

    private double calculateLineRate(double lineRate) {
        double charge;
        double familyDiscountLineRate = 5.00;
        int familyDiscountThreshold = 3;

        if (this.numberOfLines <= familyDiscountThreshold) {
            charge = (this.numberOfLines - 1) * lineRate;
        }
        else {
            charge = (familyDiscountThreshold - 1) * lineRate;
            charge += (this.numberOfLines - familyDiscountThreshold) * familyDiscountLineRate;
        }
        return charge;
    }
}
