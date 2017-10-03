package classes;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Admin extends User {
    public Admin() {
    }

    public Admin(String login, String password) {
        super(login, password);
    }
}
