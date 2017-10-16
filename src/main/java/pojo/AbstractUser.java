package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public abstract class AbstractUser implements Serializable {
    String password;
    String login;
    String role;

    public AbstractUser() {
    }

    public AbstractUser(String password, String login, String role) {
        this.password = password;
        this.login = login;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }

    @XmlElement
    public void setLogin(String login){
        this.login = login;
    }
    @XmlElement
    public void setPassword(String password){
        this.password = password;
    }
    @XmlElement
    public void setRole(String role) {
        this.role = role;
    }
}
