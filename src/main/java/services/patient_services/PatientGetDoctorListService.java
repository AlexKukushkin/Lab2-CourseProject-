package services.patient_services;

import db.dao.DoctorDAO;
import pojo.Doctor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientGetDoctorListService {
    public void patientGetDoctorList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Doctor> doctors = null;

        try {
            doctors = new DoctorDAO().getAll();
        } catch (DoctorDAO.DoctorDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", doctors);
        req.getRequestDispatcher("/patient_doctor_list.jsp").forward(req, resp);
    }
}
