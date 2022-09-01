package com.revature.entity;

public class Employee {
    private int id;
    private String name;
    private String userName;
    private String password;

    private String title ;

    public Employee(){

    }
    public Employee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public Employee(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public Employee(int id, String name, String password, String title) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                '}';
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
