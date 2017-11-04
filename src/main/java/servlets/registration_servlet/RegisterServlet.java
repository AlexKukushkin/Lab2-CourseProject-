package servlets.registration_servlet;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import services.login_services.LoginService;
import services.registration_services.RegistrationService;
import services.registration_services.RegistrationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Autowired
    private static RegistrationService registrationService ;
    @Autowired
    private static LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("POST");

        String login = req.getParameter("inputLogin");
        String password = req.getParameter("inputPassword");

        UserDTO userDTO = new UserDTO(req.getParameter("firstName"),
                        req.getParameter("familyName"), req.getParameter("patronymic"),
                        req.getParameter("birthDate"), req.getParameter("passport"),
                        req.getParameter("SNILS"), req.getParameter("medPolis"),
                        req.getParameter("registerLocation"), req.getParameter("address"),
                        req.getParameter("sexType"));
        Boolean registrationResult = registrationService.regUser(login, password);
        if (registrationResult) {
            registrationService.insertUser(login, password, userDTO);
            req.getSession().setAttribute("isAuth", true);
            req.getSession().setAttribute("role", "patient");
            loginService.sortUser(req, resp);
//            resp.sendRedirect("/web/patient_main");
        } else {
            getServletContext().getRequestDispatcher("/").forward(req, resp);
        }
    }
}