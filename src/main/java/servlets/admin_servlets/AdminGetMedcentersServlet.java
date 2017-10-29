package servlets.admin_servlets;

import pojo.MedCenter;
import services.admin_services.AdminGetMedcentersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetMedcentersServlet extends HttpServlet {
    private static AdminGetMedcentersService adminGetMedcentersService = new AdminGetMedcentersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin_medcenters.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MedCenter> medCenters;

        medCenters = adminGetMedcentersService.doAdminGetMedcenters();
        req.setAttribute("list", medCenters);
        req.getRequestDispatcher("/admin_medcenters.jsp").forward(req, resp);
    }
}