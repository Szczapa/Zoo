package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private static int counter = 1;
    private final int id;
    private String name;
    private List<Animal> animals;

    public Enclosure(String name) {
        this.id = counter++;
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " ajouté à l'enclos " + name + ".");
    }

    public void removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println(animal.getName() + " retiré de l'enclos " + name + ".");
        } else {
            System.out.println(animal.getName() + " n'est pas présent dans cet enclos.");
        }
    }

    public void listAnimals() {
        System.out.println("Animaux dans l'enclos " + name + " :");
        if (animals.isEmpty()) {
            System.out.println("Aucun animal dans cet enclos.");
        } else {
            animals.forEach(System.out::println);
        }
    }
}
