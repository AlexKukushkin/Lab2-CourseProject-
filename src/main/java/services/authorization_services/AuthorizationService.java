package services.authorization_services;

import pojo.User;

public interface AuthorizationService {
    //Boolean auth(String login, String password);
    User auth(String login, String password);
    int getUserID(String login, String password);
}
