package servlets.patient_servlets;

import pojo.MedCenter;
import services.patient_services.PatientMedCenterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class PatientGetTicketServlet extends HttpServlet {
    private static PatientMedCenterService patientMedCenterService = new PatientMedCenterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MedCenter> medcenters;

        medcenters = patientMedCenterService.getPatientMedCenter();
        req.setAttribute("list", medcenters);
        req.getRequestDispatcher("/patient_new_ticket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MedCenter> medcenters;

        medcenters = patientMedCenterService.getPatientMedCenter();
        req.setAttribute("list", medcenters);
        req.getRequestDispatcher("/patient_new_ticket.jsp").forward(req, resp);
    }
}
