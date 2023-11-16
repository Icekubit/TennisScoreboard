package servlets;

import services.FinishedMatchesPaginationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/matches")
public class MatchesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("filter_by_player_name");
        String StringCurrentPage = request.getParameter("page");
        int currentPage;
        if (StringCurrentPage == null)
            currentPage = 1;
        else
            currentPage = Integer.valueOf(StringCurrentPage);
        request.setAttribute("allMatches", FinishedMatchesPaginationService.getInstance().getMatchesForOnePage(currentPage, searchName));
        request.setAttribute("isTherePreviousPage", currentPage - 1 > 0);
        request.setAttribute("isThereNextPage", FinishedMatchesPaginationService.getInstance().isThereNextPage(currentPage, searchName));
        request.setAttribute("nextPage", currentPage + 1);
        request.setAttribute("previousPage", currentPage - 1);
        request.getRequestDispatcher("view/all-matches-view.jsp").forward(request, response);
    }
}
