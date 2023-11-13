package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.dao.MatchesDao;
import io.diegogarcia.icekubit.models.CurrentMatch;
import io.diegogarcia.icekubit.models.Match;
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

    public void save(CurrentMatch currentMatch) {
        Match match = new Match();
        Player firstPlayer = PlayerService.getInstance().getPlayerByNameOrCreate(currentMatch.getFirstPlayerName());
        Player secondPlayer = PlayerService.getInstance().getPlayerByNameOrCreate(currentMatch.getSecondPlayerName());
        match.setPlayer1(firstPlayer);
        match.setPlayer2(secondPlayer);
        if (currentMatch.getScore().getWinningSetsOfFirstPlayer() == 2)
            match.setWinner(firstPlayer);
        else
            match.setWinner(secondPlayer);
        MatchesDao.getInstance().save(match);
//        Match matchEntity = new Match();
//        matchEntity.setPlayer1(PlayerService.getInstance().getPlayerById(match.getFirstPlayerId()));
//        matchEntity.setPlayer2(PlayerService.getInstance().getPlayerById(match.getSecondPlayerId()));
//        int winnerId = match.getScore().getWinningSetsOfFirstPlayer() == 2 ? match.getFirstPlayerId() : match.getSecondPlayerId();
//        matchEntity.setWinner(PlayerService.getInstance().getPlayerById(winnerId));
//        MatchesDao.getInstance().save(matchEntity);
    }

    public List<Match> findAll() {
        return MatchesDao.getInstance().findAll();
    }
}
