package models;

import lombok.Data;
import services.newScore.MatchScore;

@Data
public class CurrentMatch {
    private String firstPlayerName;
    private String secondPlayerName;
    private MatchScore matchScore;

    public CurrentMatch(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
        matchScore = new MatchScore();
    }
}
