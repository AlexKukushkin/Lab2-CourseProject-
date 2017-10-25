package services.patient_services;

import db.dao.DoctorDAO;
import org.apache.log4j.Logger;
import pojo.Doctor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientGetDoctorListService {
    private static final Logger logger = Logger.getLogger(PatientGetDoctorListService.class);

    public List<Doctor> patientGetDoctorList() throws IOException {
        List<Doctor> doctors = null;

        try {
            doctors = new DoctorDAO().getAll();
        } catch (DoctorDAO.DoctorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return doctors;
    }
}
