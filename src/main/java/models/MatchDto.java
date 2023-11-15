package models;

import lombok.Data;

@Data
public class MatchDto {
    private String firstPlayerName;
    private String secondPlayerName;
    private int winningSetsOfFirstPlayer;
    private int winningSetsOfSecondPlayer;
    private int winningGamesOfFirstPlayer;
    private int winningGamesOfSecondPlayer;
    private String pointsOfFirstPlayer;
    private String pointsOfSecondPlayer;
}
