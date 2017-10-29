package services.admin_services;

import db.dao.PatientDAO;
import org.apache.log4j.Logger;
import pojo.Patient;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class AdminGetAllPatientsService {
    private static final Logger logger = Logger.getLogger(AdminGetAllPatientsService.class);

    public List<Patient> doAdminGetAllPatients() throws ServletException, IOException {
        List<Patient> patients = null;
        try {
            patients = new PatientDAO().getAll();
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return patients;
    }
}
