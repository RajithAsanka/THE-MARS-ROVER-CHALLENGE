package com.mrc;

import java.util.Scanner;

public class MarsPlateauExploration {

    public static void main(String[] args) {

        ProcessDashboardCommands processDashboardCommands = new ProcessDashboardCommands();// create commands processing object
        Scanner input = new Scanner(System.in); //  create scanner for read input commands
        System.out.println("Enter upper-right coordinates of the plateau.");
        String upperRightCoordinates = input.nextLine();

        // create plateau according to coordinates
        MarsPlateau plateauGrid = null;
        try {
            plateauGrid = processDashboardCommands.createPlateauGrid(upperRightCoordinates);
        } catch (NumberFormatException e) {
            System.out.println("Invalid inputs  for plateau upper-right coordinates, exploration aborted. Please enter valid coordinates");
        }


        System.out.println("Enter Rover position coordinates and Orientation.");
        while (input.hasNext()) {

            try {

                Rover rover = processDashboardCommands.prepareRoverForExploration(plateauGrid, input.nextLine());
                System.out.println("Enter Rover explore instructions.");

                rover.proceedRoverInstructions(input.nextLine());
                rover.printPosition();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }


    }


}
