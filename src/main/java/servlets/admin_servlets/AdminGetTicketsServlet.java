package servlets.admin_servlets;

import services.admin_services.AdminGetTicketsService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminGetTicketsServlet extends HttpServlet {
    private static AdminGetTicketsService adminGetTicketsService = new AdminGetTicketsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ticket_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminGetTicketsService.doAdminGetTickets(req, resp);
    }
}