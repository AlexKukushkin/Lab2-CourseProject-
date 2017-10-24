package services.admin_services;

import db.dao.UserDAOImpl;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetAllUsersService {
    public void doAdminGetAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = null;

        users = new UserDAOImpl().getAllUsers();
        req.setAttribute("list", users);
        req.getRequestDispatcher("/user_list.jsp").forward(req, resp);
    }
}
