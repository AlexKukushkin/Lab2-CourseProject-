package servlets.admin_servlets;

import pojo.Ticket;
import services.admin_services.AdminService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetTicketsServlet extends HttpServlet {
    private static AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fillCommon(req);
        req.getRequestDispatcher("/admin_ticket_list.jsp").forward(req, resp);
    }

    protected void fillCommon(HttpServletRequest req) throws IOException {
        List<Ticket> tickets;

        tickets = adminService.doAdminGetTickets();
        req.setAttribute("ticket_list", tickets);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fillCommon(req);
        resp.sendRedirect("/web/admin_main/admin_ticket_list");
    }
}