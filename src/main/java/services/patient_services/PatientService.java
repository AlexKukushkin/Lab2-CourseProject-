package services.patient_services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientService {
    public void checkIfExit (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exit = req.getParameter("exit");
        if ("exit".equals(exit)) {
            req.getSession().setAttribute("isAuth", false);
            req.getSession().setAttribute("role", null);
            ((HttpServletResponse) resp).sendRedirect("/web");
        } else {
            ((HttpServletResponse) resp).sendRedirect("/web/patient_main");
        }
    }
}
