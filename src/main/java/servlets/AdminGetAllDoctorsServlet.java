package servlets;

import db.dao.DoctorDAO;
import db.dao.UserDAOImpl;
import pojo.Doctor;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetAllDoctorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/doctor_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Doctor> doctors = null;

        try {
            doctors = new DoctorDAO().getAll();
        } catch (DoctorDAO.DoctorDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", doctors);
        ((HttpServletResponse)resp).sendRedirect("/web/doctor_list");
//        req.getRequestDispatcher("/doctor_list.jsp").forward(req, resp);
    }
}
