package servlets.admin_servlets;

import db.dao.TicketDAO;
import pojo.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetTicketsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ticket_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ticket> tickets = null;

        try {
            tickets = new TicketDAO().getAll();
        } catch (TicketDAO.TicketDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("ticket_list", tickets);
        req.getRequestDispatcher("/ticket_list.jsp").forward(req, resp);
//        ((HttpServletResponse)resp).sendRedirect("/web/ticket_list");
    }
}