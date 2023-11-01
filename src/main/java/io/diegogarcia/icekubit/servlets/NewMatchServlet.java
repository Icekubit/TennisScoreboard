package io.diegogarcia.icekubit.servlets;

import io.diegogarcia.icekubit.models.Player;
import io.diegogarcia.icekubit.services.PlayerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/new-match")
public class NewMatchServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/jsp/new_match.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String NameOfPlayer1 = req.getParameter("player1");
        String NameOfPlayer2 = req.getParameter("player2");
        Player player1 = PlayerService.getInstance().getPlayerByNameOrCreate(NameOfPlayer1);
        Player player2 = PlayerService.getInstance().getPlayerByNameOrCreate(NameOfPlayer2);
        resp.getWriter().write(player1.getName() + player2.getName());
    }
}
