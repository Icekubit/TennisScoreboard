package io.diegogarcia.icekubit.models;

public class Score {
    private int winningSetsOfFirstPlayer;
    private int winningSetsOfSecondPlayer;
    private int winningGamesOfFirstPlayer;
    private int winningGamesOfSecondPlayer;
    private String pointsOfFirstPlayer;
    private String pointsOfSecondPlayer;
    private boolean isTieBreak;

    public Score() {
        pointsOfFirstPlayer = "0";
        pointsOfSecondPlayer = "0";
    }

    public int getWinningSetsOfFirstPlayer() {
        return winningSetsOfFirstPlayer;
    }

    public void setWinningSetsOfFirstPlayer(int winningSetsOfFirstPlayer) {
        this.winningSetsOfFirstPlayer = winningSetsOfFirstPlayer;
    }

    public int getWinningSetsOfSecondPlayer() {
        return winningSetsOfSecondPlayer;
    }

    public void setWinningSetsOfSecondPlayer(int winningSetsOfSecondPlayer) {
        this.winningSetsOfSecondPlayer = winningSetsOfSecondPlayer;
    }

    public int getWinningGamesOfFirstPlayer() {
        return winningGamesOfFirstPlayer;
    }

    public void setWinningGamesOfFirstPlayer(int winningGamesOfFirstPlayer) {
        this.winningGamesOfFirstPlayer = winningGamesOfFirstPlayer;
    }

    public int getWinningGamesOfSecondPlayer() {
        return winningGamesOfSecondPlayer;
    }

    public void setWinningGamesOfSecondPlayer(int winningGamesOfSecondPlayer) {
        this.winningGamesOfSecondPlayer = winningGamesOfSecondPlayer;
    }

    public String getPointsOfFirstPlayer() {
        return pointsOfFirstPlayer;
    }

    public void setPointsOfFirstPlayer(String pointsOfFirstPlayer) {
        this.pointsOfFirstPlayer = pointsOfFirstPlayer;
    }

    public String getPointsOfSecondPlayer() {
        return pointsOfSecondPlayer;
    }

    public void setPointsOfSecondPlayer(String pointsOfSecondPlayer) {
        this.pointsOfSecondPlayer = pointsOfSecondPlayer;
    }

    public boolean isTieBreak() {
        return isTieBreak;
    }

    public void setTieBreak(boolean tieBreak) {
        isTieBreak = tieBreak;
    }


    @Override
    public String toString() {
        return "Score{" +
                "winningSetsOfFirstPlayer=" + winningSetsOfFirstPlayer +
                ", winningSetsOfSecondPlayer=" + winningSetsOfSecondPlayer +
                ", winningGamesOfFirstPlayer=" + winningGamesOfFirstPlayer +
                ", winningGamesOfSecondPlayer=" + winningGamesOfSecondPlayer +
                ", pointsOfFirstPlayer='" + pointsOfFirstPlayer + '\'' +
                ", pointsOfSecondPlayer='" + pointsOfSecondPlayer + '\'' +
                ", isTieBreak=" + isTieBreak +
                '}';
    }

//    public void addFirstPlayerPoints() {
//        if (!isTieBreak) {
//            switch (pointsOfFirstPlayer) {
//                case "0":
//                    pointsOfFirstPlayer = "15";
//                    break;
//                case "15":
//                    pointsOfFirstPlayer = "30";
//                    break;
//                case "30":
//                    pointsOfFirstPlayer = "40";
//                    break;
//                case "40":
//                    if (!pointsOfSecondPlayer.equals("40") && !pointsOfSecondPlayer.equals("A")) {
//                        pointsOfFirstPlayer = "0";
//                        pointsOfSecondPlayer = "0";
//                        addWinningGamesOfFirstPlayer();
//                    } else if (pointsOfSecondPlayer.equals("40")) {
//                        pointsOfFirstPlayer = "A";
//                    } else if (pointsOfSecondPlayer.equals("A")) {
//                        pointsOfSecondPlayer = "40";
//                    }
//                    break;
//                case "A":
//                    pointsOfFirstPlayer = "0";
//                    pointsOfSecondPlayer = "0";
//                    addWinningGamesOfFirstPlayer();
//                    break;
//            }
//        } else
//            addFirstPlayerTieBreakPoints();
//    }
//
//    public void addSecondPlayerPoints() {
//        if (!isTieBreak) {
//            switch (pointsOfSecondPlayer) {
//                case "0":
//                    pointsOfSecondPlayer = "15";
//                    break;
//                case "15":
//                    pointsOfSecondPlayer = "30";
//                    break;
//                case "30":
//                    pointsOfSecondPlayer = "40";
//                    break;
//                case "40":
//                    if (!pointsOfFirstPlayer.equals("40") && !pointsOfFirstPlayer.equals("A")) {
//                        pointsOfFirstPlayer = "0";
//                        pointsOfSecondPlayer = "0";
//                        addWinningGamesOfSecondPlayer();
//                    } else if (pointsOfFirstPlayer.equals("40")) {
//                        pointsOfSecondPlayer = "A";
//                    } else if (pointsOfFirstPlayer.equals("A")) {
//                        pointsOfFirstPlayer = "40";
//                    }
//                    break;
//                case "A":
//                    pointsOfFirstPlayer = "0";
//                    pointsOfSecondPlayer = "0";
//                    addWinningGamesOfSecondPlayer();
//                    break;
//            }
//        } else
//            addSecondPlayerTieBreakPoints();
//    }
//
//    private void addWinningGamesOfFirstPlayer() {
//        if (winningGamesOfFirstPlayer <= 4) {
//            winningGamesOfFirstPlayer++;
//        } else if (winningGamesOfFirstPlayer == 5 && winningGamesOfSecondPlayer <= 4) {
//            addWinningSetsOfFirstPlayer();
//            winningGamesOfFirstPlayer = 0;
//            winningGamesOfSecondPlayer = 0;
//        } else if (winningGamesOfFirstPlayer == 5 && winningGamesOfSecondPlayer == 5) {
//            winningGamesOfFirstPlayer++;
//        } else if (winningGamesOfFirstPlayer == 6 && winningGamesOfSecondPlayer == 5) {
//            addWinningSetsOfFirstPlayer();
//            winningGamesOfFirstPlayer = 0;
//            winningGamesOfSecondPlayer = 0;
//        } else if (winningGamesOfFirstPlayer == 5 && winningGamesOfSecondPlayer == 6) {
//            winningGamesOfFirstPlayer++;
//            isTieBreak = true;
//            pointsOfFirstPlayer = "0";
//            pointsOfSecondPlayer = "0";
//        }
//    }
//
//    private void addWinningGamesOfSecondPlayer() {
//        if (winningGamesOfSecondPlayer <= 4) {
//            winningGamesOfSecondPlayer++;
//        } else if (winningGamesOfSecondPlayer == 5 && winningGamesOfFirstPlayer <= 4) {
//            addWinningSetsOfSecondPlayer();
//            winningGamesOfFirstPlayer = 0;
//            winningGamesOfSecondPlayer = 0;
//        } else if (winningGamesOfSecondPlayer == 5 && winningGamesOfFirstPlayer == 5) {
//            winningGamesOfSecondPlayer++;
//        } else if (winningGamesOfSecondPlayer == 6 && winningGamesOfFirstPlayer == 5) {
//            addWinningSetsOfSecondPlayer();
//            winningGamesOfFirstPlayer = 0;
//            winningGamesOfSecondPlayer = 0;
//        } else if (winningGamesOfSecondPlayer == 5 && winningGamesOfFirstPlayer == 6) {
//            winningGamesOfSecondPlayer++;
//            isTieBreak = true;
//            pointsOfFirstPlayer = "0";
//            pointsOfSecondPlayer = "0";
//        }
//    }
//
//    private void addFirstPlayerTieBreakPoints() {
//        int firstPlayerTieBreakPoints = Integer.valueOf(pointsOfFirstPlayer);
//        int secondPlayerTieBreakPoints = Integer.valueOf(pointsOfSecondPlayer);
//        if (firstPlayerTieBreakPoints < 6
//                || firstPlayerTieBreakPoints >= 6 && (firstPlayerTieBreakPoints == secondPlayerTieBreakPoints)
//                || firstPlayerTieBreakPoints >= 6 && (secondPlayerTieBreakPoints - firstPlayerTieBreakPoints == 1)
//        ) {
//            firstPlayerTieBreakPoints++;
//            pointsOfFirstPlayer = Integer.toString(firstPlayerTieBreakPoints);
//        } else if (firstPlayerTieBreakPoints >= 6 && (firstPlayerTieBreakPoints - secondPlayerTieBreakPoints) >= 1) {
//            addWinningSetsOfFirstPlayer();
//            winningGamesOfFirstPlayer = 0;
//            winningGamesOfSecondPlayer = 0;
//            pointsOfFirstPlayer = "0";
//            pointsOfSecondPlayer = "0";
//            isTieBreak = false;
//        }
//    }
//
//    private void addSecondPlayerTieBreakPoints() {
//        int firstPlayerTieBreakPoints = Integer.valueOf(pointsOfFirstPlayer);
//        int secondPlayerTieBreakPoints = Integer.valueOf(pointsOfSecondPlayer);
//        if (secondPlayerTieBreakPoints < 6
//                || secondPlayerTieBreakPoints >= 6 && (secondPlayerTieBreakPoints == firstPlayerTieBreakPoints)
//                || secondPlayerTieBreakPoints >= 6 && (firstPlayerTieBreakPoints - secondPlayerTieBreakPoints == 1)
//        ) {
//            secondPlayerTieBreakPoints++;
//            pointsOfSecondPlayer = Integer.toString(secondPlayerTieBreakPoints);
//        } else if (secondPlayerTieBreakPoints >= 6 && (secondPlayerTieBreakPoints - firstPlayerTieBreakPoints) >= 1) {
//            addWinningSetsOfSecondPlayer();
//            winningGamesOfFirstPlayer = 0;
//            winningGamesOfSecondPlayer = 0;
//            pointsOfFirstPlayer = "0";
//            pointsOfSecondPlayer = "0";
//            isTieBreak = false;
//        }
//    }


}
