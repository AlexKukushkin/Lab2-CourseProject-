package servlets;

import services.AuthorizationService;
import services.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static AuthorizationService authorizationService = new AuthorizationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("inputLogin");
        String password = req.getParameter("inputPassword");
        if (authorizationService.auth(login, password)) {
            req.getSession().setAttribute("isAuth", true);
//            req.getRequestDispatcher("/student").forward(req, resp);
            ((HttpServletResponse)resp).sendRedirect("/web/main");
        }else{
            getServletContext().getRequestDispatcher("/").forward(req, resp);
        }
    }
}
