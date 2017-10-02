package classes;

import java.io.Serializable;

public abstract class User implements Serializable {
    String password;
    String login;

    public User() {
    }

    public User(String password, String login) {
        this.password = password;
        this.login = login;
    }

    abstract void logIn(String login);
    abstract void setPassword(String password);
}
