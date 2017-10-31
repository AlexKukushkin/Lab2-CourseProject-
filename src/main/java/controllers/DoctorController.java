package controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Calendar;
import pojo.Ticket;
import services.admin_services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@Scope("session")
public class DoctorController {
    private static AdminService adminService = new AdminService();

    @RequestMapping(value = "/doctor_main", method = RequestMethod.GET)
    public String showDoctorMainPage() {
        return "doctor_main";
    }

    @ModelAttribute("exit")
    public String getExit(HttpServletRequest request)
    {
        return request.getParameter("exit");
    }

    @RequestMapping(value = "/doctor_main", method = RequestMethod.POST)
    public String returnBackToMainPage(HttpServletRequest request, @ModelAttribute("exit") String exit) {
        if ("exit".equals(exit)) {
            request.getSession().setAttribute("isAuth", false);
            request.getSession().setAttribute("role", null);
            return "redirect:/";
        } else {
            return "doctor_main";
        }
    }

    @RequestMapping(value = "/doctor_main/doctor_ticket_list", method = RequestMethod.POST)
    public ModelAndView getTickets() throws IOException {
        List<Ticket> tickets;
        ModelAndView modelAndView = new ModelAndView("doctor_ticket_list");
        tickets = adminService.doAdminGetTickets();
        modelAndView.getModel().put("ticket_list", tickets);
        return modelAndView;
    }

    @RequestMapping(value = "/doctor_main/doctor_doctor_schedule", method = RequestMethod.POST)
    public ModelAndView getSchedule() throws IOException, ServletException, SQLException {
        List<Calendar> calendarList;
        ModelAndView modelAndView = new ModelAndView("doctor_doctor_schedule");
        calendarList = adminService.doAdminGetSchedule();
        modelAndView.getModel().put("list", calendarList);
        return modelAndView;
    }
}
