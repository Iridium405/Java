package com.lukerau;

public class User {
    private String name;
    private String password;
    private boolean passwordCorrect;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPasswordCorrect(String checkedPassword) {
        if (checkedPassword.equals(this.password)){
            return passwordCorrect;
        } else {
            return false;
        }
    }
}
