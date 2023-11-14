package servlets;

import models.CurrentMatch;
import services.FinishedMatchesPersistenceService;
import services.MatchScoreCalculationService;
import services.OngoingMatchesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/match-score")
public class MatchScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID matchId = UUID.fromString(request.getParameter("uuid"));
        CurrentMatch match = OngoingMatchesService.getInstance().getMatch(matchId);
        request.setAttribute("match", match);
        request.getRequestDispatcher("WEB-INF/jsp/match-score.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matchId = request.getParameter("uuid");
        int playerId;

        if (request.getParameter("pointHandler").equals("firstPlayer"))
            playerId = 1;
        else
            playerId = 2;
        CurrentMatch match = OngoingMatchesService.getInstance().getMatch(UUID.fromString(matchId));
        MatchScoreCalculationService.getInstance().handlePoint(match, playerId);
        boolean isFinished = MatchScoreCalculationService.getInstance().isFinished(match);
        request.setAttribute("match", match);
        if (!isFinished)
            request.getRequestDispatcher("WEB-INF/jsp/match-score.jsp").forward(request, response);
        else {
            String winner;
            if (playerId == 1)
                winner = match.getFirstPlayerName();
            else
                winner = match.getSecondPlayerName();
            request.setAttribute("winner", winner);
            FinishedMatchesPersistenceService.getInstance().save(match);
            request.getRequestDispatcher("WEB-INF/jsp/match-result.jsp").forward(request, response);
            OngoingMatchesService.getInstance().deleteMatch(UUID.fromString(matchId));
        }
    }
}
