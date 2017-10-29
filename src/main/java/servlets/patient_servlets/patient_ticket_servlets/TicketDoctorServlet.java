package servlets.patient_servlets.patient_ticket_servlets;

import db.dao.DoctorDAO;
import dto.DoctorDTO;
import services.patient_services.PatientMedCenterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TicketDoctorServlet extends HttpServlet {
    private static PatientMedCenterService patientMedCenterService = new PatientMedCenterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ticket_doctor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        DoctorDAO doctorDAO = new DoctorDAO();

        int idMedCenter = (Integer)req.getSession().getAttribute("idMedCenter");
        String specialization = req.getParameter("specialization");

        try {
            List<DoctorDTO> doctors = doctorDAO.getDoctor(idMedCenter, specialization);
            req.setAttribute("doctors", doctors);
        } catch (DoctorDAO.DoctorDAOException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/ticket_doctor.jsp").forward(req, resp);
    }
}
