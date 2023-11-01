package org.example.services;

import org.example.AutoSave;
import org.example.Console;
import org.example.model.Animal;

public class ApplicationMenuService {
    private final ShelterService shelter = new ShelterService();
    private final StateStorageService storage = new StateStorageService(shelter.findAll());
    private final AutoSave autoSave = new AutoSave(storage);
    private final Thread thread = new Thread(autoSave);

    public ApplicationMenuService() {
        thread.start();
    }

    public void addAnimal() {
        System.out.println("==============");
        System.out.println("Add animal");
        String animalType = Console.write("Type: ");
        String animalName = Console.write("Name: ");
        String animalAge = Console.write("Age: ");
        String animalWeight = Console.write("Weight: ");
        shelter.add(new Animal(animalType, animalName, animalAge, animalWeight));
    }

    public void findAllAnimals() {
        System.out.println("+---------- Animals -----------+");
        if (!shelter.findAll().isEmpty()) shelter.findAll().forEach(a -> System.out.println("Type: " + a.getType() + " Name: " + a.getName() + " Age: " + a.getAge() + " Weight: " + a.getWeight()));
        else System.out.println("No animals found!");
        System.out.println("+------------------------------+");
    }

    public void deleteAnimal() {
        if(!shelter.findAll().isEmpty()) {
            System.out.println("Delete animal");
            String animalName = Console.write("Animal name: ");
            shelter.findOneAndDelete(animalName);
        } else {
            System.out.println("============");
            System.out.println("Animal list is empty!");
            System.out.println("============");
        }
    }

    public void unloadAnimal() {
        shelter.updateList(storage.unload());
    }

    public boolean exit() {
        thread.interrupt();
        return true;
    }
}
