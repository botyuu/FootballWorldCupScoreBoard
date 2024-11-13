import lombok.Getter;
@Getter
public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore = 0;
    private int awayScore = 0;
    private long lastUpdated;

    public Game(String homeTeam, String awayTeam, long lastUpdated) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.lastUpdated = lastUpdated;
    }

    public void updateScore(int homeScore, int awayScore, long updateTime) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.lastUpdated = updateTime;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }
}
