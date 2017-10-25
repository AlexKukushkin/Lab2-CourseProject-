package services.admin_services;

import db.dao.DoctorDAO;
import pojo.Doctor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetAllDoctorsService {
    public List<Doctor> doAdminGetAllDoctorList() throws IOException {
        List<Doctor> doctors = null;

        try {
            doctors = new DoctorDAO().getAll();
        } catch (DoctorDAO.DoctorDAOException e) {
            e.printStackTrace();
        }
        return doctors;

    }
}
