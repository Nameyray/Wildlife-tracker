
package dao;

import models.Animals;
import java.util.List;

public interface AnimalDao {

    List<Animals> getAllAnimals();

    void addAnimals(models.Animals animals);

    models.Animals findAnimalsById(int id);

    void deleteAnimalsById( int id);

    void deleteAllAnimals();
}
