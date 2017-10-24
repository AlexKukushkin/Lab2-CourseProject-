package services.patient_services;

import db.dao.CalendarDAO;
import pojo.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientGetDoctorScheduleService {
    public void patientGetDoctorSchedule(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Calendar calendar = null;
        req.setCharacterEncoding("UTF-8");

        try {
            calendar = new CalendarDAO().getByFamilyName(req.getParameter("familyName"));
        } catch (CalendarDAO.CalendarDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("item", calendar);
        req.getRequestDispatcher("/patient_doctor_schedule_2.jsp").forward(req, resp);
    }
}
