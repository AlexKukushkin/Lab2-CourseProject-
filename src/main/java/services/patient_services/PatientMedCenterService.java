package services.patient_services;

import db.dao.DoctorDAO;
import db.dao.MedCenterDAO;
import org.apache.log4j.Logger;
import pojo.MedCenter;
import java.io.IOException;
import java.util.List;

public class PatientMedCenterService {
    private static final Logger logger = Logger.getLogger(DoctorDAO.class);

    public List<MedCenter> getPatientMedCenter() throws IOException {
        List<MedCenter> medcenters = null;

        try {
            medcenters = new MedCenterDAO().getAll();
        } catch (MedCenterDAO.MedCenterDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return medcenters;
    }
}
