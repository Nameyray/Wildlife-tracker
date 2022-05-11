import models.Animals;
import models.EndangeredAnimals;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalsTest {


    public Animals setUpAnimals(){
        return new Animals('1', "Lion");
    }
    public Animals setUpEndangeredAnimals(){
        return new EndangeredAnimals("Lion", "Healthy", "Young");
    }


    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals("lion");
        assertEquals(true, testAnimal instanceof Animals);
    }

    @Test
    public void getName_animalsInstantiatesWithName_String() {
        Animals testAnimal = new Animals("Lion");
        assertEquals("Lion", testAnimal.getName());
    }
    @Test
    public void getId_animalInstantiatesWithId(){
        Animals testAnimal = new Animals('1', "Lion");
        assertTrue(testAnimal.getId() > 0);
    }
    @Test
    public void getType_animalInstantiatesWithType_Type() {
        Animals testAnimal = new Animals("Lion");
        assertEquals("Non-endangered", testAnimal.getType());
    }
    @Test
    public void equals_returnsTrueIfNamesAreTheSame() {
        Animals testAnimal = new Animals("Lion");
        Animals anotherAnimal = new Animals("Lion");
        assertTrue(testAnimal.equals(anotherAnimal));
    }
    @Test
    public void getAge_animalInstantiatesWithHealth_Healthy() {
        EndangeredAnimals testEndangeredAnimal = new EndangeredAnimals("Lion", "Healthy", "Young");
        assertEquals("Young", testEndangeredAnimal.getAge());
    }
    @Test
    public void getAge_animalInstantiatesWithAge_Young() {
        EndangeredAnimals testEndangeredAnimal = new EndangeredAnimals("Lion", "Healthy", "Young");
        assertEquals("Young", testEndangeredAnimal.getAge());
    }
//    @Test
//    public void save_assignsIdToObject() {
//        Animals testAnimal= new Animals("Lion");
//        Animals savedAnimal = Animals.all().get(0);
//        assertEquals(testAnimal.getId(), savedAnimal.getId());
//    }
//
//    @Test
//    public void save_insertsObjectIntoDatabase() {
//        Animals testAnimal = new Animals("Lion");
//        testAnimal.save();
//        assertTrue(Animals.all().get(0).equals(testAnimal));
//    }
//
//    @Test
//    public void all_returnsAllInstancesOfAnimal_false() {
//        Animals testAnimal = new Animals("Lion");
//        Animals otherAnimal = new Animals("Deer");;
//        otherAnimal.save();
//        assertEquals(true, Animals.all().get(0).equals(testAnimal));
//        assertEquals(true, Animals.all().get(1).equals(otherAnimal));
//    }

}
//    @Test
//    public void animal_instantiatesCorrectly_true() {
//        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy","Endangered","08/5/2022");
//        assertEquals(true, testAnimal instanceof Animals);
//    }
//    @Test
//    public void Animal_instantiatesWithName_String() {
//        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy","Endangered","08/5/2022");
//        assertEquals("Lion", testAnimal.getName());
//    }
//
//   @Test
//    public void Animal_instantiatesWithAge_String() {
//        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy","Endangered","08/5/2022");
//        assertEquals("adult", testAnimal.getAge());
//    }
//
//    @Test
//    public void Animal_instantiatesWithlocation_String() {
//        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
//        assertEquals("West", testAnimal.getLocation());
//    }
//
//    @Test
//    public void Animal_instantiatesWithRanger_String() {
//        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
//        assertEquals("Rachel", testAnimal.getRanger());
//    }
//
//    @Test
//    public void Animal_instantiatesWithHealth_String() {
//        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
//        assertEquals("Healthy", testAnimal.getHealth());
//    }
//
//    @Test
//    public void Animal_instantiatesWithStatus_String() {
//        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
//        assertEquals("Endangered", testAnimal.getStatus());
//    }
//
//    @Test
//    public void Animal_instantiatesWithSpottime_String() {
//        Animals testAnimal = new Animals("Lion", "Rachel","adult","West", "Healthy", "Endangered", "08/5/2022");
//        assertEquals("08/5/2022", testAnimal.getSpottime());
//    }
//
////    @Test
////    public void save_assignsIdToAnimal() {
////        Animals animal = setUpAnimal();
////        animal.save();
////        Animals savedAnimal = Animals.all().get(0);
////        assertEquals(savedAnimal.getId(), animal.getId());
////    }
//}
