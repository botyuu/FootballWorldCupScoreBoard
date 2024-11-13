import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameTest {

    private Game game;
    @BeforeEach
    void setUp() {
        game = new Game("San Marino", "Germany", System.currentTimeMillis());
    }

    @Test
    void shouldReturnZeroTotalScore_whenStartedGame() {
        Game game = new Game("Poland", "Germany", System.currentTimeMillis());
        assertEquals(0, game.getTotalScore());
    }

    @Test
    void shouldReturnSumTotalScore_whenUpdatedScore() {
        game.updateScore(5, 1, System.currentTimeMillis());
        assertEquals(6, game.getTotalScore());
    }

    @Test
    void shouldChangeLastUpdated_whenUpdatedScore() {
        long beforeUpdate = game.getLastUpdated();
        game.updateScore(6, 1, System.currentTimeMillis());
        assertTrue(game.getLastUpdated() > beforeUpdate);
    }


}
