
package dao;

import models.Animals;
import java.util.List;

public interface AnimalDao {

    List<Animals> all();

    void save();

}