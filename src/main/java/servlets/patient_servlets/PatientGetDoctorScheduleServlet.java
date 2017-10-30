package servlets.patient_servlets;

import pojo.Calendar;
import services.patient_services.PatientService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientGetDoctorScheduleServlet extends HttpServlet {
    private static PatientService patientService = new PatientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/patient_doctor_schedule_2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calendar calendar;
        req.setCharacterEncoding("UTF-8");

        calendar = patientService.patientGetDoctorSchedule(req.getParameter("familyName"));
        req.setAttribute("item", calendar);
        req.getRequestDispatcher("/patient_doctor_schedule_2.jsp").forward(req, resp);
    }
}
