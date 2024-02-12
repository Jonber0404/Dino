public class Sauropod extends Dinosaur{
    private double neckLength; //meter
    private double walkingSpeed; //km/h
    private int age; //years

    public Sauropod(boolean herbivore, boolean carnivore, boolean omnivore, double neckLength, double walkingSpeed, int age) {
        super(herbivore, carnivore, omnivore);
        this.neckLength = neckLength;
        this.walkingSpeed = walkingSpeed;
        this.age = age;
        if(carnivore || omnivore) {
            throw new IllegalArgumentException("Sauropods can only be herbivores");
        }
    }

    /**
     * Simulates walking. Walking drains energy. Sauropods
     * older than 50 years walks slower. If energy is zero or
     * below it cannot walk.
     */
    public void walk(){
        if(getEnergy() > 0){
            if (getEnergy() >= 50 && getEnergy() <= 100){
                if(age > 50) {
                    walkingSpeed = walkingSpeed + 3;
                }
                else if (age <= 50){
                    walkingSpeed = walkingSpeed + 5;
                }
            }
            else if (getEnergy() > 0 && getEnergy() < 50) {
                if(age > 50) {
                    walkingSpeed = walkingSpeed - 3;
                }
                else if (age <= 50){
                    walkingSpeed = walkingSpeed - 5;
                }
            }

            setEnergy(getEnergy() - 20);
        }
    }

    /**
     * Simulates sleeping. The longer it sleeps, the
     * more energy it regains.
     * @param hours amount of time it sleeps.
     */
    public void sleep(int hours){
        setEnergy(getEnergy() + (5 * hours));
    }

    public double getNeckLength() {
        return neckLength;
    }

    public void setNeckLength(double neckLength) {
        this.neckLength = neckLength;
    }

    public double getWalkingSpeed() {
        return walkingSpeed;
    }

    public void setWalkingSpeed(double walkingSpeed) {
        this.walkingSpeed = walkingSpeed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
