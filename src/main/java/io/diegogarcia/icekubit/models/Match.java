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

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Match{" +
                "firstPlayerId=" + firstPlayerId +
                ", secondPlayerId=" + secondPlayerId +
                ", score=" + score +
                '}';
    }
}
