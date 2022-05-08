import models.Animals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalsTest {
    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy","Endangered","08/5/2022");
        assertEquals(true, testAnimal instanceof Animals);
    }
}
