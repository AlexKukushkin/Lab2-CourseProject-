package servlets;

import db.dao.PatientDAO;
import db.dao.UserDAOImpl;
import dto.UserDTO;
import pojo.Patient;
import services.RegistrationService;
import services.RegistrationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private static RegistrationService registrationService = new RegistrationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("POST");
        UserDAOImpl userDAO = new UserDAOImpl();

        String login = req.getParameter("inputLogin");
        String password = req.getParameter("inputPassword");

        UserDTO userDTO = new UserDTO(req.getParameter("firstName"),
                        req.getParameter("familyName"), req.getParameter("patronymic"),
                        req.getParameter("birthDate"), req.getParameter("passport"),
                        req.getParameter("SNILS"), req.getParameter("medPolis"),
                        req.getParameter("registerLocation"), req.getParameter("address"),
                        req.getParameter("sexType"));


        if (registrationService.regUser(login, password)) {
            registrationService.insertUser(login, password, userDTO);
           // req.getSession().setAttribute("isSignUp", true);
            req.getSession().setAttribute("isAuth", true);
//            req.getRequestDispatcher("/patient_main.jsp").forward(req, resp);
            ((HttpServletResponse)resp).sendRedirect("/web/patient_main");
        } else {
            getServletContext().getRequestDispatcher("/").forward(req, resp);
        }
    }
}