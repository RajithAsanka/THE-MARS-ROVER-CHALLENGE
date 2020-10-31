package com.mrc;

/**
 * Developed by Rajith Asanka
 * Package : com.mrc.Rover
 */

public class Rover {

    private Integer xCoordinate; // rover X coordinate position
    private Integer yCoordinate; // rover Y coordinate position
    private String roverCompassDirection; // rover compass cardinal direction
    private MarsPlateau plateauGrid; // plateau grid area size
    private char ROTATE_LEFT = 'L'; // rotate 90 degrees to left
    private char ROTATE_RIGHT = 'R'; // rotate 90 degrees to right
    private char MOVE = 'M'; // forward one grid


    /**
     * Parameterized Constructor
     *
     * @param xCoordinate
     * @param yCoordinate
     * @param roverCompassDirection
     * @param plateauGrid
     */
    public Rover(Integer xCoordinate, Integer yCoordinate, String roverCompassDirection, MarsPlateau plateauGrid) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.roverCompassDirection = roverCompassDirection;
        this.plateauGrid = plateauGrid;
    }


    /**
     * process rover drive instructions
     *
     * @param roverCommands
     * @throws Exception
     */
    public void proceedRoverInstructions(String roverCommands) throws Exception {

        for (int index = 0; index < roverCommands.length(); index++) {
            explorePlateau(roverCommands.charAt(index));
        }

    }

    /**
     * change rover position according to rover dashboard commands
     *
     * @param command
     * @throws Exception
     */
    private void explorePlateau(Character command) throws Exception {

        if (command.equals(ROTATE_LEFT)) {
            turnRoverLeft();
        } else if (command.equals(ROTATE_RIGHT)) {
            turnRoverRight();
        } else if (command.equals(MOVE)) {
            moveRover();
        } else {
            throw new IllegalArgumentException("Invalid Rover Drive Command");
        }


    }


    /**
     * // rotate rover 90 degrees to left
     */
    private void turnRoverLeft() {

        if (roverCompassDirection.equals(CardinalCompassPoints.NORTH.getPointValue())) {

            this.roverCompassDirection = CardinalCompassPoints.WEST.getPointValue();

        } else if (roverCompassDirection.equals(CardinalCompassPoints.WEST.getPointValue())) {

            roverCompassDirection = CardinalCompassPoints.SOUTH.getPointValue();

        } else if (roverCompassDirection.equals(CardinalCompassPoints.SOUTH.getPointValue())) {

            roverCompassDirection = CardinalCompassPoints.EAST.getPointValue();

        } else if (roverCompassDirection.equals(CardinalCompassPoints.EAST.getPointValue())) {

            roverCompassDirection = CardinalCompassPoints.NORTH.getPointValue();
        }
    }

    /**
     * rotate rover 90 degrees to right
     */
    private void turnRoverRight() {

        if (roverCompassDirection.equals(CardinalCompassPoints.NORTH.getPointValue())) {

            roverCompassDirection = CardinalCompassPoints.EAST.getPointValue();

        } else if (roverCompassDirection.equals(CardinalCompassPoints.EAST.getPointValue())) {

            roverCompassDirection = CardinalCompassPoints.SOUTH.getPointValue();

        } else if (roverCompassDirection.equals(CardinalCompassPoints.SOUTH.getPointValue())) {

            roverCompassDirection = CardinalCompassPoints.WEST.getPointValue();

        } else if (roverCompassDirection.equals(CardinalCompassPoints.WEST.getPointValue())) {

            roverCompassDirection = CardinalCompassPoints.NORTH.getPointValue();
        }

    }

    /**
     * Rover move forward one grid point
     */
    private void moveRover() throws Exception {

        boolean validateCoordinates = plateauGrid.validateCoordinates(xCoordinate, yCoordinate);

        if (validateCoordinates) {
            if (roverCompassDirection.equals(CardinalCompassPoints.NORTH.getPointValue())) {
                yCoordinate++;
            } else if (roverCompassDirection.equals(CardinalCompassPoints.EAST.getPointValue())) {
                xCoordinate++;
            } else if (roverCompassDirection.equals(CardinalCompassPoints.SOUTH.getPointValue())) {
                yCoordinate--;
            } else if (roverCompassDirection.equals(CardinalCompassPoints.WEST.getPointValue())) {
                xCoordinate--;
            }
        } else {
            throw new Exception("Invalid rover drive commands, rover is going out of plateau.");
        }
    }

    /**
     * print rover destinations coordinates and compass cardinal direction
     */

    public void printPosition() {
        System.out.println("Rover Current Position :" + xCoordinate + " " + yCoordinate + " " + roverCompassDirection);
    }
}
