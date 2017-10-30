package servlets.patient_servlets;

import services.patient_services.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientSaveServlet extends HttpServlet{
    PatientService patientService = new PatientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        int idPatient = Integer.valueOf(req.getParameter("id_patient"));
        String firstName = req.getParameter("first_name");
        String familyName = req.getParameter("family_name");
        String patronymic = req.getParameter("patronymic");
        String birthDate = req.getParameter("birth_date");
        String passport = req.getParameter("passport");
        String SNILS = req.getParameter("SNILS");
        String medPolis = req.getParameter("medpolis");
        String registerLocation = req.getParameter("registration");
        String homeLocation = req.getParameter("home_location");
        String sexType = req.getParameter("sextype");

        patientService.savePatient(idPatient, firstName, familyName, patronymic, birthDate, passport,
                SNILS, medPolis, registerLocation, homeLocation, sexType);
        resp.sendRedirect(String.format("/web/patient_main/patient_data"));
    }
}
