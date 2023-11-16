package servlets;

import models.CurrentMatch;
import services.FinishedMatchesPersistenceService;
import services.OngoingMatchesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.newScore.State;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/match-score")
public class MatchScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID matchId = UUID.fromString(request.getParameter("uuid"));
        request.setAttribute("match", OngoingMatchesService.getInstance().getCurrentMatchScoreDto(matchId));
        request.getRequestDispatcher("view/match-score.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID matchId = UUID.fromString(request.getParameter("uuid"));


        int playerNumber = Integer.parseInt(request.getParameter("pointHandler"));
        CurrentMatch match = OngoingMatchesService.getInstance().getMatch(matchId);
        State matchState = match.getMatchScore().pointWon(playerNumber);
        request.setAttribute("match", OngoingMatchesService.getInstance().getCurrentMatchScoreDto(matchId));

        if (matchState == State.ONGOING) {
            request.getRequestDispatcher("view/match-score.jsp").forward(request, response);
        }
        else {
            String winner;
            if (playerNumber == 0)
                winner = match.getFirstPlayerName();
            else
                winner = match.getSecondPlayerName();
            request.setAttribute("winner", winner);
            FinishedMatchesPersistenceService.getInstance().save(match);
            request.getRequestDispatcher("view/match-result.jsp").forward(request, response);
            OngoingMatchesService.getInstance().deleteMatch(matchId);
        }
    }
}
