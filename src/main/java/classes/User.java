package classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public abstract class User implements Serializable {
    String password;
    String login;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    @XmlElement
    public void setLogin(String login){
        this.login = login;
    }
    @XmlElement
    public void setPassword(String password){
        this.password = password;
    }
}
