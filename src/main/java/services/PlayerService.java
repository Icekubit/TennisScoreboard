package services;

import dao.PlayerDao;
import models.Player;

public class PlayerService {
    private static PlayerService instance;
    private PlayerService(){}

    public static PlayerService getInstance() {
        if (instance == null)
            instance = new PlayerService();
        return instance;
    }

    public Player getPlayerByNameOrCreate(String nameOfPlayer) {
        return PlayerDao.getInstance().getPlayerByNameOrCreate(nameOfPlayer);
    }

    public Player getPlayerById(int id) {
        return PlayerDao.getInstance().getPlayerById(id);
    }
}
