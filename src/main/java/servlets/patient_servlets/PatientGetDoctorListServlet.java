package servlets.patient_servlets;

import pojo.Doctor;
import services.patient_services.PatientService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientGetDoctorListServlet extends HttpServlet {
    private static PatientService patientService = new PatientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Doctor> doctors;

        doctors = patientService.patientGetDoctorList();
        req.setAttribute("list", doctors);
        req.getRequestDispatcher("/patient_doctor_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Doctor> doctors;

        doctors = patientService.patientGetDoctorList();
        req.setAttribute("list", doctors);
        req.getRequestDispatcher("/patient_doctor_list.jsp").forward(req, resp);
    }
}

