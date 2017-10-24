package servlets.patient_servlets;

import services.patient_services.PatientGetDoctorListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientGetDoctorListServlet extends HttpServlet {
    private static PatientGetDoctorListService patientGetDoctorListService = new PatientGetDoctorListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/patient_doctor_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        patientGetDoctorListService.patientGetDoctorList(req, resp);
    }
}

