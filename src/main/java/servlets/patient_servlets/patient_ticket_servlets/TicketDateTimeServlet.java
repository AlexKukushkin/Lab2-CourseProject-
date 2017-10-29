package servlets.patient_servlets.patient_ticket_servlets;

import db.dao.DoctorDAO;
import db.dao.TicketDAO;
import pojo.Ticket;
import services.patient_services.PatientMedCenterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TicketDateTimeServlet extends HttpServlet {
    private static PatientMedCenterService patientMedCenterService = new PatientMedCenterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ticket_date_time.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        TicketDAO ticketDAO = new TicketDAO();
//        DoctorDAO doctorDAO = new DoctorDAO();
//        Ticket ticket;
//
//        try {
//            String time = (String) req.getSession().getAttribute("patientTime");
//            String date = (String) req.getSession().getAttribute("patientDate");
//            String day = (String) req.getSession().getAttribute("patientDay");
//            int idPatient = (Integer) req.getSession().getAttribute("patientID");
//            int idMedCenter = (Integer) req.getSession().getAttribute("idMedCenter");
//            int idDoctor = doctorDAO.getDoctorID(idMedCenter);
//
//            ticket = ticketDAO.insertOne(new Ticket(idPatient, idDoctor, idMedCenter, day, time, date);
//            req.setAttribute("ticket", ticket);
//        } catch (DoctorDAO.DoctorDAOException e) {
//            e.printStackTrace();
//        }
        req.getRequestDispatcher("/ticket_date_time.jsp").forward(req, resp);
    }
}
