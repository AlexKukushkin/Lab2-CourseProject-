package controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("session")
public class PatientController {
    @RequestMapping(value = "/patient_main", method = RequestMethod.GET)
    public String showPatientMainPage() {
        return "patient_main";
    }

    @ModelAttribute("exit")
    public String getExit(HttpServletRequest request)
    {
        return request.getParameter("exit");
    }

    @RequestMapping(value = "/patient_main", method = RequestMethod.POST)
    public String returnBackToMainPage(HttpServletRequest request, @ModelAttribute("exit") String exit) {
        if ("exit".equals(exit)) {
            request.getSession().setAttribute("isAuth", false);
            request.getSession().setAttribute("role", null);
            return "redirect:/";
        } else {
            return "patient_main";
        }
    }
}
