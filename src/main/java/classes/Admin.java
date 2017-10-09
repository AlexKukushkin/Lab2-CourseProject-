package classes;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Admin extends User {
    private int idAdmin;

    public Admin() {
    }

//    public Admin(int idAdmin, String login, String password) {
//        this.idAdmin = idAdmin;
//    }

    public Admin(String login, String password) {
        super(login, password);
        this.idAdmin = 0;
    }
    public Admin(int idAdmin, String login, String password) {
        super(login, password);
        this.idAdmin = idAdmin;
    }
}
