package org.androidgrader.app;

public class GradingKey {
    private float entireWorth;
    private float hugeWorth;
    private float normalWorth;
    private float tinyWorth;

    public GradingKey(int problems, int points) {

        if(points != 0) {

            entireWorth = points / (float) problems;
            hugeWorth   = entireWorth * .5f;
            normalWorth = entireWorth * .25f;
            tinyWorth   = entireWorth * .125f;
        }
    }
    public float getEntireWorth() {
        return entireWorth;
    }

    public float getHugeWorth() {
        return hugeWorth;
    }

    public float getNormalWorth() {
        return normalWorth;
    }
    public float getTinyWorth() {
        return tinyWorth;
    }
}
