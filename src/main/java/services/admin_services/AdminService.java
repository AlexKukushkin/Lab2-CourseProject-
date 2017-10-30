package services.admin_services;

import db.dao.*;
import org.apache.log4j.Logger;
import pojo.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class AdminService { //todo должен быть 1 сервис AdmingetAll со множеством методов
    private static final Logger logger = Logger.getLogger(AdminService.class);

    public List<Doctor> doAdminGetAllDoctorList() throws IOException {
        List<Doctor> doctors = null;

        try {
            doctors = new DoctorDAO().getAll();
        } catch (DoctorDAO.DoctorDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return doctors;
    }

    public List<Patient> doAdminGetAllPatients() throws ServletException, IOException {
        List<Patient> patients = null;
        try {
            patients = new PatientDAO().getAll();
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return patients;
    }

    public List<User> doAdminGetAllUsers() throws IOException, SQLException {
        return new UserDAOImpl().getAllUsers();
    }

    public List<MedCenter> doAdminGetMedcenters() throws ServletException, IOException {
        List<MedCenter> medCenters = Collections.emptyList();

        try {
            medCenters = new MedCenterDAO().getAll();
        } catch (MedCenterDAO.MedCenterDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return medCenters;
    }

    public List<Calendar> doAdminGetSchedule() throws ServletException, IOException {
        List<Calendar> calendarList = null;

        try {
            calendarList = new CalendarDAO().getAll();
        } catch (CalendarDAO.CalendarDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return calendarList;
    }

    public List<Ticket> doAdminGetTickets() throws IOException {

        try {
            return new TicketDAO().getAll();
        } catch (TicketDAO.TicketDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return Collections.emptyList();
    }
}
