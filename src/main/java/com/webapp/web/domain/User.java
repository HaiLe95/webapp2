package com.webapp.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String login;

    @Column
    private String fName;

    @Column
    private String lName;

    public User() {}

    public User(String login, String fName, String lName) {
        this.login = login;
        this.fName = fName;
        this.lName = lName;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }
    public String getlName() { return lName; }
    public void setlName(String lName) { this.lName = lName; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("User:");
        stringBuilder.append("\n" + fName + " " + lName);
        stringBuilder.append("\n" + login);
        return  stringBuilder.toString();
    }
}
