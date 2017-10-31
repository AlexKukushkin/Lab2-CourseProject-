package controllers;

import db.dao.PatientDAO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Doctor;
import pojo.Patient;
import services.patient_services.PatientService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@Scope("session")
public class PatientController {
    private static PatientService patientService = new PatientService();

    @RequestMapping(value = "/patient_main", method = RequestMethod.GET)
    public String showPatientMainPage() {
        return "patient_main";
    }

    @ModelAttribute("exit")
    public String getExit(HttpServletRequest request)
    {
        return request.getParameter("exit");
    }

    @RequestMapping(value = "/patient_main", method = RequestMethod.POST)
    public String returnBackToMainPage(HttpServletRequest request, @ModelAttribute("exit") String exit) {
        if ("exit".equals(exit)) {
            request.getSession().setAttribute("isAuth", false);
            request.getSession().setAttribute("role", null);
            return "redirect:/";
        } else {
            return "patient_main";
        }
    }

    @ModelAttribute("userID")
    public int getUserID(HttpServletRequest request) {
        return (Integer)request.getSession().getAttribute("userID");
    }

    @RequestMapping(value = "/patient_main/patient_edit", method = RequestMethod.POST)
    public String doEditPatient(HttpServletRequest request, @ModelAttribute("userID") int userId) throws PatientDAO.PatientDAOException {

        int patientId;
        Patient patient;

        patientId = patientService.getPatientId(userId);

        HttpSession session = request.getSession();
        session.setAttribute("patientID", patientId);

        patient = patientService.getPatientByID(patientId);

        request.setAttribute("patient", patient);
        return "patient_edit";
    }

    @RequestMapping(value = "/patient_main/patient_doctor_list", method = RequestMethod.POST)
    public ModelAndView getDoctorList(HttpServletRequest request) throws IOException {
        ModelAndView modelAndView = new ModelAndView("patient_doctor_list");
        List<Doctor> doctors;

        doctors = patientService.patientGetDoctorList();
        modelAndView.getModel().put("list", doctors);

        return modelAndView;
    }

    @RequestMapping(value = "/patient_main/patient_doctor_schedule", method = RequestMethod.POST)
    public String getDoctorList(){
        return "patient_doctor_schedule";
    }

    @RequestMapping(value = "/patient_main/patient_info", method = RequestMethod.POST)
    public String showInfoPage(){
        return "patient_info";
    }

    @RequestMapping(value = "/patient_main/patient_medcenter", method = RequestMethod.POST)
    public String getMedCenterList(){
        return "patient_medcenter";
    }

    @RequestMapping(value = "/patient_main/patient_ticket", method = RequestMethod.POST)
    public String getTickets(){
        return "patient_ticket";
    }

}
