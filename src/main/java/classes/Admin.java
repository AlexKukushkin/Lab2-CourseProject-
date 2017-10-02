package classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Admin extends User {
    public Admin() {
    }

    public Admin(String login, String password) {
        super(login, password);
    }

    @Override
    public void logIn(String login) {
        this.login = login;
    }

    public String getLogin(){
        return this.login;
    }

    @XmlElement
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
