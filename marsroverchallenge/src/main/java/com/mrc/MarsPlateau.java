package com.mrc;


/**
 * Developed by Rajith Asanka
 * Package : com.mrc.MarsPlateau
 */

public class MarsPlateau {

    private Integer urcXCoordinate;// Plateau upper right X coordinate
    private Integer urcYCoordinate; // Plateau upper right Y coordinate


    /**
     * Parameterized Constructor
     *
     * @param urcXCoordinate
     * @param urcYCoordinate
     */
    public MarsPlateau(int urcXCoordinate, int urcYCoordinate) {
        this.urcXCoordinate = urcXCoordinate;
        this.urcYCoordinate = urcYCoordinate;
    }


    public int getUrcXCoordinate() {
        return urcXCoordinate;
    }

    public void setUrcXCoordinate(int urcXCoordinate) {
        this.urcXCoordinate = urcXCoordinate;
    }

    public int getUrcYCoordinate() {
        return urcYCoordinate;
    }

    public void setUrcYCoordinate(int urcYCoordinate) {
        this.urcYCoordinate = urcYCoordinate;
    }

    /**
     * Validate rover position coordinates
     *
     * @param xc
     * @param yc
     * @return
     */
    public boolean validateCoordinates(int xc, int yc) {

        if (this.urcXCoordinate >= xc && this.urcYCoordinate >= yc) {
            return true;
        } else {
            return false;
        }

    }

}
