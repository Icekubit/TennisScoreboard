package services.newScore;

import lombok.Getter;


public class MatchScore extends Score<Integer> {

    @Getter
    private SetScore currentSet;

    public MatchScore() {
        this.currentSet = new SetScore();
    }

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    public State pointWon(int playerNumber) {
        State setState = currentSet.pointWon(playerNumber);

        if (setState == State.PLAYER_ONE_WON) {
            return setWon(playerNumber);
        }
        if (setState == State.PLAYER_TWO_WON) {
            return setWon(playerNumber);
        }

        return State.ONGOING;
    }

    private State setWon(int playerNumber) {
        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);

        if (getPlayerScore(playerNumber) >= 2) {
            if (playerNumber == 0) {
                return State.PLAYER_ONE_WON;
            }
            if (playerNumber == 1) {
                return State.PLAYER_TWO_WON;
            }
        }
        this.currentSet = new SetScore();
        return State.ONGOING;
    }
}
