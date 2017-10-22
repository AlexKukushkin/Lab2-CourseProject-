package servlets.admin_servlets;

import db.dao.UserDAOImpl;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetAllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = null;

        users = new UserDAOImpl().getAllUsers();
        req.setAttribute("list", users);
//        ((HttpServletResponse)resp).sendRedirect("/web/user_list");
        req.getRequestDispatcher("/user_list.jsp").forward(req, resp);
    }
}
