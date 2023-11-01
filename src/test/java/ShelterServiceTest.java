import org.example.model.Animal;
import org.example.services.ShelterService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShelterServiceTest {
    private final ShelterService shelter = new ShelterService();
    @Test
    public void addAndReturnAnimalsFromList() {
        shelter.add(new Animal("Dog", "Arche", "12", "120"));
        shelter.add(new Animal("Pig", "Marta", "14", "200"));
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog", "Arche", "12", "120"));
        animals.add(new Animal("Pig", "Marta", "14", "200"));
        Assert.assertEquals(animals, shelter.findAll());
    }

    @Test
    public void removeAnimalFromList() {
        shelter.add(new Animal("Dog", "Arche", "12", "120"));
        shelter.add(new Animal("Pig", "Marta", "14", "200"));

        shelter.findOneAndDelete("Arche");

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Pig", "Marta", "14", "200"));
        Assert.assertEquals(animals, shelter.findAll());
    }
}
