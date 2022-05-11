package models;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

import static junit.runner.Version.id;

public class sql2oSightingsDao implements SightingsDao{
    private Sql2o sql2o;

    public sql2oSightingsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


//adding a new sighting
    @Override
    public void addSightings (Sightings sightings) {
        getDrivers();
        String sql = "INSERT INTO sightings(animals_id, location, rangerName, timestamp) VALUES (:animals_id, :location, :rangerName, :timestamp)";
        try(Connection con = sql2o.open()){
            int Id = (int) con.createQuery(sql, true)
                    .bind(id())
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }
//listing all sightings
    @Override
    public List<Sightings> getAllSightings() {
        getDrivers();
        try(Connection con = sql2o.open()){
            return con.createQuery(" SELECT * FROM sightings")
                    .executeAndFetch(Sightings.class);
        }
    }
//listing sighting by animals id
    @Override
    public List<Sightings> allByAnimal(int animalId) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE animal_id = :animalId ORDER BY timestamp DESC";
            return con.createQuery(sql)
                    .addParameter("animalId", animalId)
                    .executeAndFetch(Sightings.class);
        }
    }


}
