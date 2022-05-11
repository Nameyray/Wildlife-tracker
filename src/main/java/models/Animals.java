package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public abstract class Animals {
    //Animal properties
    public int id;
    public String name;
    public String type;

    public static List<Animals> all(){
        String sql = "SELECT * FROM animals;";

        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animals.class);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //creating animals with constant a non-endangered
    public static final String ANIMAL_TYPE = "Non-endangered";

    public Animals(String name){
        if (name.equals("")){
            //throw exception if no name is inputted
            throw new IllegalArgumentException("Please enter an animals name");
        }
        this.name = name;

        type = ANIMAL_TYPE;
    }
//getter and setters for the animals properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //constructor for the animals properties
    public Animals(int id, String name ) {
        this.id = id;
        this.name = name;
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

    //Overriding save in animal class for  endangered  class
    public void save() {

    }


    //saving a new animal by their name and type ie if endangered
//    public void save() {
//        String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
//        try(Connection con = sql2o.open()) {
//            this.id = (int) con.createQuery(sql, true)
//                    .addParameter("name", name)
//                    .addParameter("type", type)
//                    .throwOnMappingFailure(false)
//                    .executeUpdate()
//                    .getKey();
//        }
//    }
//
//    //Listing all animals from animals table
//    public static List<Animals> all() {
//        String sql = "SELECT * FROM animals;";
//
//        try (Connection con = DB.sql2o.open()) {
//            return con.createQuery(sql)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(Animals.class);
//        }
//    }
//    //finding an animal using its id && throwing  exception incase the id is not mapped
//    public static Animals find(int id) {
//        String sql = "SELECT * FROM animals WHERE id = :id;";
//
//        try (Connection con = DB.sql2o.open()) {
//            return con.createQuery(sql)
//                    .addParameter("id", id)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetchFirst(Animals.class);
//        }
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if( o == null || getClass() != o.getClass()) return false;
//        Animals animals = (Animals) o;
//        return name == animals.name && age.equals(animals.age) && ranger.equals(animals.ranger) && location.equals(animals.location) && health.equals(animals.health) && status.equals(animals.status) && spottime.equals(animals.status);
//    }
//

//
//    public static List<Animals> all() {
//        String sql = "SELECT name, ranger, age, location, health, status, spottime FROM animals";
//        try (Connection con = DB.sql2o.open()) {
//            return con.createQuery(sql).executeAndFetch(Animals.class);
//        }
//    }
//    public void save() {
//        try (Connection con = DB.sql2o.open()) {
//            String sql = "INSERT INTO animals (name, ranger, age, location, health, status, spottime, id) VALUES (:name, :ranger, :age, :location, :health, :status, spottime, id)";
//            this.id = (int) con.createQuery(sql, true)
//                    .addParameter("name", this.name)
//                    .addParameter("id", this.id)
////                    .addParameter("ranger", this.ranger)
////                    .addParameter("age", this.age)
////                    .addParameter("location", this.location)
////                    .addParameter("health", this.health)
////                    .addParameter("status", this.status)
////                    .addParameter("spottime", this.spottime)
//
//                    .executeUpdate()
//                    .getKey();
//        }
//    }
//
    public static Animals find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animals animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animals.class);
            return animal;
        }
    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getRanger() {
//        return ranger;
//    }
//
//    public void setRanger(String ranger) {
//        this.ranger = ranger;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getHealth() {
//        return health;
//    }
//
//    public void setHealth(String health) {
//        this.health = health;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getSpottime() {
//        return spottime;
//    }
//
//    public void setSpottime(String spottime) {
//        this.spottime = spottime;
//    }
//


}
