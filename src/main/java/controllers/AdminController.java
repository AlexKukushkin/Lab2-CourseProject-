package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.*;
import services.admin_services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@Scope("session")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/admin_main", method = RequestMethod.GET)
    public String showAdminMainPage() {
        return "admin_main";
    }

    @ModelAttribute("exit")
    public String getExit(HttpServletRequest request)
    {
        return request.getParameter("exit");
    }

    @RequestMapping(value = "/admin_main", method = RequestMethod.POST)
    public String returnBackToMainPage(HttpServletRequest request, @ModelAttribute("exit") String exit) {
        if ("exit".equals(exit)) {
            request.getSession().setAttribute("isAuth", false);
            request.getSession().setAttribute("role", null);
            return "redirect:/";
        } else {
            return "admin_main";
        }
    }

    @RequestMapping(value = "/admin_main/admin_ticket_list", method = RequestMethod.POST)
    public ModelAndView getTickets() throws IOException {
        List<Ticket> tickets;
        ModelAndView modelAndView = new ModelAndView("admin_ticket_list");
        tickets = adminService.doAdminGetTickets();
        modelAndView.getModel().put("ticket_list", tickets);
        return modelAndView;
    }

    @RequestMapping(value = "/admin_main/admin_patient_list", method = RequestMethod.POST)
    public ModelAndView getPatients() throws IOException, ServletException {
        List<Patient> patients;
        ModelAndView modelAndView = new ModelAndView("admin_patient_list");
        patients = adminService.doAdminGetAllPatients();
        modelAndView.getModel().put("list", patients);
        return modelAndView;
    }

    @RequestMapping(value = "/admin_main/admin_user_list", method = RequestMethod.POST)
    public ModelAndView getUsers() throws IOException, ServletException, SQLException {
        List<User> users;
        ModelAndView modelAndView = new ModelAndView("admin_user_list");
        users = adminService.doAdminGetAllUsers();
        modelAndView.getModel().put("list", users);
        return modelAndView;
    }

    @RequestMapping(value = "/admin_main/admin_doctor_list", method = RequestMethod.POST)
    public ModelAndView getDoctors() throws IOException, ServletException, SQLException {
        List<Doctor> doctors;
        ModelAndView modelAndView = new ModelAndView("admin_doctor_list");
        doctors = adminService.doAdminGetAllDoctorList();
        modelAndView.getModel().put("list", doctors);
        return modelAndView;
    }

    @RequestMapping(value = "/admin_main/admin_doctor_schedule", method = RequestMethod.POST)
    public ModelAndView getSchedule() throws IOException, ServletException, SQLException {
        List<Calendar> calendarList;
        ModelAndView modelAndView = new ModelAndView("admin_doctor_schedule");
        calendarList = adminService.doAdminGetSchedule();
        modelAndView.getModel().put("list", calendarList);
        return modelAndView;
    }

    @RequestMapping(value = "/admin_main/admin_medcenters", method = RequestMethod.POST)
    public ModelAndView getMedCenters() throws IOException, ServletException, SQLException {
        List<MedCenter> medCenters;
        ModelAndView modelAndView = new ModelAndView("admin_medcenters");
        medCenters = adminService.doAdminGetMedcenters();
        modelAndView.getModel().put("list", medCenters);
        return modelAndView;
    }
}
