package org.androidgrader.app;

public class Assignment {
    private int questions;
    private int points;

    public Assignment() {
        questions = 10;
        points = 10;
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

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}


