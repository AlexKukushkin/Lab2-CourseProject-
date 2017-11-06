package services.patient_services;

import db.dao.*;
import dto.DoctorDTO;
import dto.TicketDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private static final Logger logger = Logger.getLogger(PatientService.class);
    private static PatientDAO patientDAO = new PatientDAO();
    private static TicketDAO ticketDAO = new TicketDAO();
    private static DoctorDAO doctorDAO = new DoctorDAO();

    public List<Doctor> patientGetDoctorList() throws IOException {
        List<Doctor> doctors = null;

        try {
            doctors = new DoctorDAO().getAll();
        } catch (DoctorDAO.DoctorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return doctors;
    }

    public Calendar patientGetDoctorSchedule(String familyName) throws IOException, ServletException {
        Calendar calendar = null;

        try {
            calendar = new CalendarDAO().getByFamilyName(familyName);
        } catch (CalendarDAO.CalendarDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return calendar;
    }

    public List<MedCenter> getPatientMedCenter() throws IOException {
        List<MedCenter> medcenters = null;

        try {
            medcenters = new MedCenterDAO().getAll();
        } catch (MedCenterDAO.MedCenterDAOException e) {
            logger.error("This is Error : " + e.getMessage(), e);
        }
        return medcenters;
    }

    public List<Ticket> getPatientTicketList(int userId) throws ServletException, IOException {
        List<Ticket> tickets = null;

        try {
            tickets = new TicketDAO().getTicketsById(patientDAO.getPatientID(userId));
        } catch (TicketDAO.TicketDAOException | PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return tickets;
    }

    public List<DoctorDTO> getDoctorsForTicket(int idMedCenter, String specialization){
//        DoctorDAO doctorDAO = new DoctorDAO();
        List<DoctorDTO> doctors = new ArrayList<>();

        try {
            doctors = doctorDAO.getDoctor(idMedCenter, specialization);
        } catch (DoctorDAO.DoctorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return doctors;
    }

    public Ticket getTicket(int idPatient, int idMedCenter, String specialization, String time, String date) throws ParseException {
        Ticket ticket = new Ticket();

        try {
            int idDoctor = doctorDAO.getDoctorID(idMedCenter, specialization);
            ticketDAO.insertOne(new Ticket(idPatient, idDoctor, idMedCenter, time, date));
            ticket = ticketDAO.getTicket(idPatient, idDoctor, idMedCenter, time, date);
        } catch (DoctorDAO.DoctorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        } catch (TicketDAO.TicketDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return ticket;
    }

    public List<TicketDTO> getTicketsByDate(int idMedCenter, String specialization, String date) throws DoctorDAO.DoctorDAOException, TicketDAO.TicketDAOException {
        List<TicketDTO> ticketList;
        int idDoctor = doctorDAO.getDoctorID(idMedCenter, specialization);

        ticketList = ticketDAO.getRegisteredTickes(idDoctor, idMedCenter, specialization, date);
        return ticketList;
    }

    public List<String> getDoctorSpecialization(int idMedCenter){
//        DoctorDAO doctorDAO = new DoctorDAO();
        List<String> specializations = new ArrayList<>();

        try {
            specializations = doctorDAO.getDoctorSpecialization(idMedCenter);
        } catch (DoctorDAO.DoctorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return specializations;
    }

    public List<Patient> getPatients(){
        List<Patient> patients = new ArrayList<>();
        try {
            patients = new PatientDAO().getAll();
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return patients;
    }

    public int getPatientId(int userId) throws PatientDAO.PatientDAOException {
//        PatientDAO patientDAO = new PatientDAO();
        int patientId;

        patientId = patientDAO.getPatientID(Integer.valueOf(userId));

        return patientId;
    }

    public Patient getPatientByID(int patientId){
//        PatientDAO patientDAO = new PatientDAO();
        Patient patient = new Patient();

        try {
            patient = patientDAO.getByID(patientId);
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return patient;
    }

    public void savePatient(int idPatient, String firstName, String familyName, String patronymic,
                            String birthDate, String passport, String SNILS, String medPolis,
                            String registerLocation, String homeLocation, String sexType){
//        PatientDAO patientDAO = new PatientDAO();

        try {
            patientDAO.update(new Patient(idPatient, firstName, familyName, patronymic, birthDate,
                    passport, SNILS, medPolis, registerLocation, homeLocation, sexType));
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
