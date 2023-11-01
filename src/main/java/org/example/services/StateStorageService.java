package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StateStorageService {
    private List<Animal> animals;
    private final ObjectMapper mapper = new JsonMapper();
    private final File storing = new File("src/main/resources/animals.json");

    public StateStorageService(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> unload() {
        CollectionType animal = mapper.getTypeFactory().constructCollectionType(List.class, Animal.class);
        try {
            this.animals = mapper.readValue(storing, animal);
        } catch (IOException ex) {
            System.err.println("The save file does not exist, save the data before you start uploading the data!");
            ex.printStackTrace();
            System.exit(1);
        }
        return animals;
    }

    public void save() {
        try {
            if (!storing.exists()) storing.createNewFile();
            mapper.writeValue(storing, animals);
        } catch (IOException ex) {
            System.err.println("Cannot save the animals!");
            ex.printStackTrace();
        }
    }
}
