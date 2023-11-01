package io.diegogarcia.icekubit.models;

public class Score {
    private int winningSetsOfFirstPlayer;
    private int winningSetsOfSecondPlayer;
    private int winningGamesOfFirstPlayer;
    private int winningGamesOfSecondPlayer;
    private int pointsOfFirstPlayer;
    private int pointsOfSecondPlayer;

    @Override
    public String toString() {
        return "Score{" +
                "winningSetsOfFirstPlayer=" + winningSetsOfFirstPlayer +
                ", winningSetsOfSecondPlayer=" + winningSetsOfSecondPlayer +
                ", winningGamesOfFirstPlayer=" + winningGamesOfFirstPlayer +
                ", winningGamesOfSecondPlayer=" + winningGamesOfSecondPlayer +
                ", pointsOfFirstPlayer=" + pointsOfFirstPlayer +
                ", pointsOfSecondPlayer=" + pointsOfSecondPlayer +
                '}';
    }

    public void addPoint() {
        pointsOfFirstPlayer++;
    }
}
