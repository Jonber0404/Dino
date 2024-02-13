package models;

import utilities.FoodType;

import java.util.Objects;

public abstract class Dinosaur {
    private final String name;
    private final boolean herbivore;
    private final boolean carnivore;
    private final boolean omnivore;
    private int energy = 100;

    public Dinosaur(String name, boolean herbivore, boolean carnivore, boolean omnivore) {
        this.name = name;
        this.herbivore = herbivore;
        this.carnivore = carnivore;
        this.omnivore = omnivore;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * Simulates eating. Will gain or lose energy
     * depending on diet and type of food
     * consumed.
     *
     * @param food - Of the class utilities.FoodType.
     */
    public void eat(FoodType food) {
        if (herbivore) {
            if (food == FoodType.MEAT) {
                energy = energy - 25;
            } else if (food == FoodType.PLANT) {
                energy = energy + 25;
            }
        } else if (carnivore) {
            if (food == FoodType.MEAT) {
                energy = energy + 25;
            } else if (food == FoodType.PLANT) {
                energy = energy - 25;
            }
        } else if (omnivore) {
            if (food == FoodType.MEAT || food == FoodType.PLANT) {
                energy = energy + 25;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinosaur dinosaur)) return false;
        return herbivore == dinosaur.herbivore && carnivore == dinosaur.carnivore && omnivore == dinosaur.omnivore && getEnergy() == dinosaur.getEnergy() && Objects.equals(name, dinosaur.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, herbivore, carnivore, omnivore, getEnergy());
    }

    public String getName() {
        return name;
    }

    public boolean isHerbivore() {
        return herbivore;
    }

    public boolean isCarnivore() {
        return carnivore;
    }

    public boolean isOmnivore() {
        return omnivore;
    }
}
