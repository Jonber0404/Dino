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

    public Pterosaur(boolean herbivore, boolean carnivore, boolean omnivore, double wingspan) {
        super(herbivore, carnivore, omnivore);
        this.wingspan = wingspan;
        if (herbivore) {
            throw new IllegalArgumentException("Pterosaurs cannot be herbivores");
        }
    }

    /**
     * Simulates flight. Changes the altitude of
     * the Pterosaur. Flying drains energy. If
     * energy is zero or below you cannot fly.
     */
    public void fly() {
        if (getEnergy() > 0) {
            if (getEnergy() >= 50 && getEnergy() <= 100) {
                speed = speed + 24;
            } else if (getEnergy() > 0 && getEnergy() < 50) {
                speed = speed - 24;
            }

            altitude = altitude + speed;
            setEnergy(getEnergy() - 10);
        } else {
            if (altitude > 0) {
                land();
            }
        }
    }

    /**
     * Simulates landing.
     */
    public void land() {
        if (altitude > 0) {
            altitude = 0;
            speed = 0;
        }
    }

}
