package com.vmorenomarin.contapp;

import android.provider.ContactsContract;

/**
 * Created by victor on 8/2/16.
 */

import java.util.Date;

public class Contact {
    private String  name;
    private String  birthday;
    private String  phone;
    private String  email;
    private String  description;

    public Contact(String name, String birthday, String  phone, String email, String description) {
        this.name       = name;
        this.birthday   = birthday;
        this.phone      = phone;
        this.email      = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String telefono) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}