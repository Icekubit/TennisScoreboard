package io.diegogarcia.icekubit.models;

public class Match {
    private int firstPlayerId;
    private int secondPlayerId;
    private Score score;

    public Match(int firstPlayerId, int secondPlayerId) {
        this.firstPlayerId = firstPlayerId;
        this.secondPlayerId = secondPlayerId;
        score = new Score();
    }

    public int getFirstPlayerId() {
        return firstPlayerId;
    }

    public void setFirstPlayerId(int firstPlayerId) {
        this.firstPlayerId = firstPlayerId;
    }

    public int getSecondPlayerId() {
        return secondPlayerId;
    }

    public void setSecondPlayerId(int secondPlayerId) {
        this.secondPlayerId = secondPlayerId;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
