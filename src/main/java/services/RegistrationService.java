package services;

import dto.UserDTO;

public interface RegistrationService {
    Boolean regUser(String login, String password);
    int getUserID(String login, String password);
    void insertUser(String login, String password, UserDTO userDTO);
}
