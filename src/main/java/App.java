import models.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;


public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args) {
        staticFileLocation("/public");
        //getting the home path
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //Routing the Sightings form
        get("/form1", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());


        //retrieving the normal animals form
        get("/form2", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());


        //retrieving the endangered animals form
        get("/form3", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered-form.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
//        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";      //connect to todolist, not todolist_test!
//        Sql2o sql2o = new Sql2o(connectionString, "rachael", "cravings");
//        sql2oAnimalsDao AnimalsDao = new sql2oAnimalsDao(sql2o);
//        sql2oSightingsDao SightingsDao = new sql2oSightingsDao(sql2o);
//
//
//        //retrieving new animal form
//        get("/animals/new", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "animal-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        // posting animals form details
//        post("animals", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String name = request.queryParams("name");
//            try {
//                Animals animals = new Animals(name) {
//
//                    @Override
//                    public void save() {
//
//                    }
//                };
////                animals.save();
//            } catch (IllegalArgumentException exception) {
//                System.out.println("Please enter an animals name.");
//            }
//            response.redirect("/animals");
//            return null;
//        }, new HandlebarsTemplateEngine());
//
//        //retrieving all animals
//        get("/animals", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
////            model.put("animals", Animals.all());
//            model.put("template", "templates/animal.hbs");
//            return new ModelAndView(model, "animal.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
////route for the endangered form
//        get("/endangered/new", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "endangered-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
//        //posting endangered animal form details
//        post("/endangered", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String name = request.queryParams("name");
//            String health = request.queryParams("health");
//            String age = request.queryParams("age");
//            EndangeredAnimals endangeredAnimals = new EndangeredAnimals(name, health, age);
//            endangeredAnimals.save();
//            response.redirect("/");
//            return new ModelAndView(model, "animal.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
////route for the sighting form
//        get("/sightings/new", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "sighting-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //posting a sighting form details
//        post("/sightings", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            int animal_id = Integer.parseInt(request.queryParams("animal"));
//            String location = request.queryParams("location");
//            String rangerName = request.queryParams("rangerName");
//            response.redirect("/");
//            return new ModelAndView(model, "sightings.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //retrieving all sightings
//        get("/sightings", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("sightings", Sightings.all());
//            model.put("Animals", Animals.class);
//            model.put("template", "templates/sightings.hbs");
//            return new ModelAndView(model, "sightings.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //retrieving animals by id
//        get("/animals/:id", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("animals", Animals.find(Integer.parseInt(request.params(":id"))));
//            model.put("endangered", EndangeredAnimals.find(Integer.parseInt(request.params(":id"))));
//            model.put("Sighting", Sightings.class);
//            model.put("template", "templates/animal.hbs");
//            return new ModelAndView(model, "animals.hbs");
//        }, new HandlebarsTemplateEngine());
//    }
//
//




//        get("/animal/new", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "animal-form.hbs");
//        }, new HandlebarsTemplateEngine());

//        get("/animals", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("animals",models.Animals.all());
//            return new ModelAndView(model, "animal.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/animals", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String name = request.queryParams("name");
//            String ranger = request.queryParams("ranger");
//            String age = request.queryParams("age");
//            String location = request.queryParams("location");
//            String health = request.queryParams("health");
//            String status = request.queryParams("status");
//            String spottime = request.queryParams("spottime");
//            Animals newAnimal = new Animals(name, ranger, age, location, health, status, spottime);
//            response.redirect("/animals");
//            return null;
//        }, new HandlebarsTemplateEngine());
//    }
//
//
////

