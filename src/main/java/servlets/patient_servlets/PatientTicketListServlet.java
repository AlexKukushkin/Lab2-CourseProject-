package servlets.patient_servlets;

import pojo.Ticket;
import services.patient_services.PatientTicketListService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientTicketListServlet extends HttpServlet {
    private static PatientTicketListService patientTicketListService = new PatientTicketListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ticket> tickets = getTickets(req);

        req.setAttribute("ticket_list", tickets);
        req.getRequestDispatcher("/patient_ticket.jsp").forward(req, resp);
    }

    protected List<Ticket> getTickets(HttpServletRequest req) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Ticket> tickets;
        int userId;

        userId = (Integer)req.getSession().getAttribute("userID");
        tickets = patientTicketListService.getPatientTicketistService(userId);
        return tickets;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ticket> tickets = getTickets(req);

        req.setAttribute("ticket_list", tickets);
        req.getRequestDispatcher("/patient_ticket.jsp").forward(req, resp);
    }
}
