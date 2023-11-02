package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.dao.MatchesDao;
import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.models.MatchEntity;
import io.diegogarcia.icekubit.models.Player;

import java.util.List;

public class FinishedMatchesPersistenceService {
    private static FinishedMatchesPersistenceService instance;
    private FinishedMatchesPersistenceService() {}
    public static FinishedMatchesPersistenceService getInstance() {
        if (instance == null)
            instance = new FinishedMatchesPersistenceService();
        return instance;
    }

    public void save(Match match) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setPlayer1(PlayerService.getInstance().getPlayerById(match.getFirstPlayerId()));
        matchEntity.setPlayer2(PlayerService.getInstance().getPlayerById(match.getSecondPlayerId()));
        int winnerId = match.getScore().getWinningSetsOfFirstPlayer() == 2 ? match.getFirstPlayerId() : match.getSecondPlayerId();
        matchEntity.setWinner(PlayerService.getInstance().getPlayerById(winnerId));
        MatchesDao.getInstance().save(matchEntity);
        System.out.println(MatchesDao.getInstance().findAll());
    }

    public List<MatchEntity> findAll() {
        return MatchesDao.getInstance().findAll();
    }
}
