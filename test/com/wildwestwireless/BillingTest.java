// ***************************************************************************
// Copyright (c) 2020, Industrial Logic, Inc., All Rights Reserved.
//
// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
// used by students during Industrial Logic's workshops or by individuals
// who are being coached by Industrial Logic on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Industrial Logic, Inc.
// ****************************************************************************

package com.wildwestwireless;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillingTest {
    private static final Plan nullPlan = new Plan(0, 0, 0, 0);
    private static final Plan goldPlan = new Plan(49.95, 14.50, 0.45, 1000);
    private static final Plan silverPlan = new Plan(29.95, 21.50, 0.54, 500);

    @Test
    public void noPlan() {
        Account account = new Account(0, 0, nullPlan);
        assertEquals(0.0, account.calculateBill(), 0);
    }

    @Test
    public void goldOneLine() {
        Account account = new Account(1, 0, goldPlan);
        assertEquals(49.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldTwoLines() {
        Account account = new Account(2, 0, goldPlan);
        assertEquals(64.45, account.calculateBill(), 0.001);
    }

    @Test
    public void silverOneLine() {
        Account account = new Account(1, 0, silverPlan);
        assertEquals(29.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverThreeLines() {
        Account account = new Account(3, 0, silverPlan);
        assertEquals(72.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldWithinIncludedMinutes() {
        Account account = new Account(1, 999, goldPlan);
        assertEquals(49.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldExactlyIncludedMinutes() {
        Account account = new Account(1, 1000, goldPlan);
        assertEquals(49.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldOverOneMinute() {
        Account account = new Account(1, 1001, goldPlan);
        assertEquals(50.40, account.calculateBill(), 0.001);
    }

    @Test
    public void goldOverTenMinutes() {
        Account account = new Account(1, 1010, goldPlan);
        assertEquals(54.45, account.calculateBill(), 0.001);
    }

    @Test
    public void silverWithinIncludedMinutes() {
        Account account = new Account(1, 499, silverPlan);
        assertEquals(29.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverExactlyIncludedMinutes() {
        Account account = new Account(1, 500, silverPlan);
        assertEquals(29.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverOverTwentyMinutes() {
        Account account = new Account(1, 520, silverPlan);
        assertEquals(40.75, account.calculateBill(), 0.001);
    }

    @Test
    public void goldTwoLinesWithinIncludedMinutes() {
        Account account = new Account(2, 999, goldPlan);
        assertEquals(64.45, account.calculateBill(), 0.001);
    }

    @Test
    public void goldThreeLinesWithinIncludedMinutes() {
        Account account = new Account(3, 999, goldPlan);
        assertEquals(78.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldFourLinesWithinIncludedMinutes() {
        Account account = new Account(4, 999, goldPlan);
        assertEquals(83.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverFourLinesWithinIncludedMinutes() {
        Account account = new Account(4, 499, silverPlan);
        assertEquals(77.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverFiveLinesWithinIncludedMinutes() {
        Account account = new Account(5, 499, silverPlan);
        assertEquals(82.95, account.calculateBill(), 0.001);
    }
}
