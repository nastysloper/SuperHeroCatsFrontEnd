package com.nastysloper.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="CAT")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CAT_NAME", nullable = false)
    private String name;

    @Column(name = "POWER")
    private String power;

    @Column(name = "WEAKNESS")
    private String weakness;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "BIRTHDAY")
    private Date birthday;

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

    public void setBirthday(Date date) {
        this.birthday = date;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1 + Math.toIntExact(id);
        result = prime * result;
        return result;
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
