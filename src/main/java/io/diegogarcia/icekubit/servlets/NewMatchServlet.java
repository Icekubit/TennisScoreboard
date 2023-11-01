package io.diegogarcia.icekubit.servlets;

import io.diegogarcia.icekubit.models.Match;
import io.diegogarcia.icekubit.models.Player;
import io.diegogarcia.icekubit.services.OngoingMatchesService;
import io.diegogarcia.icekubit.services.PlayerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(value = "/new-match")
public class NewMatchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/jsp/new_match.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameOfPlayer1 = req.getParameter("player1");
        String nameOfPlayer2 = req.getParameter("player2");

        UUID matchId = OngoingMatchesService.getInstance().addMatch(nameOfPlayer1, nameOfPlayer2);

        String redirectUrl = "/match-score?uuid=" + matchId;

        resp.sendRedirect(redirectUrl);
    }
}
