package servlets.doctor_servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoctorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/doctor_main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exit = req.getParameter("exit");
//        String showSchedule = req.getParameter("showSchedule");
//        String showPatients = req.getParameter("showPatients");

//        if("showScheduleDoc".equals(showSchedule)){
//            ((HttpServletResponse)resp).sendRedirect("/web/doctor_schedule");
////            req.getRequestDispatcher("/admin_doctor_schedule.jsp").forward(req, resp);
//        } else if("showPatientList".equals(showPatients)){
//            ((HttpServletResponse)resp).sendRedirect("/web/doctor_main");
////            req.getRequestDispatcher("/doctor_main.jsp").forward(req, resp);
//        } else if ("exit".equals(exit)) {
//            req.getSession().setAttribute("isAuth", false);
//            req.getSession().setAttribute("role", null);
//            ((HttpServletResponse) resp).sendRedirect("/web");
//        } else {
//            ((HttpServletResponse) resp).sendRedirect("/web/doctor_main");
//        }

        if ("exit".equals(exit)) {
            req.getSession().setAttribute("isAuth", false);
            req.getSession().setAttribute("role", null);
            ((HttpServletResponse) resp).sendRedirect("/web");
        } else {
            ((HttpServletResponse) resp).sendRedirect("/web/doctor_main");
        }
    }
}
