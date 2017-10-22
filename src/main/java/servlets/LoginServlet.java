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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("inputLogin");
//        String password = request.getParameter("inputPassword");

        request.getRequestDispatcher("/login.jsp").forward(request, response);

//        if ("admin".equals(authorizationService.auth(login, password))) {
//            ((HttpServletResponse) response).sendRedirect("/web/admin_main");
//            request.getSession().setAttribute("isExit", true);
//        } else{
//            getServletContext().getRequestDispatcher("/").forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("inputLogin");
//        String password = request.getParameter("inputPassword");
//
//
////        request.getSession().setAttribute("isAuth", null);
//        String authResult = authorizationService.auth(login, password);
//        if (!"false".equals(authResult)){
//            request.getSession().setAttribute("isAuth", true);
//            request.getSession().setAttribute("role", authResult);
//            ((HttpServletResponse) response).sendRedirect("/web/auth");
//        } else {
//            request.getSession().setAttribute("isAuth", false);
//            ((HttpServletResponse) response).sendRedirect("/");
//        }

//        request.getSession().setAttribute("isAuth", isAuth);
//
//
//        if ("admin".equals(authorizationService.auth(login, password))) {
////            request.getSession().setAttribute("isAdmin", true);
//            ((HttpServletResponse) response).sendRedirect("/web/admin_main");
//            request.getSession().setAttribute("isExit", true);
//
//        } else{
//            getServletContext().getRequestDispatcher("/").forward(request, response);
//        }
    }
}
