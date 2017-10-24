package servlets.patient_servlets;

import services.patient_services.PatientTicketListService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientTicketListServlet extends HttpServlet {
    private static PatientTicketListService patientTicketListService = new PatientTicketListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/patient_ticket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        patientTicketListService.getPatientTicketistService(req, resp);
    }
}
