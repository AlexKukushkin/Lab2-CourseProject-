package services.authorization_services;

public interface AuthorizationService {
    //Boolean auth(String login, String password);
    String auth(String login, String password);
    int getUserID(String login, String password);
}
