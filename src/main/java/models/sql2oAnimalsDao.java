//package models;
//
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//import org.sql2o.Sql2oException;
//
//import java.util.List;
//
//import static java.sql.DriverManager.getDrivers;
//import static junit.runner.Version.id;
//
//public class sql2oAnimalsDao implements AnimalsDao{
//    private Sql2o sql2o;
//
//    public sql2oAnimalsDao(Sql2o sql2o) {
//        this.sql2o = sql2o;
//    }
//    public void getDrivers(){
//        try{
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void addAnimals(Animals animals) {
//        getDrivers();
//        String sql = "INSERT INTO animals(name) VALUES (:name)";
//        try(Connection con = sql2o.open()){
//            int Id = (int) con.createQuery(sql, true)
//                    .bind(id())
//                    .executeUpdate()
//                    .getKey();
//        } catch (Sql2oException e){
//            System.out.println(e);
//        }
//
//    }
//
//    //finding an animal using its id && throwing  exception incase the id is not mapped
//    @Override
//    public Animals getAnimalsById(int id) {
//        getDrivers();
//        String sql = "SELECT * FROM animals WHERE id = :id;";
//
//        try (Connection con = sql2o.open()) {
//            return con.createQuery(sql)
//                    .addParameter("id", id)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetchFirst(Animals.class);
//        }
//    }
//
//    @Override
//    public List<Animals> all() {
//        String sql = "SELECT * FROM animals;";
//
//        try (Connection con = sql2o.open()) {
//            return con.createQuery(sql)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(Animals.class);
//        }
//    }
//
//}
