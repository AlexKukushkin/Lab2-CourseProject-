package services.authorization_services;

import db.dao.IUserDAO;
import db.dao.UserDAOImpl;
import pojo.User;
import services.registration_services.PasswordEncoder;

public class AuthorizationServiceImpl implements AuthorizationService {
    private static IUserDAO userDAO = new UserDAOImpl();

    @Override
    public User auth(String login, String password) {
        if (login == null || password == null) {
            throw new IllegalArgumentException();
        } //todo добавить в сессию юзер айди или юзер или что то подоюное (и пациегта)

        return userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password));
//        if (userByLoginAndPassword != null)
//                && "admin".equals(userDAO.getUserRole(login, PasswordEncoder.encode(password)))){
//            return "admin";
//        }
//        else if (userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password)) != null
//                && "doctor".equals(userDAO.getUserRole(login, PasswordEncoder.encode(password)))){
//            return "doctor";
//        }
//        else if(userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password)) != null
//                && "patient".equals(userDAO.getUserRole(login, PasswordEncoder.encode(password)))){
//            return "patient";
//        }
//        return "false";
    }

    @Override
    public int getUserID(String login, String password){
        return userDAO.getUserId(login, PasswordEncoder.encode(password));
    }
}
