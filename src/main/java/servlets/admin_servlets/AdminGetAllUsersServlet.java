package servlets.admin_servlets;

import services.admin_services.AdminGetAllUsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminGetAllUsersServlet extends HttpServlet {
    private static AdminGetAllUsersService adminGetAllUsersService = new AdminGetAllUsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminGetAllUsersService.doAdminGetAllUsers(req, resp);
    }
}
