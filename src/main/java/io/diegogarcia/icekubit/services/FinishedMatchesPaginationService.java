package io.diegogarcia.icekubit.services;

import io.diegogarcia.icekubit.dao.MatchesDao;
import io.diegogarcia.icekubit.models.MatchEntity;

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

    public List<MatchEntity> getMatchesForOnePage(int pageNumber) {
        return MatchesDao.getInstance().getMatchesForOnePage(pageNumber, PAGE_SIZE);
    }

    public boolean isThereNextPage(int currentPage) {
        int count = MatchesDao.getInstance().getMatchesCount().intValue();
        return count - currentPage * PAGE_SIZE >= 0;
    }
}
