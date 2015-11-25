package org.androidgrader.app;

/**
 * Created by andrew on 11/24/15.
 */
public class Assignment {
    private int questions;
    private int points;

    public Assignment() {
        questions = 10;
        points    = 10;
    }

    public GradingKey getGradingKey() {
        return new GradingKey(questions, points);
    }

    public int getQuestions() {
        return questions;
    }

    public int getPoints() {
        return points;
    }

    public void incQuestions() {
        questions++;
    }

    public void decQuestions() {
        questions--;
    }

    public void incPoints() {
        points++;
    }

    public void decPoints() {
        points--;
    }
}
