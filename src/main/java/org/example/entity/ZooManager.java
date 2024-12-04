package org.example.entity;

import org.example.actions.IZooAction;

import java.util.ArrayList;
import java.util.List;

public class ZooManager {
    private List<Animal> zooAnimals;
    private List<Enclosure> zooEnclosures;

    public ZooManager() {
        this.zooAnimals = new ArrayList<>();
        this.zooEnclosures = new ArrayList<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        zooEnclosures.add(enclosure);
        System.out.println("Enclos " + enclosure.getName() + " ajouté au zoo.");
    }

    public void addAnimalToEnclosure(Animal animal, Enclosure enclosure) {
        if (zooEnclosures.contains(enclosure)) {
            enclosure.addAnimal(animal);
            zooAnimals.add(animal);
        } else {
            System.out.println("Enclos non trouvé !");
        }
    }

    public void listAllAnimals() {
        if (zooAnimals.isEmpty()) {
            System.out.println("Aucun animal");
            return;
        }
        System.out.println("Liste de tous les animaux dans le zoo :");
        zooAnimals.forEach(System.out::println);
    }

    public void listAnimalsByEnclosure() {
        if (zooEnclosures.isEmpty()) {
            System.out.println("Aucun enclos");
            return;
        } else if (zooAnimals.isEmpty()) {
            System.out.println("Aucun animal");
            return;
        }
        for (Enclosure enclosure : zooEnclosures) {
            enclosure.listAnimals();
        }
    }

    public Enclosure findEnclosureById(int id) {
        for (Enclosure enclosure : zooEnclosures) {
            if (enclosure.getId() == id) {
                return enclosure;
            }
        }
        return null;
    }

    public int listAllEnclosures() {
        if (zooEnclosures.isEmpty()) {
            System.out.println("Aucun enclos disponible.");
            return 0;
        } else {
            zooEnclosures.forEach(enclosure ->
                    System.out.println(enclosure.getId() + ": " + enclosure.getName())
            );
            return zooEnclosures.size();
        }
    }

    public void feedAllAnimals() {
        IZooAction feedAction = new IZooAction() {
            @Override
            public void action() {
                if (zooAnimals == null || zooAnimals.isEmpty()) {
                    System.out.println("Aucun animal à nourrir.");
                    return;
                }
                System.out.println("Nourrissage des animaux en cours...");
                for (Animal animal : zooAnimals) {
                    System.out.println(animal.eat());
                }
                System.out.println("Tous les animaux ont été nourris !");
            }
        };
        feedAction.action();
    }
}
