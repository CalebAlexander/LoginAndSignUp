package com.example.caleb_000.loginandsignup;

/**
 * Created by caleb_000 on 3/19/2017.
 *
 * Class that represents a user.
 * Has member variables:
 *  - id
 *  - Name
 *  - Email
 *  - Username
 *  - Password
 */

public class Contact {
    // Member variables
    //private int id;
    private String name, email, username, password;

    // Getters and Setters
//    public void setId(int id) {
//        this.id = id;
//    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

//    public int getId() {
//        return this.id;
//    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
}
