package servlets.admin_servlets;

import org.apache.log4j.Logger;
import pojo.User;
import services.admin_services.AdminService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminGetAllUsersServlet extends HttpServlet {

    private static AdminService adminService = new AdminService();
    private static final Logger logger = Logger.getLogger(AdminGetAllUsersServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin_user_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users;
        try {
            users = adminService.doAdminGetAllUsers();
            req.setAttribute("list", users);
            req.getRequestDispatcher("/admin_user_list.jsp").forward(req, resp);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
