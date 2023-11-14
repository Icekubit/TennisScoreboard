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
    }

}
