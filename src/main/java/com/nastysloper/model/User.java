package com.nastysloper.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class User {

    private long id;
    private String name;
    private String email;
    private String image;

    public User() {};

    public User(long id, String name, String email, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setImage(String image) { this.image = image; }

    public String getImage() { return this.image; }

    public int hashCode() {
        return Math.toIntExact(this.getId());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (this == null || this.getClass() != other.getClass()) {
            return false;
        }
        User user = (User) other;
        return (this.getId() == user.getId() && this.getName().equals(user.getName()));
    }
}
