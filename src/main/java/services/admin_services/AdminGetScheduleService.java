package services.admin_services;

import db.dao.CalendarDAO;
import pojo.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminGetScheduleService {
    public void doAdminGetSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Calendar> calendarList = null;

        try {
            calendarList = new CalendarDAO().getAll();
        } catch (CalendarDAO.CalendarDAOException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", calendarList);
        req.getRequestDispatcher("/doctor_schedule.jsp").forward(req, resp);
    }
}
