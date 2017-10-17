package services;

import db.dao.IUserDAO;
import db.dao.UserDAOImpl;

public class AuthorizationServiceImpl implements AuthorizationService {
    private static IUserDAO userDAO = new UserDAOImpl();

    @Override
    public String auth(String login, String password) {
        if (login == null || password == null) {
            return "false";
        }
        if (userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password)) != null
                && "admin".equals(userDAO.getUserRole(login, PasswordEncoder.encode(password)))){
            return "admin";
        }
        else if (userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password)) != null
                && "doctor".equals(userDAO.getUserRole(login, PasswordEncoder.encode(password)))){
            return "doctor";
        }
        else if(userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password)) != null
                && "patient".equals(userDAO.getUserRole(login, PasswordEncoder.encode(password)))){
                return "patient";
        }
        return "false";
    }
}
