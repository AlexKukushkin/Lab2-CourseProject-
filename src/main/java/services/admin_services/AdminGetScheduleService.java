package services.admin_services;

import db.dao.CalendarDAO;
import org.apache.log4j.Logger;
import pojo.Calendar;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class AdminGetScheduleService {
    private static final Logger logger = Logger.getLogger(AdminGetScheduleService.class);

    public List<Calendar> doAdminGetSchedule() throws ServletException, IOException {

        List<Calendar> calendarList = null;

        try {
            calendarList = new CalendarDAO().getAll();
        } catch (CalendarDAO.CalendarDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return calendarList;
    }
}
