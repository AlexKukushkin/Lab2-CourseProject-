package services.registration_services;

import db.dao.IUserDAO;
import db.dao.PatientDAO;
import dto.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pojo.Patient;
import pojo.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
    private IUserDAO userDAO;
    private PatientDAO patientDAO;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(IUserDAO userDAO, PatientDAO patientDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.patientDAO = patientDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Boolean regUser(String login, String password) {
        if (login == null || password == null) {
            return false;
        }else{
            userDAO.createUser(new User(login, passwordEncoder.encode(password), "patient"));
        }
        return true;
    }

    @Override
    public int getUserID(String login, String password) {
        if(login == null || password == null){
            return 0;
        }
        return userDAO.getUserId(login, passwordEncoder.encode(password));
    }

    @Override
    public void insertUser(String login, String password, UserDTO userDTO) {
        try {
            int idUser = getUserID(login, password);
            patientDAO.insertOne(new Patient(userDTO.getFirstName(), userDTO.getFamilyName(), userDTO.getPatronymic(),
                    userDTO.getBirthDate(), userDTO.getPassport(), userDTO.getSNILS(), userDTO.getMedPolis(),
                    userDTO.getRegisterLocation(), userDTO.getAddress(), userDTO.getSexType(), idUser));
        } catch (PatientDAO.PatientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
