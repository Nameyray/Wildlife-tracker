package models;


import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sightings {
    private int id;
    private int animals_id;
    private String location;
    private String rangerName;
    private Timestamp timestamp;

    // Generated a constructor for sightings that implements abstract method save in Database management class

    public Sightings(int animal_id, String location, String ranger_name) {
        if (ranger_name.equals("")) {
            throw new IllegalArgumentException("A Rangers name is needed");
        }
        this.animals_id = animals_id;
        this.location = location;
        this.rangerName = rangerName;

    }

//generated getters and setters for the sightings properties
    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimals_id() {
        return animals_id;
    }

    public void setAnimals_id(int animals_id) {
        this.animals_id = animals_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getTimeSpotted() {
        return String.format("%1$TD %1$TR", timestamp);
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public static List<Animals> all(){
        String sql = "SELECT * FROM sightings;";

        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animals.class);
        }
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Sightings)){
            return false;
        }else{
            Sightings newSightings = (Sightings) o;
            return this.getAnimals_id()==newSightings.getAnimals_id() && this.getRangerName().equals(newSightings.getRangerName());
        }
    }
    @Override
    public int hashCode() {return Objects.hash(animals_id, location, rangerName, timestamp); }

//    @Override
//    public void save() {
//        String sql = "INSERT INTO sightings (animals_id, location, rangerName, timestamp) VALUES (:animals_id, :location, :rangerName, now());";
//        System.out.println("INSERT INTO sightings (animals_id, location, rangerName, timestamp) VALUES (:animals_id, :location, :rangerName, now());");
//        try (Connection con = DB.sql2o.open()) {
//            this.id = (int) con.createQuery(sql, true)
//                    .addParameter("animal_id", this.animals_id)
//                    .addParameter("location", this.location)
//                    .addParameter("ranger_name", this.rangerName)
//                    .executeUpdate()
//                    .getKey();
//        }


//    //Listing all sightings from  sightings table
//    public static List<Sightings> all() {
//        String sql = "SELECT * FROM sightings ORDER BY timestamp DESC;";
//
//        try (Connection con = DB.sql2o.open()) {
//            return con.createQuery(sql)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(Sightings.class);
//        }
//    }
//
//    //Listing sighting by animal id
//    public static List<Sightings> allByAnimal(int animalId) {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "SELECT * FROM sightings WHERE animal_id = :animalId ORDER BY timestamp DESC";
//            return con.createQuery(sql)
//                    .addParameter("animalId", animalId)
//                    .executeAndFetch(Sightings.class);
//        }
//    }


}
