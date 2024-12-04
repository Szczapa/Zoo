package org.example.console;

import org.example.entity.Animal;
import org.example.entity.Bird;
import org.example.entity.Mammal;
import org.example.entity.Enclosure;
import org.example.entity.ZooManager;

import java.util.Scanner;

public class ConsoleMenu {
    private final ZooManager zooManager;

    public ConsoleMenu() {
        this.zooManager = new ZooManager();
    }

    public void startMenu(Scanner scanner) {
        Menu menu = new Menu();
        boolean running = true;
        while (running) {
            menu.menuPrincipale();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addAnimal(scanner);
                    break;
                case 2:
                    listAnimals(scanner);
                    break;
                case 3:
                    feedAnimals();
                    break;
                case 4:
                    addEnclosure(scanner);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }

    private void addAnimal(Scanner scanner) {
        System.out.println("\n");
        System.out.println("Ajout d'un animal :");
        System.out.print("Entrez le nom de l'animal : ");
        String name = scanner.nextLine();
        System.out.print("Entrez l'espèce (Mammal/Bird) : ");
        String species = scanner.nextLine();
        Animal animal;
        if (species.equalsIgnoreCase("Mammal")) {
            animal = new Mammal(name, "Mammifère");
        } else if (species.equalsIgnoreCase("Bird")) {
            animal = new Bird(name, "Oiseau");
        } else {
            System.out.println("Espèce invalide, retour au menu principal.");
            return;
        }

        System.out.println("Choisissez un enclos pour cet animal :");


        if (zooManager.listAllEnclosures() == 0) return;

        System.out.print("Entrez l'ID de l'enclos : ");
        int enclosureId = scanner.nextInt();
        scanner.nextLine();

        Enclosure enclosure = zooManager.findEnclosureById(enclosureId);
        if (enclosure != null) {
            zooManager.addAnimalToEnclosure(animal, enclosure);
            System.out.println("Animal ajouté avec succès !");
        } else {
            System.out.println("Enclos introuvable.");
        }
    }

    private void listAnimals(Scanner scanner) {
        System.out.println("\n");
        System.out.println("Lister les animaux :");
        System.out.println("1. Tous les animaux");
        System.out.println("2. Par enclos");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            zooManager.listAllAnimals();
        } else if (choice == 2) {
            zooManager.listAnimalsByEnclosure();
        } else {
            System.out.println("Choix invalide.");
        }
    }

    private void feedAnimals() {
        System.out.println("\n");
        System.out.println("Nourrir tous les animaux :");
        zooManager.feedAllAnimals();
    }

    private void addEnclosure(Scanner scanner) {
        System.out.println("\n");
        System.out.println("Ajout d'un enclosure :");
        System.out.print("Entrez le nom de l'enclosure : ");
        String name = scanner.nextLine();
        zooManager.addEnclosure(new Enclosure(name));
    }
}
