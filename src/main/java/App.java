import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.staticFileLocation;


public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        get("/animal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());
    }

//    get("/animals", (request, response) -> {
//        Map<String, Object> model = new HashMap<>();
//        model.put("animals",Animals.all());
//        return new ModelAndView(model, "animals.hbs");
//    }, new HandlebarsTemplateEngine());
//


}
