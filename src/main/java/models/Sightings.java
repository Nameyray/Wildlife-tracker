package models;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Objects;

public class Sightings {
    public int id;
    public String animalName;
    public String location;
    public String rangerName;
    public Timestamp timestamp;
    public String sightTime;

    public String getSightTime() {
        sightTime = DateFormat.getDateTimeInstance().format(timestamp);
        return sightTime;
    }

    public void setSightTime(String sightTime) {
        this.sightTime = sightTime;
    }

    public Sightings(String animalName, String location, String rangerName) {
        this.animalName = animalName;
        this.location = location;
        this.rangerName = rangerName;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return id == sightings.id && Objects.equals(animalName, sightings.animalName) && Objects.equals(location, sightings.location) && Objects.equals(rangerName, sightings.rangerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalName, location, rangerName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}