package org.androidgrader.app;

import junit.framework.TestCase;

public class GradingKeyTest extends TestCase{
    public static final double DELTA = .001;
    private GradingKey gradingKey;

    @Override
    public void setUp() {
        gradingKey = new GradingKey(20, 10);
    }

    public void testGetEntireWorth() {
        assertEquals(0.5f, gradingKey.getEntireWorth(), DELTA);
    }

    public void testGetHugeWorth() {
        assertEquals(0.25f, gradingKey.getHugeWorth(), DELTA);
    }

    public void testGetNormalWorth() {
        assertEquals(0.125, gradingKey.getNormalWorth(), DELTA);
    }

    public void testGetTinyWorth() {
        assertEquals(0.063, gradingKey.getTinyWorth(), DELTA);
    }
}
