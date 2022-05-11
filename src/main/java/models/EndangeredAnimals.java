package models;

import org.sql2o.Connection;

import java.util.Objects;

public class EndangeredAnimals extends Animals {
    public String health;
    public String age;

    public EndangeredAnimals(String name, String health, String age) {
        super(name);
        this.health = health;
        this.age = age;
        this.type= "Endangered";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EndangeredAnimals that = (EndangeredAnimals) o;
        return Objects.equals(health, that.health) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), health, age);
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}