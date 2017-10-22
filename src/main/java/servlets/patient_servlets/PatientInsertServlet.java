package servlets.patient_servlets;

import db.dao.PatientDAO;
import db.dao.UserDAOImpl;
import pojo.Patient;
import pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientInsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PatientDAO patientDAO = new PatientDAO();
        UserDAOImpl userDAO = new UserDAOImpl();

        try {
            patientDAO.insertOne(new Patient(req.getParameter("firstName"),
                    req.getParameter("familyName"), req.getParameter("patronymic"),
                    req.getParameter("birthDate"), req.getParameter("passport"),
                    req.getParameter("SNILS"), req.getParameter("medPolis"),
                    req.getParameter("registerLocation"), req.getParameter("address"), req.getParameter("sexType")));
        } catch (PatientDAO.PatientDAOException e) {
            e.printStackTrace();
        }
        userDAO.createUser(new User(req.getParameter("login"), req.getParameter("password"), "patient"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/patient_main.jsp");
        dispatcher.forward(req, resp);
       // ((HttpServletResponse)resp).sendRedirect("/web/patient_main");
    }
}
