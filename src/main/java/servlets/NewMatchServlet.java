package servlets;

import services.OngoingMatchesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/new-match")
public class NewMatchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("view/new-match.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nameOfPlayer1 = request.getParameter("player1");
        String nameOfPlayer2 = request.getParameter("player2");
        if (nameOfPlayer1.equals(nameOfPlayer2)) {
            request.setAttribute("isTheSameNames", true);
            request.getRequestDispatcher("view/new-match.jsp").forward(request, response);
        } else {
            UUID matchId = OngoingMatchesService.getInstance().CreateCurrentMatch(nameOfPlayer1, nameOfPlayer2);
            String redirectUrl = request.getContextPath() + "/match-score?uuid=" + matchId;
            response.sendRedirect(redirectUrl);
        }
    }
}
