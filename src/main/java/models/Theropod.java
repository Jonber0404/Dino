package models;

import models.Dinosaur;

public class Theropod extends Dinosaur {
    private double huntingSpeed; // km/h
    private double weight; //kg
    private double clawLength; // cm

    public Theropod(String name, boolean herbivore, boolean carnivore, boolean omnivore, double neckLength, double walkingSpeed, int age) {
        super(name, herbivore, carnivore, omnivore);
        this.huntingSpeed = huntingSpeed;
        this.weight = weight;
        this.clawLength = clawLength;
        if(herbivore || omnivore) {
            throw new IllegalArgumentException("Theropods wants meat!");
        }
    }

    /**
     * Simulates killing a prey. Longer claws, higher weight and higher huntingspeed
     * gives a higher chance to kill.
     *
     */
    public void kill() {
        double successProbability = Math.random();
        double successThreshold = huntingSpeed * weight * clawLength / 1000;

        if (successProbability > successThreshold) {
            System.out.println("Theropod successfully killed the prey!");
            setEnergy(getEnergy() + 50);
        } else {
            System.out.println("Theropod failed to kill the prey.");
            setEnergy(getEnergy() - 20);
        }
    }
}
