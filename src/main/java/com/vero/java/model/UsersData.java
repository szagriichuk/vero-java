package com.vero.java.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author szagriichuk.
 */
public class UsersData extends StringData {
    @JsonIgnore
    private  final String email = "email";
    @JsonIgnore
    private String firstname = "firstname";
    @JsonIgnore
    private String lastname = "lastname";

    public void setEmail(String email) {
        add(this.email, firstname);
    }

    public String getEmail() {
        return get(email);
    }

    public String getFirstname() {
        return get(firstname);
    }

    public void setFirstname(String firstname) {
        add(this.firstname, firstname);
    }

    public String getLastname() {
        return get(lastname);
    }

    public void setLastname(String lastname) {
        add(this.lastname, lastname);
    }
}
