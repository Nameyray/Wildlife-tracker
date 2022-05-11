package models;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

import static junit.runner.Version.id;

public class SightingsDao implements SightingsInterface {
    @Override
    public void addSightings(Sightings Sightings) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings(animalname,location, rangername, timestamp) VALUES (:animalName, :location, :rangerName, now())";
            Sightings.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName",Sightings.animalName)
                    .addParameter("location", Sightings.location)
                    .addParameter("rangerName", Sightings.rangerName)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException ex) {
            System.out.println(ex); //"oops "we have an error!
        }

    }


    @Override
    public List<Sightings> getAllSightings() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings ")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sightings.class); //fetch an individual item
        }

    }

    @Override
    public Sightings getSightingsById(int sightId) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE id = :id ")
                    .addParameter("id", sightId) //key/value pair, key must match above
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Sightings.class);//fetch an individual item
        }

    }
}