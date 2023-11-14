package services;

import dao.MatchesDao;
import models.CurrentMatch;
import models.Match;
import models.Player;

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
