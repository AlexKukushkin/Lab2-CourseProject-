package controllers;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.login_services.LoginService;
import services.registration_services.RegistrationService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterController {

    private RegistrationService registrationService;
    private LoginService loginService;

    @Autowired
    public RegisterController(RegistrationService registrationService, LoginService loginService) {
        this.registrationService = registrationService;
        this.loginService = loginService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("inputLogin");
        String password = request.getParameter("inputPassword");

        UserDTO userDTO = new UserDTO(
                request.getParameter("firstName"),
                request.getParameter("familyName"),
                request.getParameter("patronymic"),
                request.getParameter("birthDate"),
                request.getParameter("passport"),
                request.getParameter("SNILS"),
                request.getParameter("medPolis"),
                request.getParameter("registerLocation"),
                request.getParameter("address"),
                request.getParameter("sexType"));

        Boolean registrationResult = registrationService.regUser(login, password);
        if (registrationResult) {
            registrationService.insertUser(login, password, userDTO);
            request.getSession().setAttribute("isAuth", true);
            request.getSession().setAttribute("role", "patient");
            loginService.sortUser(request, response);
            return "patient_main";
        } else {
            return "redirect:/";
        }
    }
}
