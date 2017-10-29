package servlets.patient_servlets.patient_ticket_servlets;

import db.dao.DoctorDAO;
import services.patient_services.PatientMedCenterService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TicketSpecializationServlet extends HttpServlet {
    private static PatientMedCenterService patientMedCenterService = new PatientMedCenterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Ticket> tickets;
//        List<Doctor> doctors;
//        List<String> specializations;
//
//        TicketDAO ticketDAO = new TicketDAO();
//        DoctorDAO doctorDAO = new DoctorDAO();
//
//        int idMedCenter = Integer.parseInt(req.getParameter("idMedCenter"));
//
//        try {
//            ticketDAO.insertMedCenterID(idMedCenter);
//            specializations = doctorDAO.getDoctorSpecialization(idMedCenter);
//            req.setAttribute("specializations", specializations);
//        } catch (TicketDAO.TicketDAOException e) {
//            e.printStackTrace();
//        } catch (DoctorDAO.DoctorDAOException e) {
//            e.printStackTrace();
//        }
        req.getRequestDispatcher("/ticket_specialization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<String> specializations;
        DoctorDAO doctorDAO = new DoctorDAO();

        int idMedCenter = Integer.parseInt(req.getParameter("idMedCenter"));
        HttpSession session = req.getSession(true);
        session.setAttribute("idMedCenter", idMedCenter);

        try {
            //ticketDAO.insertMedCenterID(idMedCenter);
            specializations = doctorDAO.getDoctorSpecialization(idMedCenter);
            req.setAttribute("specializations", specializations);
        } catch (DoctorDAO.DoctorDAOException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/ticket_specialization.jsp").forward(req, resp);
    }
}
