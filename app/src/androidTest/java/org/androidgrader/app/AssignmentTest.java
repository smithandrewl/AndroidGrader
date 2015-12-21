package org.androidgrader.app;

import junit.framework.TestCase;

public class AssignmentTest extends TestCase{

    Assignment assignment;

    public static float DELTA = .001f;

    @Override
    public void setUp() {
        assignment = new Assignment();
    }

    public void testGetQuestionsDefault() {
        assertEquals(10, assignment.getQuestions());
    }

    public void testGetPointsDefault() {
        assertEquals(10, assignment.getPoints());
    }

    public void testPoints() {
        assertEquals(10, assignment.getPoints());
        assignment.setPoints(20);
        assertEquals(20, assignment.getPoints());
    }

    public void testQuestions() {
        assertEquals(10, assignment.getQuestions());
        assignment.setQuestions(30);
        assertEquals(30, assignment.getQuestions());
    }

    public void testGetGradingKey() {
        GradingKey gradingKey = assignment.getGradingKey();

        assertEquals(1.0,   gradingKey.getEntireWorth(), DELTA);
        assertEquals(0.5,   gradingKey.getHugeWorth(),   DELTA);
        assertEquals(0.25,  gradingKey.getNormalWorth(), DELTA);
        assertEquals(0.125, gradingKey.getTinyWorth(),   DELTA);
    }
}
