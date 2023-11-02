package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.models.Match;

public class MatchScoreCalculationService {
    private static MatchScoreCalculationService instance;
    private MatchScoreCalculationService() {}
    public static MatchScoreCalculationService getInstance() {
        if (instance == null)
            instance = new MatchScoreCalculationService();
        return instance;
    }
    public boolean addPoint(Match match, int playerId) {
        if (match.getFirstPlayerId() == playerId)
            match.getScore().addFirstPlayerPoints();
        else
            match.getScore().addSecondPlayerPoints();
        return match.getScore().isFinished();
    }
}
