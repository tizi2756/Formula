package com.liu.mode;

public class Student {
    int id;
    String username;
    String password;
    String phone;
    public Student(int id,String username,String password,String phone){
        this.id=id;
        this.username=username;
        this.password=password;
        this.phone=phone;
    }
    public Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
