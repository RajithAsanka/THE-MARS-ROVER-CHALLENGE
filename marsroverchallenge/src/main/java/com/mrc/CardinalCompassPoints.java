package com.mrc;

/**
 * Developed by Rajith Asanka
 * Package : com.mrc.CardinalCompassPoints
 */

public enum CardinalCompassPoints {


    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private String pointValue;

    /**
     *
     * @return
     */
    public String getPointValue() {
        return pointValue;
    }

    /**
     *
     * @param pointValue
     */
    private CardinalCompassPoints(String pointValue) {
        this.pointValue = pointValue;
    }


}
