package models;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class AnimalsDao implements AnimalsInterface {
    private Sql2o sql2o;

    @Override
    public void addAnimals(Animals animals) {

        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,type) VALUES (:name, :type)";
            animals.id = (int) con.createQuery(sql, true)
                    .addParameter("name", animals.name)
                    .addParameter("type", animals.type)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException ex) {
            System.out.println(ex); //"oops "we have an error!
        }
    }

    @Override
    public Animals getAnimalsById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE id = :id ")
                    .addParameter("id", id) //key/value pair, key must match above
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animals.class); //fetch an individual item
        }
    }

    @Override
    public List<Animals> all() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals") //raw sql
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animals.class); //fetch a list
        }
    }


}