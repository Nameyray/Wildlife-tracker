package models;

import java.util.List;

public interface AnimalsInterface {
    //create animal
    void addAnimals(Animals animals);

    //Read
    Animals getAnimalsById(int id);
    List<Animals> all();

}
