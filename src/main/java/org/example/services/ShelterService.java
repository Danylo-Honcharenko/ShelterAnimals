package org.example.services;

import org.example.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class ShelterService {

    private List<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void addList(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> findAll() {
        return animals;
    }

    public void findOneAndDelete(final String name) {
        animals.removeIf(a -> a.getName().equals(name));
    }
}
