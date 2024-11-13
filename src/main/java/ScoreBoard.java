import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

@Getter
public class ScoreBoard {
    private final ArrayList<Game> games;
    private final UserInterface ui;

    public ScoreBoard(UserInterface ui) {
        this.ui = ui;
        this.games = new ArrayList<>();
    }

    public void startGame() {
        String homeTeam = ui.readTeamName("Set home name team: ");
        String awayTeam = ui.readTeamName("Set away name team: ");
        games.add(new Game(homeTeam, awayTeam, System.currentTimeMillis()));
        ui.showMessage("Added: " + homeTeam + " vs " + awayTeam);
    }

    public void finishGame() {
        printBoardByTotalScoreAndLastUpdated();
        int index = ui.selectGameIndex(games.size());
        Game game = games.remove(index);
        ui.showMessage("Game has finished with total score: " + game);
    }


    public void updateGame() {
        printBoardByTotalScoreAndLastUpdated();
        int index = ui.selectGameIndex(games.size());
        int homeTeamScore = ui.readScore("Home team score: ");
        int awayTeamScore = ui.readScore("Away team score: ");
        games.get(index).updateScore(homeTeamScore, awayTeamScore, System.currentTimeMillis());
        ui.showMessage("Game has been updated");
    }

    public void printBoardByTotalScoreAndLastUpdated() {
        games.sort(Comparator.comparingInt(Game::getTotalScore)
                .thenComparingLong(Game::getLastUpdated)
                .reversed());

        ui.displayGamesList(games);
    }

    public boolean isEmpty() {
        return this.games.isEmpty();
    }

}
