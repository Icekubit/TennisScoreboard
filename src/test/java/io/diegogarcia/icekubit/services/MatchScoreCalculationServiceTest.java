package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.models.CurrentMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatchScoreCalculationServiceTest {

    private MatchScoreCalculationService matchScoreCalculationService;
    private CurrentMatch match;

    @BeforeEach
    public void setUp() {
        matchScoreCalculationService = MatchScoreCalculationService.getInstance();
        match = new CurrentMatch("firstPlayer", "secondPlayer");
    }
    @Test
    void testNotEndingOfGameAfterAddingPointAfterScoreInGame4040() {
        for (int i = 0; i < 3; i++) {
            // 0-0 15-15 30-30 40-40
            matchScoreCalculationService.handlePoint(match, 1);
            matchScoreCalculationService.handlePoint(match, 2);
        }
        assertEquals("40", match.getScore().getPointsOfFirstPlayer());
        assertEquals("40", match.getScore().getPointsOfSecondPlayer());

        matchScoreCalculationService.handlePoint(match, 1);
        // A-40
        assertEquals("A", match.getScore().getPointsOfFirstPlayer());

        matchScoreCalculationService.handlePoint(match, 2);
        // 40-40
        assertEquals("40", match.getScore().getPointsOfFirstPlayer());
        assertEquals("40", match.getScore().getPointsOfSecondPlayer());

        matchScoreCalculationService.handlePoint(match,2);
        // 40-A
        assertEquals("A", match.getScore().getPointsOfSecondPlayer());
        assertEquals(0, match.getScore().getWinningGamesOfFirstPlayer());
    }

    @Test
    void testAddingGameAfterAddingPointWhenScoreInGame4000() {
        for (int i = 0; i < 4; i++) {
            // 0-15-30-40-0
            matchScoreCalculationService.handlePoint(match, 1);
        }
        assertEquals("0", match.getScore().getPointsOfFirstPlayer());
        assertEquals(1, match.getScore().getWinningGamesOfFirstPlayer());
    }

    @Test
    void testTieBreak() {
        for (int i = 0; i < 21; i++) {
            // Games: 5-0
            matchScoreCalculationService.handlePoint(match, 1);
        }
        assertEquals(5, match.getScore().getWinningGamesOfFirstPlayer());
        for (int i = 0; i < 25; i++) {
            // Games: 5-6
            matchScoreCalculationService.handlePoint(match, 2);
        }
        assertEquals(6, match.getScore().getWinningGamesOfSecondPlayer());
        for (int i = 0; i < 4; i++) {
            // Games: 6-6
            matchScoreCalculationService.handlePoint(match, 1);
        }
        assertEquals(6, match.getScore().getWinningGamesOfFirstPlayer());
        assertEquals(6, match.getScore().getWinningGamesOfSecondPlayer());
        assertTrue(match.getScore().isTieBreak());
    }

}
