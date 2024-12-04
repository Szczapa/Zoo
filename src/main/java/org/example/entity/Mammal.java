package org.example.entity;

public class Mammal extends Animal {

    public Mammal(String name, String species) {
        super(name, species);
    }

    @Override
    public String eat() {
        return getName() + " mange de la nourriture de mammifère.";
    }
}
