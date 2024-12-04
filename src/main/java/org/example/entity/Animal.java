package org.example.entity;

public abstract class Animal {
    private static int counter = 1;
    private final int id;
    private String name;
    private String species;

    public Animal(String name, String species) {
        this.id = counter++;
        this.name = name;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public abstract String eat();

    @Override
    public String toString() {
        return String.format("%d: %s (%s)", id, name, species);
    }
}
