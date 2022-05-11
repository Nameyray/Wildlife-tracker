import models.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


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

        //getting sightings details
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            SightingsDao sight = new SightingsDao();
            List<Sightings> list = sight.getAllSightings();
            model.put("model", list);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());




        //retrieving the normal animals form
        get("/form2", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving all animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            AnimalsDao animal = new AnimalsDao();
            List<Animals> list = animal.all();
            model.put("model1", list);
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        //retrieving all endangered
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
           EndangeredAnimalsDao endangered = new EndangeredAnimalsDao();
            List<EndangeredAnimals> list = endangered.getEndangered();
            model.put("model2", list);
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());


        //retrieving the endangered animals form
        get("/form3", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered-form.hbs");
        }, new HandlebarsTemplateEngine());


