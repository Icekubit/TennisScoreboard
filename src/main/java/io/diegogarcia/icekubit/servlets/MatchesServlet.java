package io.diegogarcia.icekubit.servlets;

import io.diegogarcia.icekubit.services.FinishedMatchesPersistenceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/matches")
public class MatchesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("allMatches", FinishedMatchesPersistenceService.getInstance().findAll());
        request.setAttribute("isThereNextPage", true);
        request.getRequestDispatcher("WEB-INF/jsp/all-matches-view.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("allMatches", FinishedMatchesPersistenceService.getInstance().findAll());
        request.setAttribute("isThereNextPage", false);
        request.getRequestDispatcher("WEB-INF/jsp/all-matches-view.jsp").forward(request, response);
    }
}
