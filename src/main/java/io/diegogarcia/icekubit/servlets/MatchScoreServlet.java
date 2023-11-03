package io.diegogarcia.icekubit.servlets;

import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.models.Score;
import io.diegogarcia.icekubit.services.FinishedMatchesPersistenceService;
import io.diegogarcia.icekubit.services.MatchScoreCalculationService;
import io.diegogarcia.icekubit.services.OngoingMatchesService;
import io.diegogarcia.icekubit.services.PlayerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/match-score")
public class MatchScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID matchId = UUID.fromString(request.getParameter("uuid"));
        Match match = OngoingMatchesService.getInstance().getMatch(matchId);
        Score score = match.getScore();
        request.setAttribute("match", match);
        request.setAttribute("matchId", matchId);
        request.setAttribute("firstPlayer", PlayerService.getInstance().getPlayerById(match.getFirstPlayerId()).getName());
        request.setAttribute("secondPlayer", PlayerService.getInstance().getPlayerById(match.getSecondPlayerId()).getName());
        System.out.println(score);
        request.getRequestDispatcher("WEB-INF/jsp/match-score.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matchId = request.getParameter("uuid");
        int playerId = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("matchId", matchId);
        Match match = OngoingMatchesService.getInstance().getMatch(UUID.fromString(matchId));
        MatchScoreCalculationService.getInstance().handlePoint(match, playerId);
        boolean isFinished = MatchScoreCalculationService.getInstance().isFinished(match);
        request.setAttribute("match", match);
        request.setAttribute("firstPlayer", request.getParameter("firstPlayer"));
        request.setAttribute("secondPlayer", request.getParameter("secondPlayer"));
        if (!isFinished)
            request.getRequestDispatcher("WEB-INF/jsp/match-score.jsp").forward(request, response);
        else {
            String winner;
            if (playerId == match.getFirstPlayerId())
                winner = request.getParameter("firstPlayer");
            else
                winner = request.getParameter("secondPlayer");
            request.setAttribute("winner", winner);
            FinishedMatchesPersistenceService.getInstance().save(match);
            request.getRequestDispatcher("WEB-INF/jsp/match-result.jsp").forward(request, response);
            OngoingMatchesService.getInstance().deleteMatch(UUID.fromString(matchId));
        }
    }
}
