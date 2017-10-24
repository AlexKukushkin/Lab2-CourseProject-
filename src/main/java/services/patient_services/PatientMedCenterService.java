package services.patient_services;

import db.dao.MedCenterDAO;
import pojo.MedCenter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PatientMedCenterService {
    public void getPatientMedCenter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MedCenter> medcenters = null;

        try {
            medcenters = new MedCenterDAO().getAll();
        } catch (MedCenterDAO.MedCenterDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", medcenters);
        req.getRequestDispatcher("/patient_medcenter.jsp").forward(req, resp);
    }
}
