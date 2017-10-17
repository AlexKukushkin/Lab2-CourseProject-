package services;

public interface RegistrationService {
    Boolean regUser(String login, String password);
    int getUserID(String login, String password);
}
