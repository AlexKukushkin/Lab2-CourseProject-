package servlets.patient_servlets;

import pojo.Patient;
import services.patient_services.PatientService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientDataServlet extends HttpServlet {
    PatientService patientService = new PatientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients;

        patients = patientService.getPatients();

        req.setAttribute("list", patients);
        req.getRequestDispatcher("/patient_data.jsp").forward(req, resp);    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients;

        patients = patientService.getPatients();

        req.setAttribute("list", patients);
        req.getRequestDispatcher("/patient_data.jsp").forward(req, resp);
    }
}
