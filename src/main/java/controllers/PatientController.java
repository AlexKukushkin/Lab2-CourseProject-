package controllers;

import db.dao.DoctorDAO;
import db.dao.PatientDAO;
import db.dao.TicketDAO;
import dto.DoctorDTO;
import dto.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pojo.Doctor;
import pojo.MedCenter;
import pojo.Patient;
import pojo.Ticket;
import services.patient_services.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("session")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(value = "/patient_main", method = RequestMethod.GET)
    public String showPatientMainPage() {
        return "patient_main";
    }

    @RequestMapping(value = "/patient_main", method = RequestMethod.POST)
    public String returnBackToMainPage(HttpServletRequest request) {
        String exit = request.getParameter("exit");

        if ("exit".equals(exit)) {
            request.getSession().setAttribute("isAuth", false);
            request.getSession().setAttribute("role", null);
            return "redirect:/";
        } else {
            return "patient_main";
        }
    }

    @RequestMapping(value = "/patient_main/patient_edit", method = RequestMethod.POST)
    public ModelAndView doEditPatient(HttpServletRequest request) throws PatientDAO.PatientDAOException, UnsupportedEncodingException {

        ModelAndView modelAndView = new ModelAndView("patient_edit");

        int userId = (Integer) request.getSession().getAttribute("userID");
        int patientId;
        Patient patient;

        patientId = patientService.getPatientId(userId);

        HttpSession session = request.getSession();
        session.setAttribute("patientID", patientId);

        patient = patientService.getPatientByID(patientId);
        modelAndView.getModel().put("patient", patient);

        return modelAndView;
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
    public String getDoctorList() {
        return "patient_doctor_schedule";
    }

    @RequestMapping(value = "/patient_main/patient_doctor_schedule2", method = RequestMethod.POST)
    public String getDoctorList2() {
        return "patient_doctor_schedule2";
    }

    @RequestMapping(value = "/patient_main/patient_info", method = RequestMethod.POST)
    public String showInfoPage() {
        return "patient_info";
    }

    @RequestMapping(value = "/patient_main/patient_medcenter", method = RequestMethod.POST)
    public ModelAndView getMedCenterList(HttpServletRequest request) throws IOException {
        ModelAndView modelAndView = new ModelAndView("patient_medcenter");
        List<MedCenter> medcenters;

        medcenters = patientService.getPatientMedCenter();

        modelAndView.getModel().put("list", medcenters);
        return modelAndView;
    }

    @RequestMapping(value = "/patient_main/patient_ticket", method = RequestMethod.POST)
    public ModelAndView getTickets(HttpServletRequest request) throws IOException, ServletException {
        ModelAndView modelAndView = new ModelAndView("patient_ticket");
        List<Ticket> tickets;
        int userId;

        userId = (Integer)request.getSession().getAttribute("userID");
        tickets = patientService.getPatientTicketList(userId);

        modelAndView.getModel().put("ticket_list", tickets);
        return modelAndView;
    }

    @RequestMapping(value = "/patient_main/patient_save", method = RequestMethod.POST)
    public String savePatients(HttpServletRequest request) throws UnsupportedEncodingException {
        //@RequestParam(name = "first_name") String firstName
        int idPatient = Integer.valueOf(request.getParameter("id_patient"));
        String firstName = request.getParameter("first_name");
        String familyName = request.getParameter("family_name");
        String patronymic = request.getParameter("patronymic");
        String birthDate = request.getParameter("birth_date");
        String passport = request.getParameter("passport");
        String SNILS = request.getParameter("SNILS");
        String medPolis = request.getParameter("medpolis");
        String registerLocation = request.getParameter("registration");
        String homeLocation = request.getParameter("home_location");
        String sexType = request.getParameter("sextype");

        patientService.savePatient(idPatient, firstName, familyName, patronymic, birthDate, passport,
                SNILS, medPolis, registerLocation, homeLocation, sexType);

        return "redirect:/patient_main/patient_data";
    }

    @RequestMapping(value = "/patient_main/patient_data", method = RequestMethod.GET)
    public ModelAndView getPatients(HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("patient_data");
        List<Patient> patients;

        patients = patientService.getPatients();
        modelAndView.getModel().put("list", patients);

        return modelAndView;
    }

    @RequestMapping(value = "/patient_main/patient_new_ticket", method = RequestMethod.POST)
    public ModelAndView showLocation() throws IOException {
        List<MedCenter> medcenters;
        ModelAndView modelAndView = new ModelAndView("patient_new_ticket");

        medcenters = patientService.getPatientMedCenter();
        modelAndView.getModel().put("list", medcenters);
        return modelAndView;
    }


    @RequestMapping(value = "/patient_main/ticket_specialization", method = RequestMethod.POST)
    public ModelAndView showSpecialization(HttpServletRequest request, @RequestParam("idMedCenter") int idMedCenter) throws IOException {
        List<String> specializations;
        ModelAndView modelAndView = new ModelAndView("ticket_specialization");

        HttpSession session = request.getSession(false);
        session.setAttribute("idMedCenter", idMedCenter);

        specializations = patientService.getDoctorSpecialization(idMedCenter);

        modelAndView.getModel().put("specializations", specializations);

        return modelAndView;
    }

    @RequestMapping(value = "/patient_main/ticket_doctor", method = RequestMethod.POST)
    public ModelAndView showDoctorList(HttpServletRequest request) {
        List<DoctorDTO> doctors;
        ModelAndView modelAndView = new ModelAndView("ticket_doctor");
        int idMedCenter = (Integer) request.getSession().getAttribute("idMedCenter");
        String specialization = request.getParameter("specialization");
        HttpSession session = request.getSession(false);
        session.setAttribute("specialization", specialization);

        doctors = patientService.getDoctorsForTicket(idMedCenter, specialization);

        modelAndView.getModel().put("doctors", doctors);
        return modelAndView;
    }

    @RequestMapping(value = "/patient_main/ticket_date_time", method = RequestMethod.POST)
    public ModelAndView showDateTime(HttpServletRequest request) {
        List<String> timeToDoctor = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("ticket_date_time");

        timeToDoctor.add("8:00");
        timeToDoctor.add("8:30");
        timeToDoctor.add("9:00");
        timeToDoctor.add("9:30");
        timeToDoctor.add("10:00");
        timeToDoctor.add("10:30");
        timeToDoctor.add("11:00");
        timeToDoctor.add("11:30");
        timeToDoctor.add("13:00");
        timeToDoctor.add("13:30");
        timeToDoctor.add("14:00");
        timeToDoctor.add("14:30");
        timeToDoctor.add("15:00");
        timeToDoctor.add("15:30");
        timeToDoctor.add("16:00");
        timeToDoctor.add("16:30");
        timeToDoctor.add("17:00");

        modelAndView.getModel().put("time_list", timeToDoctor);
        return modelAndView;
    }


    @RequestMapping(value = "/patient_main/get_ticket", method = RequestMethod.GET)
    public ModelAndView doGetTicket() {
        ModelAndView modelAndView = new ModelAndView("get_ticket");
        return modelAndView;
    }

    @RequestMapping(value = "/patient_main/get_ticket", method = RequestMethod.POST)
    public ModelAndView doPostTicket(HttpServletRequest request) throws ParseException {
        Ticket ticket;

        ModelAndView modelAndView = new ModelAndView("get_ticket");
        String time = request.getParameter("timevar");
        String date = request.getParameter("patientDate");
//        String day = request.getParameter("patientDay");
        int idPatient = (Integer) request.getSession().getAttribute("patientID");
        int idMedCenter = (Integer) request.getSession().getAttribute("idMedCenter");
        String specialization = (String) request.getSession().getAttribute("specialization");

        ticket = patientService.getTicket(idPatient, idMedCenter, specialization, time, date);
        modelAndView.getModel().put("ticket", ticket);
        return modelAndView;
    }

    @RequestMapping(value = "/patient_main/check_date_time", method = RequestMethod.POST)
    public ModelAndView checkDateTime(HttpServletRequest request) throws DoctorDAO.DoctorDAOException, TicketDAO.TicketDAOException {
        List<TicketDTO> tickets;
        ModelAndView modelAndView = new ModelAndView("check_date_time");

        String date = request.getParameter("patientDate");
        int idMedCenter = (Integer) request.getSession().getAttribute("idMedCenter");
        String specialization = (String) request.getSession().getAttribute("specialization");

        tickets = patientService.getTicketsByDate(idMedCenter, specialization, date);
        modelAndView.getModel().put("tickets", tickets);
        return modelAndView;
    }


}
