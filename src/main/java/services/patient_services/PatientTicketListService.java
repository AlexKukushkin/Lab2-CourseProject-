package services.patient_services;

import db.dao.IUserDAO;
import db.dao.PatientDAO;
import db.dao.TicketDAO;
import db.dao.UserDAOImpl;
import pojo.Ticket;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientTicketListService {
    private static IUserDAO userDAO = new UserDAOImpl();
    private static PatientDAO patientDAO = new PatientDAO();

    public void getPatientTicketistService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Ticket> tickets = null;
        int userId = 0;

        try {
            userId = (Integer)req.getSession().getAttribute("userID");
            tickets = new TicketDAO().getTicketsById(patientDAO.getPatientID(userId));
        } catch (TicketDAO.TicketDAOException e) {
            e.printStackTrace();
        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        }

        req.setAttribute("ticket_list", tickets);
        req.getRequestDispatcher("/patient_ticket.jsp").forward(req, resp);
    }
}
