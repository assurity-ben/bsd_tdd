package com.wildwestwireless;

public class Account {

    private int numberOfLines;
    private int minutesUsed;
    private Plan plan;

    public Account(int numberOfLines, int minutesUsed, Plan plan) {
        this.numberOfLines = numberOfLines;
        this.minutesUsed = minutesUsed;
        this.plan = plan;
    }

    public double calculateBill() {
        double total = 0;
        total += plan.getBasicMonthlyRate();
        total += plan.additionalLineCharge(this.numberOfLines);
        total += plan.excessMinutesCharge(this.minutesUsed);
        return total;
    }

}
