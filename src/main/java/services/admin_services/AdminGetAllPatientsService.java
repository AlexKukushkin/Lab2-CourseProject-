package services.admin_services;

import db.dao.PatientDAO;
import pojo.Patient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetAllPatientsService {
    public void doAdminGetAllPatients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = null;
        try {
            patients = new PatientDAO().getAll();
        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", patients);
        req.getRequestDispatcher("/patient_list.jsp").forward(req, resp);
    }
}
