package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.models.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatchScoreCalculationServiceTest {

    private MatchScoreCalculationService matchScoreCalculationService;
    private Match match;

    @BeforeEach
    public void setUp() {
        matchScoreCalculationService = MatchScoreCalculationService.getInstance();
        match = new Match(1, 2);
    }
    @Test
    void testNotEndingOfGameAfterAddingPointAfterScoreInGame4040() {
        match.getScore().setPointsOfFirstPlayer("40");
        match.getScore().setPointsOfSecondPlayer("40");
        int firstPlayerGamesBeforeAddingPoint = match.getScore().getWinningGamesOfFirstPlayer();
        int secondPlayerGamesBeforeAddingPoint = match.getScore().getWinningGamesOfSecondPlayer();

        matchScoreCalculationService.handlePoint(match, 1);
        int firstPlayerGamesAfterAddingPoint = match.getScore().getWinningGamesOfFirstPlayer();
        int secondPlayerGamesAfterAddingPoint = match.getScore().getWinningGamesOfSecondPlayer();
        assertEquals(firstPlayerGamesBeforeAddingPoint, firstPlayerGamesAfterAddingPoint);
        assertEquals(secondPlayerGamesBeforeAddingPoint, secondPlayerGamesAfterAddingPoint);
        assertEquals(match.getScore().getPointsOfFirstPlayer(),"A");
    }

    @Test
    void testAddingGameAfterAddingPointWhenScoreInGame4000() {
        match.getScore().setPointsOfFirstPlayer("40");
        match.getScore().setPointsOfSecondPlayer("0");
        int firstPlayerGamesBeforeAddingPoint = match.getScore().getWinningGamesOfFirstPlayer();
        int secondPlayerGamesBeforeAddingPoint = match.getScore().getWinningGamesOfSecondPlayer();
        matchScoreCalculationService.handlePoint(match, 1);
        int firstPlayerGamesAfterAddingPoint = match.getScore().getWinningGamesOfFirstPlayer();
        int secondPlayerGamesAfterAddingPoint = match.getScore().getWinningGamesOfSecondPlayer();

        assertTrue(firstPlayerGamesAfterAddingPoint - firstPlayerGamesBeforeAddingPoint == 1);
        assertEquals(secondPlayerGamesBeforeAddingPoint, secondPlayerGamesAfterAddingPoint);
        assertEquals(match.getScore().getPointsOfFirstPlayer(), "0");
        assertEquals(match.getScore().getPointsOfSecondPlayer(), "0");
    }

    @Test
    void testTieBreak() {
        match.getScore().setWinningGamesOfFirstPlayer(5);
        match.getScore().setWinningGamesOfSecondPlayer(6);
        match.getScore().setPointsOfFirstPlayer("40");
        match.getScore().setPointsOfSecondPlayer("0");
        matchScoreCalculationService.handlePoint(match, 1);
        assertTrue(match.getScore().isTieBreak());
        assertEquals(match.getScore().getWinningGamesOfFirstPlayer(), 6);
        assertEquals(match.getScore().getWinningGamesOfSecondPlayer(), 6);
        assertEquals(match.getScore().getPointsOfFirstPlayer(), "0");
        assertEquals(match.getScore().getPointsOfSecondPlayer(), "0");
    }

}
