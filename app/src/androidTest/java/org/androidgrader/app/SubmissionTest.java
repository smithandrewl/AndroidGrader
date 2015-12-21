package org.androidgrader.app;


import junit.framework.TestCase;

public class SubmissionTest extends TestCase{

    public static float DELTA = 0.001f;

    Submission submission;

    @Override
    public void setUp() {
        submission = new Submission();
    }

    public void testGetQuestionsDefault() {
        assertEquals(10, submission.getQuestions());
    }

    public void testGetPointsDefault() {
        assertEquals(10, submission.getPoints());
    }

    public void testGetGradingKey() {
        submission.setPoints(31);
        submission.setQuestions(11);

        GradingKey gradingKey = submission.getGradingKey();

        assertEquals(2.818,  gradingKey.getEntireWorth(), DELTA);
        assertEquals(1.409,  gradingKey.getHugeWorth(),   DELTA);
        assertEquals(0.705,  gradingKey.getNormalWorth(), DELTA);
        assertEquals(0.352,  gradingKey.getTinyWorth(),   DELTA);
    }

    public void testGrade() {
        submission.setPoints(100);
        submission.setQuestions(50);

        submission.setEntireMistakes(6);
        submission.setHugeMistakes(7);
        submission.setNormalMistakes(8);
        submission.setTinyMistakes(9);

        assertEquals(74.75, submission.grade(), DELTA);

    }
    public void testGetEntireMistakesDefault() {
        assertEquals(0, submission.getEntireMistakes());
    }

    public void testGetHugeMistakesDefault() {
        assertEquals(0, submission.getHugeMistakes());
    }

    public void testGetNormalMistakesDefault() {
        assertEquals(0, submission.getNormalMistakes());
    }

    public void testGetTinyMistakesDefault()   {
        assertEquals(0, submission.getTinyMistakes());
    }

    public void testQuestions() {
        assertEquals(10, submission.getQuestions());
        submission.setQuestions(20);
        assertEquals(20, submission.getQuestions());
    }

    public void testPoints() {
        assertEquals(10, submission.getPoints());
        submission.setPoints(30);
        assertEquals(30, submission.getPoints());
    }

    public void testEntireMistakes() {
        assertEquals(0, submission.getEntireMistakes());
        submission.setEntireMistakes(10);
        assertEquals(10, submission.getEntireMistakes());
    }

    public void testHugeMistakes() {
        assertEquals(0, submission.getHugeMistakes());
        submission.setHugeMistakes(9);
        assertEquals(9, submission.getHugeMistakes());
    }

    public void testNormalMistakes() {
        assertEquals(0, submission.getNormalMistakes());
        submission.setNormalMistakes(8);
        assertEquals(8, submission.getNormalMistakes());
    }

    public void testTinyMistakes()   {
        assertEquals(0, submission.getTinyMistakes());
        submission.setTinyMistakes(7);
        assertEquals(7, submission.getTinyMistakes());
    }
}
