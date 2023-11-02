package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.models.Match;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OngoingMatchesService {
    private static OngoingMatchesService instance;
    private Map<UUID, Match> ongoingMatches = new HashMap<>();
    private OngoingMatchesService() {}
    public static OngoingMatchesService getInstance() {
        if (instance == null)
            instance = new OngoingMatchesService();
        return instance;
    }

    public UUID addMatch(String firstPlayerName, String secondPlayerName) {
        int firstPlayerId = PlayerService.getInstance().getPlayerByNameOrCreate(firstPlayerName).getId();
        int secondPlayerId = PlayerService.getInstance().getPlayerByNameOrCreate(secondPlayerName).getId();
        UUID matchId = UUID.randomUUID();
        ongoingMatches.put(matchId, new Match(firstPlayerId, secondPlayerId));
        System.out.println(matchId);
        return matchId;
    }

    public Match getMatch(UUID matchId) {
        return ongoingMatches.get(matchId);
    }
    public void deleteMatch(UUID matchId) {
        ongoingMatches.remove(matchId);
    }
}
