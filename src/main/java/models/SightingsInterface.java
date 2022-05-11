package models;

import java.util.List;

public interface SightingsInterface {
    void addSightings(Sightings Sightings);

    //Read

    List<Sightings> getAllSightings();
    Sightings getSightingsById(int sightId);


}
