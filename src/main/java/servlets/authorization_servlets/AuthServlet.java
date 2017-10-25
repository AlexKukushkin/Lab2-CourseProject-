package servlets.authorization_servlets;

import services.authorization_services.AuthorizationService;
import services.authorization_services.AuthorizationServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends HttpServlet{
    private static AuthorizationService authorizationService = new AuthorizationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sortUser(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sortUser(request, response);
    }

    public void sortUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Boolean isAuth = (Boolean) ((HttpServletRequest)request).getSession().getAttribute("isAuth");
        String role;
        int userId;

        if (isAuth == null) isAuth = false;
        if (isAuth) {
            role = (String) ((HttpServletRequest)request).getSession().getAttribute("role");
        } else {
            String login = request.getParameter("inputLogin");
            String password = request.getParameter("inputPassword");

            role = authorizationService.auth(login, password);

            userId = authorizationService.getUserID(login, password);
            request.getSession().setAttribute("userID", userId);
        }

        if (!"false".equals(role)){
            request.getSession().setAttribute("isAuth", true);
            request.getSession().setAttribute("role", role);
            switch (role) {
                case "admin": response.sendRedirect("/web/admin_main"); break;
                case "doctor" : response.sendRedirect("/web/doctor_main"); break;
                case "patient" : response.sendRedirect("/web/patient_main"); break;
                default: response.sendRedirect("/web");
            }
        } else {
            request.getSession().setAttribute("isAuth", false);
            response.sendRedirect("/web");
        }
    }
}
