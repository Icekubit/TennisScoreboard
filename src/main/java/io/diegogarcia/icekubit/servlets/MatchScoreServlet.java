package io.diegogarcia.icekubit.servlets;

import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.services.OngoingMatchesService;
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
//        resp.getWriter().write(matchId + ": " + match);
        String score = match.getScore().toString();
//        request.setAttribute("player1", player1);
//        request.setAttribute("player2", player2);
        request.setAttribute("score", score);
        System.out.println(score);
        request.getRequestDispatcher("WEB-INF/jsp/match-score.jsp").forward(request, response);
    }
}
