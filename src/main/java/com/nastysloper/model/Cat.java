package com.nastysloper.model;

public class Cat {

    private Long id;
    private String name;
    private String power;
    private String weakness;
    private String image;

    public Cat() {};

    public Cat(String name, String power, String weakness, String image) {
        this.name = name;
        this.power = power;
        this.weakness = weakness;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String email) {
        this.power = email;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
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
        Cat cat = (Cat) other;
        return (this.getId() == cat.getId() && this.getName().equals(cat.getName()));
    }
}
