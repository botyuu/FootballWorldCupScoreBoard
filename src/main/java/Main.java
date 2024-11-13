import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ScoreBoard scoreBoard = new ScoreBoard(ui);
        boolean exit = false;

        while (!exit) {
            int option = ui.getMenuOption(scoreBoard.isEmpty());
            switch (option) {
                case 1 -> scoreBoard.printBoardByTotalScoreAndLastUpdated();
                case 2 -> scoreBoard.startGame();
                case 3 -> {
                    if (!scoreBoard.isEmpty()) {
                        scoreBoard.finishGame();
                    } else {
                        ui.showMessage("No games available to finish");
                    }
                }
                case 4 -> {
                    if (!scoreBoard.isEmpty()) {
                        scoreBoard.updateGame();
                    } else {
                        ui.showMessage("No games available to update");
                    }
                }
                case 0 -> exit = true;
                default -> ui.showMessage("Invalid input! Please select one of the available options.");
            }
        }
        ui.close();
    }
}
