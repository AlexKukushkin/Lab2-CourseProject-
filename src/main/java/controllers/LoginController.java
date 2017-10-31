package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.login_services.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    private static LoginService loginService = new LoginService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public void doAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        loginService.sortUser(request, response);
    }
}
