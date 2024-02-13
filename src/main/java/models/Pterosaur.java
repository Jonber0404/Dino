package models;


import utilities.FoodType;

import java.util.Objects;

public class Pterosaur extends Dinosaur {
    private final double wingspan; // meters
    private double speed = 0.0; // km/h
    private double altitude = 0.0; // meters

    public double getAltitude() {
        return altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public Pterosaur(String name, boolean herbivore, boolean carnivore, boolean omnivore, double wingspan) {
        super(name, herbivore, carnivore, omnivore);
        this.wingspan = wingspan;
        if (herbivore) {
            throw new IllegalArgumentException("Pterosaur cannot be herbivores.");
        } else if (carnivore && omnivore) {
            throw new IllegalArgumentException("Pterosaur cannot be carnivores and omnivores simultaneously.");
        } else if (!carnivore && !omnivore) {
            throw new IllegalArgumentException("Pterosaur has to have a diet.");
        }
    }

    /**
     * Simulates flight. Changes the altitude of
     * the Pterosaur. Flying drains energy. If
     * energy is zero or below you cannot fly. If
     * in the air you will land. 130km/h is max speed.
     */
    public void fly() {
        if (getEnergy() > 0) {
            if (getEnergy() >= 50) {
                speed = speed + 24;

                if (speed >= 130) {
                    speed = 130;
                }
            } else if (getEnergy() > 0 && getEnergy() < 50) {
                speed = speed - 24;

                if (speed < 0) {
                    speed = 0;
                }
            }

            altitude = altitude + speed;
            setEnergy(getEnergy() - 10);

            if (getEnergy() <= 0) {
                land();
            }

        }
    }

    /**
     * Simulates landing. Altitude and speed set
     * to 0.
     */
    public void land() {
        if (altitude > 0) {
            altitude = 0;
            speed = 0;
        }
    }

    /**
     * Simulates the Pterosaur stooping to catch prey. Stoops down to a low
     * altitude, eat(prey), and calls the fly method.
     *
     * @param prey - Of the class FoodType and has to be of the type MEAT.
     */
    public void stoop(FoodType prey) {
        if (altitude > 0 && prey == FoodType.MEAT) {
            altitude = 1;
            eat(prey);
            fly();
        }
    }

    /**
     * Simulates foraging from the air for plant-
     * based food or carrion. Lands to eat.
     *
     * @param food - Of the class FoodType.
     */
    public void foraging(FoodType food) {
        if (altitude > 0) {
            land();
            eat(food);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pterosaur pterosaur)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(wingspan, pterosaur.wingspan) == 0 && Double.compare(getSpeed(), pterosaur.getSpeed()) == 0 && Double.compare(getAltitude(), pterosaur.getAltitude()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wingspan, getSpeed(), getAltitude());
    }
}
