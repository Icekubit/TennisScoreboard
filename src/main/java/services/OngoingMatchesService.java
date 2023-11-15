package services;

import models.CurrentMatch;
import models.MatchDto;
import services.newScore.GameRegularPlayerPoints;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OngoingMatchesService {
    private static OngoingMatchesService instance;
    private Map<UUID, CurrentMatch> ongoingMatches = new HashMap<>();
    private OngoingMatchesService() {}
    public static OngoingMatchesService getInstance() {
        if (instance == null)
            instance = new OngoingMatchesService();
        return instance;
    }

    public UUID CreateCurrentMatch(String firstPlayerName, String secondPlayerName) {
        UUID matchId = UUID.randomUUID();
        ongoingMatches.put(matchId, new CurrentMatch(firstPlayerName, secondPlayerName));
        return matchId;
    }

    public CurrentMatch getMatch(UUID matchId) {
        return ongoingMatches.get(matchId);
    }
    public void deleteMatch(UUID matchId) {
        ongoingMatches.remove(matchId);
    }

    public MatchDto getCurrentMatchScoreDto(UUID matchId) {
        MatchDto matchDto = new MatchDto();
        CurrentMatch currentMatch = ongoingMatches.get(matchId);
        matchDto.setFirstPlayerName(currentMatch.getFirstPlayerName());
        matchDto.setSecondPlayerName(currentMatch.getSecondPlayerName());
        matchDto.setWinningSetsOfFirstPlayer(currentMatch.getMatchScore().getPlayerScore(0));
        matchDto.setWinningSetsOfSecondPlayer(currentMatch.getMatchScore().getPlayerScore(1));
        matchDto.setWinningGamesOfFirstPlayer(currentMatch.getMatchScore().getCurrentSet().getPlayerScore(0));
        matchDto.setWinningGamesOfSecondPlayer(currentMatch.getMatchScore().getCurrentSet().getPlayerScore(1));
        if (currentMatch.getMatchScore().getCurrentSet().isTieBreak()) {
            matchDto.setPointsOfFirstPlayer(currentMatch.getMatchScore().getCurrentSet().getCurrentGame().getPlayerScore(0).toString());
            matchDto.setPointsOfSecondPlayer(currentMatch.getMatchScore().getCurrentSet().getCurrentGame().getPlayerScore(1).toString());
        } else {
            GameRegularPlayerPoints pointsOfFirstPlayer = (GameRegularPlayerPoints) currentMatch.getMatchScore().getCurrentSet().getCurrentGame().getPlayerScore(0);
            GameRegularPlayerPoints pointsOfSecondPlayer = (GameRegularPlayerPoints) currentMatch.getMatchScore().getCurrentSet().getCurrentGame().getPlayerScore(1);
            matchDto.setPointsOfFirstPlayer(pointsOfFirstPlayer.getPointCode());
            matchDto.setPointsOfSecondPlayer(pointsOfSecondPlayer.getPointCode());
        }
        return matchDto;
    }
}
