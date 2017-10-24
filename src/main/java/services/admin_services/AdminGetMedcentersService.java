package services.admin_services;

import db.dao.MedCenterDAO;
import pojo.MedCenter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetMedcentersService {
    public void doAdminGetMedcenters(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MedCenter> medCenters = null;

        try {
            medCenters = new MedCenterDAO().getAll();
        } catch (MedCenterDAO.MedCenterDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", medCenters);
        req.getRequestDispatcher("/medcenters.jsp").forward(req, resp);
        //((HttpServletResponse)resp).sendRedirect("/web/medcenters");
    }
}
