//package services.authorization_services;
//
//import db.dao.PatientDAO;
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Service;
//import pojo.User;
//import servlets.authorization_servlets.AuthServlet;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@Service
//public class LoginService {
//    private static AuthorizationService authorizationService = new AuthorizationServiceImpl();
//    private static final Logger logger = Logger.getLogger(AuthServlet.class);
//    PatientDAO patientDAO = new PatientDAO();
//
//    public void sortUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        HttpSession currentSession = request.getSession();
//        Boolean isAuth = (Boolean) currentSession.getAttribute("isAuth");
//
//        String role;
//        int userId;
//
//        if (isAuth == null) {
//            isAuth = false;
//        }
//
//        if (isAuth) {
//            role = (String) currentSession.getAttribute("role");
//        } else {
//            String login = request.getParameter("inputLogin");
//            String password = request.getParameter("inputPassword");
//            User user = authorizationService.auth(login, password);
//            role = user.getRole();
//
//            userId = authorizationService.getUserID(login, password);
//            currentSession.setAttribute("userID", userId);
//
//            try {
//                int patientId = patientDAO.getPatientID(Integer.valueOf(userId));
//                currentSession.setAttribute("patientID", patientId);
//            } catch (PatientDAO.PatientDAOException e) {
//                logger.error("This is Error : " + e.getMessage());
//            }
//        }
//
//        if (!"false".equals(role)){
//            currentSession.setAttribute("isAuth", true);
//            currentSession.setAttribute("role", role);
//            switch (role) {
//                case "admin":
//                    response.sendRedirect("/web/admin_main");
//                    break;
//                case "doctor":
//                    response.sendRedirect("/web/doctor_main");
//                    break;
//                case "patient":
//                    response.sendRedirect("/web/patient_main");
//                    break;
//                default:
//                    response.sendRedirect("/web");
//            }
//        } else {
//            response.sendRedirect("/web");
//        }
//    }
//}
