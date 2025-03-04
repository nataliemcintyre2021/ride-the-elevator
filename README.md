# Ride the Elevator Project
This project was made in response to the prompt: "Provide code that simulates an elevator" (Java)

## Approach and Assumptions
Approaching this project as a Junior level Java developer with a short amount of time, there were a few goals I had in mind, including:
- Thinking about an elevator in an Object Oriented Programming approach and demonstrating this in how the features were built
- Use basic Java concepts to demonstrate understanding
- Have tests written and take a TDD approach as much as possible
- Build project in a way that if I could not complete desired features, the program could be scaled

## Features Implemented
- User can interact with Scanner object to simulate the process of an elevator ride
- User can have options of an UP or DOWN ride
- User can input the number of riders in each elevator ride, and let each rider select a floor of choice
- Utilizing Elevator and Ride Classes, floors are stored and sorted as to let riders off in the ascending or descending sequence as selected by the direction they are going
- Starting at the last floor the last rider was dropped off, a new ride can be simulated
- Rider cannot select a floor higher or lower than their current floor depending on if they selected UP or DOWN

## Features Not Implemented/or Partially Implemented
- Error handling needs to be expanded. This is a critical piece as exceptions are not thrown in all cases when invalid inputs are entered. This should be the next story implemented.
   - Think about creating custom exceptions as well as making sure the user can exit the program at any time.
- More testing needs to be added. Unit tests for all classes. Component and integration tests can be expanded. Mocking and testing the Scanner object was new for me. More time needs to be spent on this. Also looking at testing more sad paths.
- Other ideas:
    - Implement Person or Rider class to store state about each rider or groups of riders.
    - Expand to multiple Rides (or could be called Lifts). These could be in play at the same time. Groups of people could be in waiting for the closest lift.
    - Expand the CarOperatingPanel to have more behavior





