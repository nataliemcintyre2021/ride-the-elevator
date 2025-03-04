package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ride {
    int currentFloor;
    List<Integer> floorsSelected;
    int numOfRiders;

    Ride(int currentFloor, ArrayList<Integer> floorsSelected, int numOfRiders) {
        this.currentFloor = currentFloor;
        this.floorsSelected = floorsSelected;
        this.numOfRiders = numOfRiders;
    }

    public List<Integer> getFloorsSelected() {
        return floorsSelected;
    }

    public void setFloorsSelected(List<Integer> floorsSelected) {
        this.floorsSelected = floorsSelected;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getNumOfRiders() {
        return numOfRiders;
    }

    public void setNumOfRiders(int numOfRiders) {
        this.numOfRiders = numOfRiders;
    }

}
