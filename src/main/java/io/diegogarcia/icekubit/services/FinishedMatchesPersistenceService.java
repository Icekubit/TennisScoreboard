package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.dao.MatchesDao;
import io.diegogarcia.icekubit.models.CurrentMatch;
import io.diegogarcia.icekubit.models.Match;

import java.util.List;

public class FinishedMatchesPersistenceService {
    private static FinishedMatchesPersistenceService instance;
    private FinishedMatchesPersistenceService() {}
    public static FinishedMatchesPersistenceService getInstance() {
        if (instance == null)
            instance = new FinishedMatchesPersistenceService();
        return instance;
    }

    public void save(CurrentMatch match) {
        Match matchEntity = new Match();
        matchEntity.setPlayer1(PlayerService.getInstance().getPlayerById(match.getFirstPlayerId()));
        matchEntity.setPlayer2(PlayerService.getInstance().getPlayerById(match.getSecondPlayerId()));
        int winnerId = match.getScore().getWinningSetsOfFirstPlayer() == 2 ? match.getFirstPlayerId() : match.getSecondPlayerId();
        matchEntity.setWinner(PlayerService.getInstance().getPlayerById(winnerId));
        MatchesDao.getInstance().save(matchEntity);
    }

    public List<Match> findAll() {
        return MatchesDao.getInstance().findAll();
    }
}
