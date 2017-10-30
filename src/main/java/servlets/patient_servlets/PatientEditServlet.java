package servlets.patient_servlets;

import db.dao.PatientDAO;
import org.apache.log4j.Logger;
import pojo.Patient;
import services.patient_services.PatientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class PatientEditServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(PatientService.class);
    PatientService patientService = new PatientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId;
        int patientId = 0;
        Patient patient;

        userId = (Integer)req.getSession().getAttribute("userID");

        try {
            patientId = patientService.getPatientId(userId);

            HttpSession session = req.getSession();
            session.setAttribute("patientID", patientId);
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }

        patient = patientService.getPatientByID(patientId);

        req.setAttribute("patient", patient);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/patient_edit.jsp");
        dispatcher.forward(req, resp);
    }
}

