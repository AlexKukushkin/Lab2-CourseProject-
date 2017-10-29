package servlets.admin_servlets;

import pojo.Calendar;
import services.admin_services.AdminGetScheduleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetScheduleServlet extends HttpServlet {
    private static AdminGetScheduleService adminGetScheduleService = new AdminGetScheduleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin_doctor_schedule.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Calendar> calendarList;

        calendarList = adminGetScheduleService.doAdminGetSchedule();

        req.setAttribute("list", calendarList);
        req.getRequestDispatcher("/admin_doctor_schedule.jsp").forward(req, resp);
    }
}
