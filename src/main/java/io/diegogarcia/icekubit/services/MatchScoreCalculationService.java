package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.models.CurrentMatch;

public class MatchScoreCalculationService {
    private static MatchScoreCalculationService instance;
    private MatchScoreCalculationService() {}
    public static MatchScoreCalculationService getInstance() {
        if (instance == null)
            instance = new MatchScoreCalculationService();
        return instance;
    }
//    public void addPoint(Match match, int playerId) {
//        if (match.getFirstPlayerId() == playerId)
//            match.getScore().addFirstPlayerPoints();
//        else
//            match.getScore().addSecondPlayerPoints();
//    }



    public void handlePoint(CurrentMatch match, int playerId) {
        if (!match.getScore().isTieBreak())
            addPointsToPlayer(match, playerId);
        else
            addTieBreakPointToPlayer(match, playerId);
    }

    public boolean isFinished(CurrentMatch match) {
        return match.getScore().getWinningSetsOfFirstPlayer() == 2
                || match.getScore().getWinningSetsOfSecondPlayer() == 2;
    }

    private void addPointsToPlayer(CurrentMatch match, int playerId) {
        String playerPoints, opponentPoints;
        if (match.getFirstPlayerId() == playerId) {
            playerPoints = match.getScore().getPointsOfFirstPlayer();
            opponentPoints = match.getScore().getPointsOfSecondPlayer();
        } else {
            playerPoints = match.getScore().getPointsOfSecondPlayer();
            opponentPoints = match.getScore().getPointsOfFirstPlayer();
        }

        switch (playerPoints) {
            case "0":
                playerPoints = "15";
                break;
            case "15":
                playerPoints = "30";
                break;
            case "30":
                playerPoints = "40";
                break;
            case "40":
                if (!opponentPoints.equals("40") && !opponentPoints.equals("A")) {
                    playerPoints = "0";
                    opponentPoints = "0";
                    addGamesToPlayer(match, playerId);
                } else if (opponentPoints.equals("40")) {
                    playerPoints = "A";
                } else if (opponentPoints.equals("A")) {
                    opponentPoints = "40";
                }
                break;
            case "A":
                playerPoints = "0";
                opponentPoints = "0";
                addGamesToPlayer(match, playerId);
                break;
            default:
                throw new RuntimeException("Unhandled case");
        }
        if (match.getFirstPlayerId() == playerId) {
            match.getScore().setPointsOfFirstPlayer(playerPoints);
            match.getScore().setPointsOfSecondPlayer(opponentPoints);
        } else {
            match.getScore().setPointsOfSecondPlayer(playerPoints);
            match.getScore().setPointsOfFirstPlayer(opponentPoints);
        }
    }

    private void addTieBreakPointToPlayer(CurrentMatch match, int playerId) {
        int playerTieBreakPoints, opponentTieBreakPoints;
        if (match.getFirstPlayerId() == playerId) {
            playerTieBreakPoints = Integer.valueOf(match.getScore().getPointsOfFirstPlayer());
            opponentTieBreakPoints = Integer.valueOf(match.getScore().getPointsOfSecondPlayer());
        } else {
            playerTieBreakPoints = Integer.valueOf(match.getScore().getPointsOfSecondPlayer());
            opponentTieBreakPoints = Integer.valueOf(match.getScore().getPointsOfFirstPlayer());
        }

        if (playerTieBreakPoints < 6
                || playerTieBreakPoints >= 6 && (playerTieBreakPoints == opponentTieBreakPoints)
                || playerTieBreakPoints >= 6 && (opponentTieBreakPoints - playerTieBreakPoints == 1)
        ) {
            playerTieBreakPoints++;
            if (match.getFirstPlayerId() == playerId) {
                match.getScore().setPointsOfFirstPlayer(Integer.toString(playerTieBreakPoints));
            } else {
                match.getScore().setPointsOfSecondPlayer(Integer.toString(playerTieBreakPoints));
            }
        } else if (playerTieBreakPoints >= 6 && (playerTieBreakPoints - opponentTieBreakPoints) >= 1) {
            addSetToPlayer(match, playerId);
        } else {
            throw new RuntimeException("Unhandled case");
        }
    }

    private void addGamesToPlayer(CurrentMatch match, int playerId) {
        int playerGames, opponentGames;
        if (match.getFirstPlayerId() == playerId) {
            playerGames = match.getScore().getWinningGamesOfFirstPlayer();
            opponentGames = match.getScore().getWinningGamesOfSecondPlayer();
        } else {
            playerGames = match.getScore().getWinningGamesOfSecondPlayer();
            opponentGames = match.getScore().getWinningGamesOfFirstPlayer();
        }

        if (playerGames <= 4 || playerGames == 5 && opponentGames == 5) {
            playerGames++;
            if (match.getFirstPlayerId() == playerId) {
                match.getScore().setWinningGamesOfFirstPlayer(playerGames);
            } else {
                match.getScore().setWinningGamesOfSecondPlayer(playerGames);
            }
        } else if (playerGames == 5 && opponentGames <= 4 || playerGames == 6 && opponentGames == 5) {
            addSetToPlayer(match, playerId);
        } else if (playerGames == 5 && opponentGames == 6) {
            startTieBreak(match);
        }
    }

    private void addSetToPlayer(CurrentMatch match, int playerId) {
        if (match.getFirstPlayerId() == playerId) {
            int sets = match.getScore().getWinningSetsOfFirstPlayer() + 1;
            match.getScore().setWinningSetsOfFirstPlayer(sets);
        } else {
            int sets = match.getScore().getWinningSetsOfSecondPlayer() + 1;
            match.getScore().setWinningSetsOfSecondPlayer(sets);
        }
        match.getScore().setWinningGamesOfFirstPlayer(0);
        match.getScore().setWinningGamesOfSecondPlayer(0);
        match.getScore().setPointsOfFirstPlayer("0");
        match.getScore().setPointsOfSecondPlayer("0");
        match.getScore().setTieBreak(false);
    }

    private void startTieBreak(CurrentMatch match) {
        match.getScore().setWinningGamesOfFirstPlayer(6);
        match.getScore().setWinningGamesOfSecondPlayer(6);
        match.getScore().setPointsOfFirstPlayer("0");
        match.getScore().setPointsOfSecondPlayer("0");
        match.getScore().setTieBreak(true);
    }



}
