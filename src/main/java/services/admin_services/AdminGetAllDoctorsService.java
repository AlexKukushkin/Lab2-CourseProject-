package services.admin_services;

import db.dao.DoctorDAO;
import org.apache.log4j.Logger;
import pojo.Doctor;
import java.io.IOException;
import java.util.List;

public class AdminGetAllDoctorsService {
    private static final Logger logger = Logger.getLogger(AdminGetAllDoctorsService.class);

    public List<Doctor> doAdminGetAllDoctorList() throws IOException {
        List<Doctor> doctors = null;

        try {
            doctors = new DoctorDAO().getAll();
        } catch (DoctorDAO.DoctorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return doctors;
    }
}
