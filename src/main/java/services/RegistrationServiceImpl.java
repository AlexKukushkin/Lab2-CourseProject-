package services;

import db.dao.IUserDAO;
import db.dao.UserDAOImpl;
import pojo.User;

import static services.PasswordEncoder.encode;

public class RegistrationServiceImpl implements RegistrationService {
    private static IUserDAO userDAO = new UserDAOImpl();

    @Override
    public Boolean regUser(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        return userDAO.createUser(new User(login, encode(password), "patient"));
    }
}
