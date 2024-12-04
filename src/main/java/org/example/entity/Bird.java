package org.example.entity;

public class Bird extends Animal {

    public Bird(String name, String species) {
        super(name, species);
    }

    @Override
    public String eat() {
        return getName() + " mange des graines.";
    }
}