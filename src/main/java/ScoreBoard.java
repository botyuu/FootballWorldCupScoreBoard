import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ScoreBoard {
    private final ArrayList<Game> games;

    public ScoreBoard() {
        this.games = new ArrayList<>();
    }

    public void startGame(String homeTeam, String awayTeam) {
        games.add(new Game(homeTeam, awayTeam, System.currentTimeMillis()));
        System.out.println("Added: " + homeTeam + " vs " + awayTeam);
    }

    public void finishGame(int index) {
        Game game = games.remove(index);
        System.out.println("Game has finished with total score: " + game);
    }

    public void updateGame(int index, int homeTeamScore, int awayTeamScore) {
        games.get(index).updateScore(homeTeamScore, awayTeamScore, System.currentTimeMillis());
        System.out.println("Game has been updated: ");
    }

    public void printBoardByTotalScoreAndLastUpdated() {
        games.sort(Comparator.comparingInt(Game::getTotalScore)
                .thenComparingLong(Game::getLastUpdated));

        IntStream.range(0, games.size())
                .forEach(i -> System.out.println(i + ". " + games.get(i)));
    }

}
