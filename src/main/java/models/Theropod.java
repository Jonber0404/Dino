package models;


import utilities.FoodType;

import java.util.Objects;

public class Theropod extends Dinosaur {
    private int agility; // agility points

    public Theropod(String name, boolean herbivore, boolean carnivore, boolean omnivore, int agility) {
        super(name, herbivore, carnivore, omnivore);
        this.agility = agility;
        if (herbivore || omnivore) {
            throw new IllegalArgumentException("Theropods can only be carnivores");
        }
    }

    /**
     * Simulates hunting for prey. Consumes energy.
     */
    public void hunt() {
        if (getEnergy() > 10) {
            setEnergy(getEnergy() - 10);
            System.out.println(getName() + " hunts for prey.");
        } else {
            System.out.println(getName() + " doesn't have enough energy to hunt.");
        }
    }

    /**
     * Simulates sleeping. The longer it sleeps, the
     * more energy it regains. Ensures energy is
     * always below or equal to 100.
     *
     * @param hours amount of time it sleeps.
     */

    public void sleep(int hours) {
        setEnergy(Math.min(getEnergy() + (7 * hours), 100));
    }

    /**
     * Override the eat method to specify the behavior
     * of a Theropod when consuming food.
     *
     * @param food - Of the class utilities.FoodType.
     */
    @Override
    public void eat(FoodType food) {
        if (food == FoodType.MEAT) {
            setEnergy(getEnergy() + 30);
        } else {
            System.out.println(getName() + " cannot eat plants.");
        }
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public String toString() {
        return "Theropod name: " + getName() +
                "\nEats: " + "Meat" +
                "\nAgility: " + agility +
                "\nEnergy: " + getEnergy();
    }
}