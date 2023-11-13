package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.models.CurrentMatch;

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
//        int firstPlayerId = PlayerService.getInstance().getPlayerByNameOrCreate(firstPlayerName).getId();
//        int secondPlayerId = PlayerService.getInstance().getPlayerByNameOrCreate(secondPlayerName).getId();
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
}
