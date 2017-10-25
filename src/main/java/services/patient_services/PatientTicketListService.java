package services.patient_services;

import db.dao.*;
import org.apache.log4j.Logger;
import pojo.Ticket;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class PatientTicketListService {
    private static IUserDAO userDAO = new UserDAOImpl();
    private static PatientDAO patientDAO = new PatientDAO();
    private static final Logger logger = Logger.getLogger(PatientTicketListService.class);


    public List<Ticket> getPatientTicketistService(int userId) throws ServletException, IOException {
        List<Ticket> tickets = null;

        try {
            tickets = new TicketDAO().getTicketsById(patientDAO.getPatientID(userId));
        } catch (TicketDAO.TicketDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return tickets;
    }
}
