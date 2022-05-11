package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class EndangeredAnimalsDao implements EndangeredAnimalsInterface{
    @Override
    public void addAnimals(EndangeredAnimals en) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,type, age, health) VALUES (:name, :type, :age, :health)";
            en.id = (int) con.createQuery(sql, true)
                    .addParameter("name", en.name)
                    .addParameter("type", en.type)
                    .addParameter("health", en.health)
                    .addParameter("age", en.age)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException ex) {
            System.out.println(ex); //"oops "we have an error!
        }
    }


    @Override
    public EndangeredAnimals getAnimalById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE id = :id ")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(EndangeredAnimals.class); //fetch an individual item
        }
    }

    @Override
    public List<EndangeredAnimals> getAllAnimals() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals") //raw sql
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimals.class); //fetch a list
        }
    }
}
