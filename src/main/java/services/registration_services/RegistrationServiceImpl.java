package services.registration_services;

import db.dao.IUserDAO;
import db.dao.PatientDAO;
import db.dao.UserDAOImpl;
import dto.UserDTO;
import org.apache.log4j.Logger;
import pojo.Patient;
import pojo.User;

import static services.registration_services.PasswordEncoder.encode;

public class RegistrationServiceImpl implements RegistrationService {

    private static IUserDAO userDAO = new UserDAOImpl();
    private static PatientDAO patientDAO = new PatientDAO();
    private static RegistrationService registrationService = new RegistrationServiceImpl();
    private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);


    @Override
    public Boolean regUser(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        return userDAO.createUser(new User(login, encode(password), "patient"));
    }

    @Override
    public int getUserID(String login, String password) {
        if(login == null || password == null){
            return 0;
        }
        return userDAO.getUserId(login, PasswordEncoder.encode(password));
    }

    @Override
    public void insertUser(String login, String password, UserDTO userDTO) {
        try {
            int idUser = registrationService.getUserID(login, password);
            patientDAO.insertOne(new Patient(userDTO.getFirstName(), userDTO.getFamilyName(), userDTO.getPatronymic(),
                    userDTO.getBirthDate(), userDTO.getPassport(), userDTO.getSNILS(), userDTO.getMedPolis(),
                    userDTO.getRegisterLocation(), userDTO.getAddress(), userDTO.getSexType(), idUser));
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
