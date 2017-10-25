package services.admin_services;

import db.dao.TicketDAO;
import org.apache.log4j.Logger;
import pojo.Ticket;
import java.io.IOException;
import java.util.List;

public class AdminGetTicketsService {
    private static final Logger logger = Logger.getLogger(AdminGetTicketsService.class);


    public List<Ticket> doAdminGetTickets() throws IOException {
        List<Ticket> tickets = null;

        try {
            tickets = new TicketDAO().getAll();
        } catch (TicketDAO.TicketDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return tickets;
    }
}
