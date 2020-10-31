package com.mrc;

/**
 * Developed by Rajith Asanka
 * Package : com.mrc.CardinalCompassPoints
 */

/**
 * helper class to process plateau exploration commands for Rover
 */
public class ProcessDashboardCommands {

    private String regex = "[0-9]+";


    public MarsPlateau createPlateauGrid(String plateauCoordinatesString) {

        String[] upperRightCoordinates = null;
        upperRightCoordinates = plateauCoordinatesString.split(" ");
        return new MarsPlateau(Integer.parseInt(upperRightCoordinates[0]), Integer.parseInt(upperRightCoordinates[1]));

    }

    public Rover prepareRoverForExploration(MarsPlateau plateau, String coordinatesWithOrientation) throws Exception {

        String[] coordinatesWithOrientationArray = coordinatesWithOrientation.split(" ");

        int xCoordinate = Integer.parseInt(coordinatesWithOrientationArray[0]);
        int yCoordinate = Integer.parseInt(coordinatesWithOrientationArray[1]);
        String roverOrientation = coordinatesWithOrientationArray[2];

        boolean validCoordinates = plateau.validateCoordinates(xCoordinate, yCoordinate);
        if (validCoordinates) {
            return new Rover(xCoordinate, yCoordinate, roverOrientation, plateau);
        } else {

            throw new Exception("Invalid coordinates commands for rover, plateau exploration aborted !!!");
        }

    }


}
