package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        CarOperatingPanel carOperatingPanel = new CarOperatingPanel();
        Ride ride = new Ride(1, new ArrayList<>(0), 0);

        Elevator elevator = new Elevator(reader, carOperatingPanel, ride);

        int buttonSelection = elevator.startRide();

        while (buttonSelection != -1) {
            switch (buttonSelection) {
                case ElevatorDirection.UP -> {
                    elevator.getRideDetails(ElevatorDirection.UP);
                }
                case ElevatorDirection.DOWN -> {
                    elevator.getRideDetails(ElevatorDirection.DOWN);
                }
                default -> {
                    System.out.print("\nYou have selected an invalid option.\n");
                }
            }
            buttonSelection = elevator.startRide();
        }

        System.out.println("Elevator ride complete. Goodbye");
    }
}