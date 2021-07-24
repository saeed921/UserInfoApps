package com.example.userinfoapp;

public class Info {


    String name, email,pass;

    public Info(String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
    }
   public Info(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
