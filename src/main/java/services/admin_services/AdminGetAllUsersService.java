package services.admin_services;

import db.dao.UserDAOImpl;
import pojo.User;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminGetAllUsersService {
    public List<User> doAdminGetAllUsers() throws IOException, SQLException {
        List<User> users;

        users = new UserDAOImpl().getAllUsers();

        return users;
    }
}
