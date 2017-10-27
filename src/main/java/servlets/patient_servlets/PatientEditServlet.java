package servlets.patient_servlets;

import db.dao.PatientDAO;
import pojo.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PatientEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PatientDAO patientDAO = new PatientDAO();
        int userId;
        int patientId;
        Patient patient;

        try {
            userId = (Integer)req.getSession().getAttribute("userID");
            patientId = patientDAO.getPatientID(Integer.valueOf(userId));
            patient = patientDAO.getByID(patientId);
            req.setAttribute("patient", patient);
        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/patient_edit.jsp");
        dispatcher.forward(req, resp);
    }
}

