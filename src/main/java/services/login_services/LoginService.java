package services.login_services;

import db.dao.PatientDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import pojo.User;
import services.authorization_services.AuthorizationServiceImpl;
import servlets.authorization_servlets.AuthServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service
public class LoginService {
    private static final Logger logger = Logger.getLogger(AuthServlet.class);
    AuthorizationServiceImpl authorizationService;
    PatientDAO patientDAO;

    public LoginService(AuthorizationServiceImpl authorizationService, PatientDAO patientDAO) {
        this.authorizationService = authorizationService;
        this.patientDAO = patientDAO;
    }

    public String sortUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession currentSession = request.getSession();
        Boolean isAuth = (Boolean) currentSession.getAttribute("isAuth");

        String role;
        int userId;

        if (isAuth == null) {
            isAuth = false;
        }

        if (isAuth) {
            role = (String) currentSession.getAttribute("role");
        } else {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            User user = authorizationService.auth(login, password);
            role = user.getRole();

            userId = authorizationService.getUserID(login, password);
            currentSession.setAttribute("userID", userId);

            try {
                int patientId = patientDAO.getPatientID(Integer.valueOf(userId));
                currentSession.setAttribute("patientID", patientId);
            } catch (PatientDAO.PatientDAOException e) {
                logger.error("This is Error : " + e.getMessage());
            }
        }

        if (!"false".equals(role)){
            currentSession.setAttribute("isAuth", true);
            currentSession.setAttribute("role", role);
            switch (role) {
                case "admin":
                    return "redirect:/admin_main";
                case "doctor":
                    return "redirect:/doctor_main";
                case "patient":
                    return "redirect:/patient_main";
                default:
                    return "redirect:/";
            }
        } else {
            return "redirect:/";
        }
    }
}
