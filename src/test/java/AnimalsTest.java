import models.Animals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalsTest {
    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy","Endangered","08/5/2022");
        assertEquals(true, testAnimal instanceof Animals);
    }
//    public Animals setUpAnimal(){
//        return new Animals("Lion", "Rachel","adult","West", "Healthy","Endangered","08/5/2022");
//    }
    @Test
    public void Animal_instantiatesWithName_String() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy","Endangered","08/5/2022");
        assertEquals("Lion", testAnimal.getName());
    }

    @Test
    public void Animal_instantiatesWithAge_String() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy","Endangered","08/5/2022");
        assertEquals("adult", testAnimal.getAge());
    }

    @Test
    public void Animal_instantiatesWithlocation_String() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
        assertEquals("West", testAnimal.getLocation());
    }

    @Test
    public void Animal_instantiatesWithRanger_String() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
        assertEquals("Rachel", testAnimal.getRanger());
    }

    @Test
    public void Animal_instantiatesWithHealth_String() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
        assertEquals("Healthy", testAnimal.getHealth());
    }

    @Test
    public void Animal_instantiatesWithStatus_String() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
        assertEquals("Endangered", testAnimal.getStatus());
    }

    @Test
    public void Animal_instantiatesWithSpottime_String() {
        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
        assertEquals("08/5/2022", testAnimal.getSpottime());
    }

//    @Test
//    public void save_assignsIdToAnimal() {
//        Animals animal = setUpAnimal();
//        animal.save();
//        Animals savedAnimal = Animals.all().get(0);
//        assertEquals(savedAnimal.getId(), animal.getId());
//    }
}
