package services.newScore;

public class RegularGameScore extends GameScore<RegularGamePlayerPoints> {

    @Override
    protected RegularGamePlayerPoints getZeroScore() {
        return RegularGamePlayerPoints.ZERO;
    }

    @Override
    State pointWon(int playerNumber) {
        RegularGamePlayerPoints playerScore = getPlayerScore(playerNumber);
        if (playerScore.ordinal() <= RegularGamePlayerPoints.THIRTY.ordinal()) {
            // 0:X, 15:X, 30:X
            setPlayerScore(playerNumber, playerScore.next());
        } else if (playerScore == RegularGamePlayerPoints.FORTY) {
            // 40: X
            RegularGamePlayerPoints oppositePlayerScore = getOppositePlayerScore(playerNumber);

            if (oppositePlayerScore == RegularGamePlayerPoints.ADVANTAGE) {
                // 40 : AD
                setOppositePlayerScore(playerNumber, RegularGamePlayerPoints.FORTY);
            } else if (oppositePlayerScore == RegularGamePlayerPoints.FORTY) {
                // 40 : 40
                setPlayerScore(playerNumber, RegularGamePlayerPoints.ADVANTAGE);
            } else {
                // 40 : 0, 40 : 15, 40 : 30 -> wins the game
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            }
        } else if (playerScore == RegularGamePlayerPoints.ADVANTAGE) {
            // ADV : FORTY -> wins the game
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        } else {
            throw new IllegalStateException("Can't call pointWon on ADVANTAGE");
        }

        return State.ONGOING;
    }
}
