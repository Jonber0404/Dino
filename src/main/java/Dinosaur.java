public class Dinosaur {
    private final boolean herbivore;
    private final boolean carnivore;
    private final boolean omnivore;
    private int energy = 100;

    public Dinosaur(boolean herbivore, boolean carnivore, boolean omnivore) {
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
     * @param food - Of the class FoodType.
     */
    public void eat(FoodType food) {
        if (herbivore) {
            if (food == FoodType.MEAT) {
                energy = energy - 20;
            } else if (food == FoodType.PLANT) {
                energy = energy + 20;
            }
        } else if (carnivore) {
            if (food == FoodType.MEAT) {
                energy = energy + 20;
            } else if (food == FoodType.PLANT) {
                energy = energy - 20;
            }
        } else if (omnivore) {
            if (food == FoodType.MEAT || food == FoodType.PLANT) {
                energy = energy + 20;
            }
        }
    }
}
