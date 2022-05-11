package models;

import java.util.List;

public interface EndangeredAnimalsInterface {
    void addAnimals(EndangeredAnimals en);
    EndangeredAnimals getAnimalById (int id);
    List<EndangeredAnimals> getAllAnimals();
    List<EndangeredAnimals> getEndangered();

}
