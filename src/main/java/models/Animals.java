package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animals {
    //Animal properties
    public int id;
    public String name;
    public  String type;

    public Animals(String name){
        if (name.equals("")){
            //throw exception if no name is inputted
            throw new IllegalArgumentException("Please enter an animals name");
        }
        this.name = name;

        type = "normalAnimal";
    }


//overriding the Animals
    @Override
    public boolean equals(Object o) {
        if (o instanceof Animals) {
            Animals newAnimals = (Animals) o;
            return (this.getName().equals(newAnimals.getName()));
        }

        return false;
    }
        @Override
    public int hashCode() {return Objects.hash(name); }

    public int getAnimalId() {
        return id;
    }

    public void setAnimalId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
}
