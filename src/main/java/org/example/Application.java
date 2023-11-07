package org.example;

import org.example.services.ApplicationMenuService;
import org.myLib.Console;

public class Application {
    public static void run() {
        boolean isExit = false;
        ApplicationMenuService applicationMenuService = new ApplicationMenuService();

        while (!isExit) {
            System.out.println("Shelter " + "\"Sun\"");
            System.out.println("1. Add pet");
            System.out.println("2. Show all");
            System.out.println("3. Take pet from shelter");
            System.out.println("4. Upload data from previous session");
            System.out.println("5. Exit");
            System.out.print("Choose an action: ");

            switch (Console.write()) {
                case "1" -> applicationMenuService.addAnimal();
                case "2" -> applicationMenuService.findAllAnimals();
                case "3" -> applicationMenuService.deleteAnimal();
                case "4" -> applicationMenuService.unloadAnimal();
                case "5" -> isExit = applicationMenuService.exit();
                default -> {
                    // Works only in Windows (cmd)
                    Console.clear();
                    System.err.println("This menu item does not exist!");
                    Console.waitFor(3000);
                }
            }
        }
    }
}
