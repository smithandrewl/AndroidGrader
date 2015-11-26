package org.androidgrader.app;

/**
 * Created by andrew on 11/24/15.
 */
public class Submission {
    private Assignment assignment;
    private Mistakes   mistakes;

    public Submission() {
        assignment = new Assignment();
        mistakes = new Mistakes();
    }


    public float grade() {
        GradingKey gradingKey = assignment.getGradingKey();

        float penaltyForEntire = mistakes.getEntire() * gradingKey.getEntireWorth();
        float penaltyForHuge   = mistakes.getHuge()   * gradingKey.getHugeWorth();
        float penaltyForNormal = mistakes.getNormal() * gradingKey.getNormalWorth();
        float penaltyForTiny   = mistakes.getTiny()   * gradingKey.getTinyWorth();

        float totalPenalty = penaltyForEntire + penaltyForHuge + penaltyForNormal + penaltyForTiny;

        return assignment.getPoints() - totalPenalty;
    }

    public GradingKey getGradingKey() {
        return assignment.getGradingKey();
    }

    public void setEntireMistakes(int count) {
        mistakes.setEntire(count);
    }

    public void setHugeMistakes(int count) {
        mistakes.setHuge(count);
    }

    public void setNormalMistakes(int count) {
        mistakes.setNormal(count);
    }

    public void setTinyMistakes(int count) {
        mistakes.setTiny(count);
    }

    public void setQuestions(int count) {
        assignment.setQuestions(count);
    }

    public void setPoints(int points) {
        assignment.setPoints(points);
    }


}