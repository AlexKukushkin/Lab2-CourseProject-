package servlets.patient_servlets.patient_ticket_servlets;

import dto.DoctorDTO;
import org.apache.log4j.Logger;
import services.patient_services.PatientService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TicketDoctorServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(TicketDoctorServlet.class);
    PatientService patientService = new PatientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ticket_doctor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<DoctorDTO> doctors;
        int idMedCenter = (Integer)req.getSession().getAttribute("idMedCenter");
        String specialization = req.getParameter("specialization");
        HttpSession session = req.getSession(false);
        session.setAttribute("specialization", specialization);

        doctors = patientService.getDoctorsForTicket(idMedCenter, specialization);

        req.setAttribute("doctors", doctors);
        req.getRequestDispatcher("/ticket_doctor.jsp").forward(req, resp);
    }
}
