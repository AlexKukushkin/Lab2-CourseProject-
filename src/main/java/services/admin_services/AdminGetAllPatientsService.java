package services.admin_services;

import db.dao.PatientDAO;
import pojo.Patient;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class AdminGetAllPatientsService {
    public List<Patient> doAdminGetAllPatients() throws ServletException, IOException {
        List<Patient> patients = null;
        try {
            patients = new PatientDAO().getAll();
        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
