package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.dao.MatchesDao;
import io.diegogarcia.icekubit.models.Match;

import java.util.List;

public class FinishedMatchesPaginationService {
    private static final int PAGE_SIZE = 5;
    private static FinishedMatchesPaginationService instance;
    private FinishedMatchesPaginationService() {}
    public static FinishedMatchesPaginationService getInstance() {
        if (instance == null)
            instance = new FinishedMatchesPaginationService();
        return instance;
    }

    public List<Match> getMatchesForOnePage(int pageNumber, String searchName) {
        if (searchName == null)
            return MatchesDao.getInstance().getMatchesForOnePage(pageNumber, PAGE_SIZE);
        else
            return MatchesDao.getInstance().getMatchesForOnePageWithNameFilter(pageNumber, PAGE_SIZE, searchName);
    }

    public boolean isThereNextPage(int currentPage, String searchName) {
        int count;
        if (searchName == null)
            count = MatchesDao.getInstance().getAllMatchesCount().intValue();
        else
            count = MatchesDao.getInstance().getMatchesCountForPlayer(searchName).intValue();
        System.out.println(count);
        return count - currentPage * PAGE_SIZE > 0;
    }
}
