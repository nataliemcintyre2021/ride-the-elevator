package org.example;

public class CarOperatingPanel {

    private final String[] floorButtons = {"-3", "-2", "-1", "0", "1", "2", "3", "4", "5", "6", "7", "8"};
    public final int topFloor = 8;
    public final int bottomFloor = -3;

    public String showFloors(int personSelecting) {
            return "\nPerson #" + personSelecting + ", select button for desired floor:  \n" + floorButtons[0] + "   " + floorButtons[1] + "   " + floorButtons[2] + "\n " +
                    floorButtons[3] + "    " + floorButtons[4] + "    " + floorButtons[5] + "   " + "\n " +
                    floorButtons[6] + "    " + floorButtons[7] + "    " + floorButtons[8] + "   " + "\n " +
                    floorButtons[9] + "    " + floorButtons[10] + "    " + floorButtons[11];
    }
}
