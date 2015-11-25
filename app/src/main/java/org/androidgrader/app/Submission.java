package org.androidgrader.app;

/**
 * Created by andrew on 11/24/15.
 */
public class Submission {
    private Assignment assignment;
    private Mistakes   mistakes;

    public Submission() {
        assignment = new Assignment();
        mistakes   = new Mistakes();
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

    public void incQuestions() {
        assignment.incQuestions();
    }

    public void decQuestions() {
        assignment.decQuestions();
    }

    public void incEntireMistakes() {
        mistakes.incEntire();
    }

    public void decEntireMistakes() {
        mistakes.decEntire();
    }

    public void incHugeMistakes() {
        mistakes.incHuge();
    }

    public void decHugeMistakes() {
        mistakes.decHuge();
    }

    public void incNormalMistakes() {
        mistakes.incNormal();
    }

    public void decNormalMistakes() {
        mistakes.decNormal();
    }

    public void incTiny() {
        mistakes.incTiny();
    }

    public void decTiny() {
        mistakes.decTiny();
    }
}