package servlets.patient_servlets.patient_ticket_servlets;

import pojo.Ticket;
import services.patient_services.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TicketServlet extends HttpServlet {
    PatientService patientService = new PatientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ticket_date_time.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Ticket ticket;

        String time = req.getParameter("patientTime");
        String date = req.getParameter("patientDate");
        String day = req.getParameter("patientDay");
        int idPatient = (Integer)req.getSession().getAttribute("patientID");
        int idMedCenter = (Integer)req.getSession().getAttribute("idMedCenter");

        ticket = patientService.getTicket(idPatient, idMedCenter, day, time, date);

        req.setAttribute("ticket", ticket);
        req.getRequestDispatcher("/get_ticket.jsp").forward(req, resp);
    }
}
