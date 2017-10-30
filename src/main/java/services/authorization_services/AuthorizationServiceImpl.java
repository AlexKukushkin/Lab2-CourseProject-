package services.authorization_services;

import db.dao.IUserDAO;
import db.dao.UserDAOImpl;
import org.springframework.stereotype.Service;
import pojo.User;
import services.registration_services.PasswordEncoder;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private static IUserDAO userDAO = new UserDAOImpl();

    @Override
    public User auth(String login, String password) {
        if (login == null || password == null) {
            throw new IllegalArgumentException();
        }

        return userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password));
    }

    @Override
    public int getUserID(String login, String password){
        return userDAO.getUserId(login, PasswordEncoder.encode(password));
    }
}
