import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.model.Animal;
import org.example.services.StateStorageService;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateStorageServiceTest {
    private final ObjectMapper mapper = new JsonMapper();

    @Test
    public void save() {
        List<Animal> expected = new ArrayList<>();
        expected.add(new Animal("Dog", "Ben", "5", "30"));
        expected.add(new Animal("Cat", "Marta", "11", "12"));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog", "Ben", "5", "30"));
        animals.add(new Animal("Cat", "Marta", "11", "12"));

        List<Animal> actual = new ArrayList<>();

        new StateStorageService(animals).save();

        CollectionType animal = mapper.getTypeFactory().constructCollectionType(List.class, Animal.class);

        try {
            actual = mapper.readValue(new File("src/main/resources/animals.json"), animal);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void unload() {
        List<Animal> expected = new ArrayList<>();
        expected.add(new Animal("Dog", "Ben", "5", "30"));
        expected.add(new Animal("Cat", "Marta", "11", "12"));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog", "Ben", "5", "30"));
        animals.add(new Animal("Cat", "Marta", "11", "12"));

        StateStorageService storage = new StateStorageService(animals);
        storage.save();

        List<Animal> actual = storage.unload();

        Assert.assertEquals(actual, expected);
    }
}
