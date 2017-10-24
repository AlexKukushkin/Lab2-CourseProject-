package servlets.admin_servlets;


import services.admin_services.AdminGetAllDoctorsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminGetAllDoctorsServlet extends HttpServlet {
    private static AdminGetAllDoctorsService adminGetAllDoctorsService = new AdminGetAllDoctorsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/doctor_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminGetAllDoctorsService.doAdminGetAllDoctorList(req, resp);
    }
}
