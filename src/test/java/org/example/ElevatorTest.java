package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ElevatorTest {
    private Scanner mockScanner;
    private Elevator elevator;
    private Ride ride;
    private CarOperatingPanel carOperatingPanel;

    @BeforeEach
    void setUp() {
        mockScanner = mock(Scanner.class);
        carOperatingPanel = mock(CarOperatingPanel.class);
        ride = new Ride(1, new ArrayList<>(), 0);
        elevator = new Elevator(mockScanner, carOperatingPanel, ride);
    }

    @Test
    void shouldGetNumberOfPeopleRidingBasedOnInput() {
        when(mockScanner.nextInt()).thenReturn(3);
        elevator.getNumberOfPeopleRiding();

        assertEquals(3, ride.getNumOfRiders());
    }

    @Test
    void shouldSetFloorsSelectedForGoingUp() {
        List<Integer> floors = List.of(2, 3, 4);

        when(mockScanner.nextInt()).thenReturn(4);
        elevator.getNumberOfPeopleRiding();

        when(mockScanner.nextInt()).thenReturn(2, 3, 4, 4);
        elevator.inputUpFloors();

        assertEquals(floors, ride.getFloorsSelected());
    }

    @Test
    void shouldSetFloorsSelectedForGoingDown() {
        List<Integer> floors = List.of(-2, -3);

        when(mockScanner.nextInt()).thenReturn(4);
        elevator.getNumberOfPeopleRiding();

        when(mockScanner.nextInt()).thenReturn(-3, -2, -2, -2);
        elevator.inputDownFloors();

        assertEquals(floors, ride.getFloorsSelected());
    }

    @Test
    void shouldRemoveAllRidersAndFloorsToTravelToAfterRideComplete() {
        when(mockScanner.nextInt()).thenReturn(4);
        elevator.getNumberOfPeopleRiding();

        when(mockScanner.nextInt()).thenReturn(2, 3, 4, 4);
        elevator.inputUpFloors();

        elevator.startMoving();

        assertEquals(0, ride.getFloorsSelected().size());
        assertEquals(0, ride.getNumOfRiders());
    }

}