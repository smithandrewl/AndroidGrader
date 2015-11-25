package org.androidgrader.app;

/**
 * Created by andrew on 11/24/15.
 */
public class Mistakes {
    private int entire;
    private int huge;
    private int normal;
    private int tiny;

    public void incEntire() {
        entire++;
    }

    public void decEntire() {
        entire--;
    }

    public void incHuge() {
        huge++;
    }

    public void decHuge() {
        huge--;
    }

    public void incNormal() {
        normal++;
    }

    public void decNormal() {
        normal--;
    }

    public void incTiny() {
        tiny++;
    }

    public void decTiny() {
        tiny--;
    }

    public int getEntire() {
        return entire;
    }

    public int getHuge() {
        return huge;
    }

    public int getNormal() {
        return normal;
    }

    public int getTiny() {
        return tiny;
    }
}
