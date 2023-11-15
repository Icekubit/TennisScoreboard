package services;


public class MatchScoreCalculationService {
    private static MatchScoreCalculationService instance;
    private MatchScoreCalculationService() {}
    public static MatchScoreCalculationService getInstance() {
        if (instance == null)
            instance = new MatchScoreCalculationService();
        return instance;
    }



}
