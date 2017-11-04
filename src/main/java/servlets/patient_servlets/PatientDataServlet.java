package servlets.patient_servlets;

import org.springframework.beans.factory.annotation.Autowired;
import pojo.Patient;
import services.patient_services.PatientService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientDataServlet extends HttpServlet {

    private static PatientService patientService = new PatientService();

//PatientService patientService;// = new PatientService();
//
//    @Autowired
//    public PatientDataServlet(PatientService patientService) {
//        this.patientService = patientService;
//    }

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
