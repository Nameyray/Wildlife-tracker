package models;

import org.sql2o.Connection;

public class EndangeredAnimals extends Animals {
    private String health;
    private String age;
    public static final String ANIMAL_TYPE = "Endangered";

    // constructor with animals name and new attributes for endangered animals: health and age
    public EndangeredAnimals(String name, String health, String age) {
        super(name);
        if (name.equals("") || health.equals("") || age.equals("")){
            throw new IllegalArgumentException("Please enter data on all inputs.");
        }
        this.health = health;
        this.age = age;
        type = ANIMAL_TYPE;
    }
    //getters and setters the for endangered animals properties
    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public void setHealth(String health) {
        this.health = health;
    }
    public void setAge(String age) {
        this.age = age;
    }
//overriding the endangered animals
    @Override
    public boolean equals(Object o) {
        if (o instanceof EndangeredAnimals) {
            EndangeredAnimals newEndangeredAnimal = (EndangeredAnimals) o;
            return (this.getName().equals(newEndangeredAnimal.getName()));
        }
        return false;
    }

    //Overriding save in animal class for  endangered  class
    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, health, age, type) VALUES (:name, :health, :age, :type)";
            this.id= (int) con.createQuery(sql, true)
                    .addParameter("name", name)
                    .addParameter("health", health)
                    .addParameter("age", age)
                    .addParameter("type", type)
                    .executeUpdate()
                    .getKey();
        }
    }

    // finding endangered animal with a static type that will apply to animal class too
    public static EndangeredAnimals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimals.class);
        }
    }

}
