package servlets.patient_servlets;

import db.dao.PatientDAO;
import pojo.Patient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientSaveServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PatientDAO patientDAO = new PatientDAO();
        try {
            patientDAO.update(new Patient(Integer.valueOf(req.getParameter("id_patient")), req.getParameter("first_name"),
                    req.getParameter("family_name"), req.getParameter("patronymic"),
                    req.getParameter("birth_date"), req.getParameter("passport"),
                    req.getParameter("SNILS"), req.getParameter("medpolis"), req.getParameter("registration"),
                    req.getParameter("home_location"), req.getParameter("sextype")));
        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("/web/patient_data"));
    }
}
