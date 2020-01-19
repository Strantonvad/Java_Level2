package ru.gb.jtwo.lone.online.circles;

import java.awt.*;

public class Background {
    long initTime;
    Color bgColor;

    Background(long initTime) {
        this.initTime = initTime;
        this.bgColor = getBgColor();
    }

    Color getBackgroundColor(long currentTime, int interval) {
        if (((currentTime - initTime) / 1000000000) > interval) {
            bgColor = getBgColor();
            initTime = currentTime;
        }
        return bgColor;
    }

    private Color getBgColor() {
        return new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
        );
    }
}
