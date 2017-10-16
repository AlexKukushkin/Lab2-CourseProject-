package servlets;

import db.dao.PatientDAO;
import pojo.Patient;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = null;

        try {
            patients = new PatientDAO().getAll();
        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", patients);
        req.getRequestDispatcher("/patient_main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = null;
        try {
            patients = new PatientDAO().getAll();
        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", patients);
        req.getRequestDispatcher("/patient_main.jsp").forward(req, resp);
    }
}
