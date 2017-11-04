package services.authorization_services;

import db.dao.IUserDAO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pojo.User;


@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private IUserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    public AuthorizationServiceImpl(IUserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User auth(String login, String password) {
        if (login == null || password == null) {
            throw new IllegalArgumentException();
        }

        return userDAO.getUserByLoginAndPassword(login, passwordEncoder.encode(password));
    }

    @Override
    public int getUserID(String login, String password){
        return userDAO.getUserId(login, passwordEncoder.encode(password));
    }
}
