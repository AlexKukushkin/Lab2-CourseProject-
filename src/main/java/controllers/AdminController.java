package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Ticket;
import services.admin_services.AdminService;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {
    private static AdminService adminService = new AdminService();

    @RequestMapping(value = "/admin_main", method = RequestMethod.GET)
    public String showAdminMainPage() {
        return "admin_main";
    }

    @RequestMapping(value = "/admin_main/admin_ticket_list", method = RequestMethod.POST)
    public ModelAndView getTickets() throws IOException {
        List<Ticket> tickets;
        ModelAndView modelAndView = new ModelAndView("admin_ticket_list");
        tickets = adminService.doAdminGetTickets();
        modelAndView.getModel().put("ticket_list", tickets);
        return modelAndView;
    }
}
