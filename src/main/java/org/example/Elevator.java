package org.example;

import java.util.*;

public class Elevator {

    private final Scanner reader;
    private final CarOperatingPanel carOperatingPanel;
    private final Ride ride;

    public Elevator(Scanner reader, CarOperatingPanel carOperatingPanel, Ride ride) {
        this.reader = reader;
        this.carOperatingPanel = carOperatingPanel;
        this.ride = ride;
    }

    public void simulateWait() {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startMoving() {
        for (int i = 0; i < ride.getFloorsSelected().size(); i++) {
            System.out.println("\nDoors are closing. You are now traveling to floor " + ride.getFloorsSelected().get(i) + ".");
            simulateWait();
            System.out.println("\nYou have now arrived at floor " + ride.getFloorsSelected().get(i) + ".");
            ride.setCurrentFloor(ride.getFloorsSelected().get(i));
            simulateWait();
        }

        ride.setNumOfRiders(0);
        ride.setFloorsSelected(new ArrayList<>(0));
    }

    public void getNumberOfPeopleRiding() {
        int number;
        System.out.println("\nHow many people will be riding today? Elevator has a capacity of 10 people.");
        number = reader.nextInt();
        while (number < 0 || number > 10) {
            System.out.println("\nInvalid number of people. Please re-enter number of people. Capacity of elevator is 10 people.");
            number = reader.nextInt();
        }
        ride.setNumOfRiders(number);
    }

    public void inputUpFloors() {
        int buttonPressed;
        while (ride.getFloorsSelected().size() < ride.getNumOfRiders()) {
            System.out.println(carOperatingPanel.showFloors(ride.getFloorsSelected().size() + 1));
            buttonPressed = reader.nextInt();
            if (buttonPressed > carOperatingPanel.topFloor || buttonPressed  < carOperatingPanel.bottomFloor) {
                System.out.print("\nYou have selected an invalid floor option.\n");
                continue;
            }

            while (buttonPressed <= ride.getCurrentFloor()) {
                System.out.println("Please select a floor higher than " + ride.getCurrentFloor() + ". This elevator is going UP.");
                buttonPressed = reader.nextInt();
            }

            ride.getFloorsSelected().add(buttonPressed);
        }

        Collections.sort(ride.getFloorsSelected());

        ride.setFloorsSelected(ride.getFloorsSelected().stream().distinct().toList());
    }

    public void inputDownFloors() {
        int buttonPressed;
        while (ride.floorsSelected.size() < ride.getNumOfRiders()) {
            System.out.println(carOperatingPanel.showFloors(ride.getFloorsSelected().size() + 1));
            buttonPressed = reader.nextInt();

            if (buttonPressed > carOperatingPanel.topFloor || buttonPressed  < carOperatingPanel.bottomFloor) {
                System.out.print("\nYou have selected an invalid floor option.\n");
                continue;
            }

            while (buttonPressed >= ride.getCurrentFloor()) {
                System.out.println("Please select a floor lower than " + ride.getCurrentFloor() + ". This elevator is going DOWN.");
                buttonPressed = reader.nextInt();
            }

            ride.getFloorsSelected().add(buttonPressed);
        }

        Collections.sort(ride.getFloorsSelected(), Collections.reverseOrder());
        ride.setFloorsSelected(ride.getFloorsSelected().stream().distinct().toList());
    }

    public void getRideDetails(int direction) {
           if (direction == ElevatorDirection.UP) {
               if (ride.getCurrentFloor() == carOperatingPanel.topFloor) {
                   System.out.println("\nYou can't go any higher! Please select the DOWN button.\n");
                   return;
               }
               getNumberOfPeopleRiding();
               inputUpFloors();
           } else if (direction == ElevatorDirection.DOWN) {
               if (ride.getCurrentFloor() == carOperatingPanel.bottomFloor) {
                   System.out.println("\nYou can't go any lower! Please select the UP button.\n");
                   return;
               }
               getNumberOfPeopleRiding();
               inputDownFloors();
           }

        startMoving();
        System.out.println("\nAll people have exited. Have a great day.\n");
        simulateWait();
    }

    private int getStartingInput() {
        int choice = 0;

        while (choice == 0) {
            try {
                choice = reader.nextInt();

                if (choice == 0) {
                    throw new InputMismatchException();
                }
                reader.nextLine();
            }
            catch (InputMismatchException e) {
                reader.nextLine();
                System.out.print("ERROR: INPUT IS INVALID. Please try again: ");
            }
        }
        return choice;
    }

    public int startRide() {
        int buttonChoice;
        System.out.println("Welcome to the elevator ride. All aboard.");
        System.out.println("We are on floor " + ride.getCurrentFloor());
        System.out.println("======================================================");
        System.out.println("1) UP");
        System.out.println("2) DOWN");
        System.out.print("\nPlease select an option to ride UP (enter 1) or DOWN (enter 2) (or Enter -1 to quit): ");

        buttonChoice = getStartingInput();
        return buttonChoice;
    }
}
