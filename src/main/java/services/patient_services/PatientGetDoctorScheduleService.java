package services.patient_services;

import db.dao.CalendarDAO;
import db.dao.DoctorDAO;
import org.apache.log4j.Logger;
import pojo.Calendar;

import javax.servlet.ServletException;
import java.io.IOException;

public class PatientGetDoctorScheduleService {
    private static final Logger logger = Logger.getLogger(PatientGetDoctorScheduleService.class);

    public Calendar patientGetDoctorSchedule(String familyName) throws IOException, ServletException {
        Calendar calendar = null;

        try {
            calendar = new CalendarDAO().getByFamilyName(familyName);
        } catch (CalendarDAO.CalendarDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return calendar;
    }
}
