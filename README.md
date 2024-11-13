# FootballWorldCupScoreBoard
## Description
The **FootballWorldCupScoreBoard** is a simple console application that helps manage sports team matches. 
It allows users to:
- Add new matches
- Update scores
- Finish matches
- View match results
  
## Requirements
- Java 21

## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/botyuu/FootballWorldCupScoreBoard
    ```
2. Go to the project directory:
    ```bash
    cd project-name
    ```
3. Install dependencies, compile the code, and run tests:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn exec:java -Dexec.mainClass="Main"
    ```

## Usage
1. Run the application.
2. Select one of the available options that will be displayed in the console.
3. Start adding new matches or viewing results.
4. "Finish" or "Update" options will be available only when there are active matches.

## Example
```java
// Get a summary
Select option by adding number:
0 - Exit
1 - Get a summary of games by total score
2 - Start a game
Enter your choice: 1

// Start a game
Select option by adding number:
0 - Exit
1 - Get a summary of games by total score
2 - Start a game
Enter your choice: 2
Set home name team: UK
Set away name team: USA
Added: UK vs USA

// Update score
Select option by adding number:
0 - Exit
1 - Get a summary of games by total score
2 - Start a game
3 - Finish a game
4 - Update score
Enter your choice: 4
1. UK 0 - USA 0
Select game number: 1
Home team score: 2
Away team score: 3
Game has been updated
