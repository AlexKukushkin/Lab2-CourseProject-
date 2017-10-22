package servlets.admin_servlets;

import db.dao.MedCenterDAO;
import pojo.MedCenter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetMedcentersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/medcenters.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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