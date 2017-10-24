package services.admin_services;

import db.dao.TicketDAO;
import pojo.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetTicketsService {

    public void doAdminGetTickets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ticket> tickets = null;

        try {
            tickets = new TicketDAO().getAll();
        } catch (TicketDAO.TicketDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("ticket_list", tickets);
        req.getRequestDispatcher("/ticket_list.jsp").forward(req, resp);
    }
}
