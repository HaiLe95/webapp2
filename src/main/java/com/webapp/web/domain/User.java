package com.webapp.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String fName;

    @Column
    private String lName;

    @Column
    private int age;

    public User() {}

    public User(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }
    public String getlName() { return lName; }
    public void setlName(String lName) { this.lName = lName; }
    public int getAge() {return age;}
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("User:");
        stringBuilder.append("\n" + fName + " " + lName);
        stringBuilder.append("\n" + age);
        return  stringBuilder.toString();
    }
}
