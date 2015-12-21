package org.androidgrader.app;

import junit.framework.TestCase;

public class MistakesTest extends TestCase {
    Mistakes mistakes;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mistakes = new Mistakes();
    }

    public void testEntireDefaultsToZero() {
        assertEquals(0, mistakes.getEntire());
    }

    public void testHugeDefaultsToZero() {
        assertEquals(0, mistakes.getHuge());
    }

    public void testNormalDefaultsToZero() {
        assertEquals(0, mistakes.getNormal());
    }

    public void testTinyDefaultsToZero() {
        assertEquals(0, mistakes.getTiny());
    }

    public void testEntire() {
        assertEquals(0, mistakes.getEntire());
        mistakes.setEntire(10);
        assertEquals(10, mistakes.getEntire());
    }

    public void testHuge() {
        assertEquals(0, mistakes.getHuge());
        mistakes.setHuge(9);
        assertEquals(9, mistakes.getHuge());
    }

    public void testNormal() {
        assertEquals(0, mistakes.getNormal());
        mistakes.setNormal(8);
        assertEquals(8, mistakes.getNormal());
    }

    public void testTiny() {
        assertEquals(0, mistakes.getTiny());
        mistakes.setTiny(7);
        assertEquals(7, mistakes.getTiny());
    }
}

