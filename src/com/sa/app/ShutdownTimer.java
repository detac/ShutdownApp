package com.sa.app;

public class ShutdownTimer {

    private String hours;
    private String minutes;
    private String second;

    public ShutdownTimer() {
    }

    public String recalculate(long value) {
        value = value / 1000;

        long hours = value / 3600;
        long minutes = (value - (hours * 3600)) / 60;
        long seconds = value - (hours * 3600) - (minutes * 60);

        this.hours = convertLongToString(hours);
        this.minutes = convertLongToString(minutes);
        this.second = convertLongToString(seconds);

        return toString();
    }

    private String convertLongToString(long value) {
        if (value < 0) {
            return "00";
        }

        if (value < 10) {
            return "0" + value;
        }

        return "" + value;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + second;
    }

}
