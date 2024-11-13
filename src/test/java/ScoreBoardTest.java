import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScoreBoardTest {

    private ScoreBoard scoreBoard;
    private UserInterface ui;

    @BeforeEach
    void setUp() {
        ui = mock(UserInterface.class);
        scoreBoard = new ScoreBoard(ui);
    }

    @Test
    void shouldReturnBoardWithAddedGame_whenStartedGame() {
        when(ui.readTeamName("Set home name team: ")).thenReturn("San Marino");
        when(ui.readTeamName("Set away name team: ")).thenReturn("Germany");

        scoreBoard.startGame();

        assertEquals(1, scoreBoard.getGames().size());
        assertEquals("San Marino", scoreBoard.getGames().getFirst().getHomeTeam());
        assertEquals("Germany", scoreBoard.getGames().getFirst().getAwayTeam());
        assertEquals(0, scoreBoard.getGames().getFirst().getTotalScore());
    }

    @Test
    void shouldUpdateScore_whenUpdatedGame() {
        addGame("Mexico", "Canada", 0, 5, 0);

        Game game = scoreBoard.getGames().getFirst();
        assertEquals(0, game.getHomeScore());
        assertEquals(5, game.getAwayScore());
        assertEquals(5, game.getTotalScore());
    }

    @Test
    void shouldReturnEmptyBoard_whenFinishedGame() {
        addGame("Mexico", "Canada", 0, 5, 0);
        scoreBoard.finishGame();
        assertTrue(scoreBoard.isEmpty());
    }

    @Test
    void shouldReturnTeamsNamesInRightOrder_whenAddingMultipleGames() {
        addGame("Mexico", "Canada", 0, 5, 0);
        addGame("Spain", "Brazil", 10, 2, 1);
        addGame("Germany", "France", 2, 2, 2);
        addGame("Uruguay", "Italy", 6, 6, 3);
        addGame("Argentina", "Australia", 3, 1, 4);
        scoreBoard.printBoardByTotalScoreAndLastUpdated();

        List<String[]> expectedTeams = Arrays.asList(
                new String[]{"Uruguay", "Italy"},
                new String[]{"Spain", "Brazil"},
                new String[]{"Mexico", "Canada"},
                new String[]{"Argentina", "Australia"},
                new String[]{"Germany", "France"}
        );

        for (int i = 0; i < expectedTeams.size(); i++) {
            assertEquals(expectedTeams.get(i)[0], scoreBoard.getGames().get(i).getHomeTeam());
            assertEquals(expectedTeams.get(i)[1], scoreBoard.getGames().get(i).getAwayTeam());
        }
    }

    @Test
    void shouldReturnScoreInRightOrder_whenAddingMultipleGames() {
        addGame("Mexico", "Canada", 0, 5, 0);
        addGame("Spain", "Brazil", 10, 2, 1);
        addGame("Germany", "France", 2, 2, 2);
        addGame("Uruguay", "Italy", 6, 6, 3);
        addGame("Argentina", "Australia", 3, 1, 4);
        scoreBoard.printBoardByTotalScoreAndLastUpdated();

        List<Integer[]> expectedTeams = Arrays.asList(
                new Integer[]{6, 6},
                new Integer[]{10, 2},
                new Integer[]{0, 5},
                new Integer[]{3, 1},
                new Integer[]{2, 2}
        );

        for (int i = 0; i < expectedTeams.size(); i++) {
            assertEquals(expectedTeams.get(i)[0], scoreBoard.getGames().get(i).getHomeScore());
            assertEquals(expectedTeams.get(i)[1], scoreBoard.getGames().get(i).getAwayScore());
        }
    }

    private void addGame(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore, int index) {
        when(ui.readTeamName("Set home name team: ")).thenReturn(homeTeamName);
        when(ui.readTeamName("Set away name team: ")).thenReturn(awayTeamName);
        scoreBoard.startGame();
        when(ui.selectGameIndex(scoreBoard.getGames().size())).thenReturn(index);
        when(ui.readScore("Home team score: ")).thenReturn(homeTeamScore);
        when(ui.readScore("Away team score: ")).thenReturn(awayTeamScore);
        scoreBoard.updateGame();
    }
}