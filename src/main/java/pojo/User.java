package pojo;

import javax.xml.bind.annotation.XmlElement;

public class User {
    private String login;
    private String password;
    private String role;

    public User() {
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }

    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }
    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
    @XmlElement
    public void setRole(String role) {
        this.role = role;
    }
}
