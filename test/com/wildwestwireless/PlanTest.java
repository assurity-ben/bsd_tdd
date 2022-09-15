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

// Feel free to rename this class 
public class PlanTest {
	@Test
    public void noPlan() {
        Plan account = new Plan();
        assertEquals(0.0, account.calculateBill(), 0);
    }

    @Test
    public void goldOneLine() {
        Plan account = new Plan("Gold", 1);
        assertEquals(49.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldTwoLines() {
        Plan account = new Plan("Gold", 2);
        assertEquals(64.45, account.calculateBill(), 0.001);
    }

    @Test
    public void silverOneLine() {
        Plan account = new Plan("Silver", 1);
        assertEquals(29.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverThreeLines() {
        Plan account = new Plan("Silver", 3);
        assertEquals(72.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldWithinIncludedMinutes() {
        Plan account = new Plan("Gold", 1, 999);
        assertEquals(49.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldExactlyIncludedMinutes() {
        Plan account = new Plan("Gold", 1, 1000);
        assertEquals(49.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldOverOneMinute() {
        Plan account = new Plan("Gold", 1, 1001);
        assertEquals(50.40, account.calculateBill(), 0.001);
    }

    @Test
    public void goldOverTenMinutes() {
        Plan account = new Plan("Gold", 1, 1010);
        assertEquals(54.45, account.calculateBill(), 0.001);
    }

    @Test
    public void silverWithinIncludedMinutes() {
        Plan account = new Plan("Silver", 1, 499);
        assertEquals(29.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverExactlyIncludedMinutes() {
        Plan account = new Plan("Silver", 1, 500);
        assertEquals(29.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverOverTwentyMinutes() {
        Plan account = new Plan("Silver", 1, 520);
        assertEquals(40.75, account.calculateBill(), 0.001);
    }

    @Test
    public void goldTwoLinesWithinIncludedMinutes() {
        Plan account = new Plan("Gold", 2, 999);
        assertEquals(64.45, account.calculateBill(), 0.001);
    }

    @Test
    public void goldThreeLinesWithinIncludedMinutes() {
        Plan account = new Plan("Gold", 3, 999);
        assertEquals(78.95, account.calculateBill(), 0.001);
    }

    @Test
    public void goldFourLinesWithinIncludedMinutes() {
        Plan account = new Plan("Gold", 4, 999);
        assertEquals(83.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverFourLinesWithinIncludedMinutes() {
        Plan account = new Plan("Silver", 4, 499);
        assertEquals(77.95, account.calculateBill(), 0.001);
    }

    @Test
    public void silverFiveLinesWithinIncludedMinutes() {
        Plan account = new Plan("Silver", 5, 499);
        assertEquals(82.95, account.calculateBill(), 0.001);
    }
}
