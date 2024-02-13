package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.FoodType;

public class PterosaurTest {

    /**
     * Tests the Pterosaur constructor so that if
     * you create a herbivore or carnivore and
     * omnivore simultaneously it will throw an
     * IllegalArgumentException.
     */
    @Test
    public void testConstructorExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Pterosaur
                ("Quetzalcoatlus", true, true, false, 11.0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Pterosaur
                ("Quetzalcoatlus", false, true, true, 11.0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Pterosaur
                ("Quetzalcoatlus", false, false, false, 11.0));

    }

    @Test
    public void test2EqualPterosaurs() {
        Pterosaur pterosaur1 = new Pterosaur("Quetzalcoatlus", false, true, false, 11.0);
        Pterosaur pterosaur2 = new Pterosaur("Quetzalcoatlus", false, true, false, 11.0);

        Assertions.assertEquals(pterosaur1, pterosaur2);
    }

    @Test
    public void test2NonEqualPterosaurs() {
        Pterosaur pterosaur1 = new Pterosaur("Quetzalcoatlus", false, true, false, 11.0);
        Pterosaur pterosaur2 = new Pterosaur("Pteranodon", false, true, false, 3.8);

        Assertions.assertNotEquals(pterosaur1, pterosaur2);
    }

    /**
     * Tests fly method. This method increases
     * speed by 24 if energy is above or equal to
     * 50 and decreases by 24 if below 50, altitude
     * = altitude + speed and the method
     * decreases energy by 10.
     */
    @Test
    public void testFly() {
        Pterosaur pterosaur = new Pterosaur("Quetzalcoatlus", false, true, false, 11.0);

        //Tests fly >= 50 energy. Base energy is 100.
        pterosaur.fly();
        Assertions.assertEquals(24, pterosaur.getSpeed());
        Assertions.assertEquals(24, pterosaur.getAltitude());
        Assertions.assertEquals(90, pterosaur.getEnergy());

        //Tests fly < 50 energy.
        pterosaur.setEnergy(20);
        pterosaur.fly();
        Assertions.assertEquals(0, pterosaur.getSpeed()); //Speed was 24 and is now 0 since energy <= 50.
        Assertions.assertEquals(24, pterosaur.getAltitude()); //Altitude was 24 + speed = 24.
        Assertions.assertEquals(10, pterosaur.getEnergy());

        //Tests fly energy depletes to 0 during.
        pterosaur.fly(); //Our energy is 10. This depletes it to 0.
        Assertions.assertEquals(0, pterosaur.getSpeed());
        Assertions.assertEquals(0, pterosaur.getAltitude()); //Since it lands, both altitude and speed will be 0.
        Assertions.assertEquals(0, pterosaur.getEnergy());

    }

    /**
     * Tests the land() method.
     */
    @Test
    public void testLand() {
        Pterosaur pterosaur = new Pterosaur("Quetzalcoatlus", false, true, false, 11.0);
        pterosaur.fly();
        pterosaur.land();

        Assertions.assertEquals(0, pterosaur.getAltitude());
        Assertions.assertEquals(0, pterosaur.getSpeed());
    }

    /**
     * Tests the stoop method. Only works if
     * altitude is above 0.
     */
    @Test
    public void testStoop() {
        Pterosaur pterosaur = new Pterosaur("Quetzalcoatlus", false, true, false, 11.0);
        pterosaur.fly(); //flight makes speed = 24 and altitude 24.
        pterosaur.stoop(FoodType.MEAT); // stoop drops altitude to 1. fly() method is called again which makes speed = 48.

        Assertions.assertEquals(49, pterosaur.getAltitude()); // Altitude = 1 + 48.
        Assertions.assertEquals(105, pterosaur.getEnergy());
    }

    /**
     * Tests foraging method. Altitude has to be above 1.
     */
    @Test
    public void testForaging() {
        Pterosaur pterosaur1 = new Pterosaur("Quetzalcoatlus", false, true, false, 11.0);
        pterosaur1.fly();
        FoodType meat = FoodType.MEAT;
        pterosaur1.foraging(meat);

        Assertions.assertEquals(0, pterosaur1.getAltitude());
        Assertions.assertEquals(0, pterosaur1.getSpeed());
        Assertions.assertEquals(115, pterosaur1.getEnergy()); //Gets 25 energy from eating meat

        Pterosaur pterosaur2 = new Pterosaur("Quetzalcoatlus", false, true, false, 10.0);
        pterosaur2.fly();
        FoodType plant = FoodType.PLANT;
        pterosaur2.foraging(plant);

        Assertions.assertEquals(0, pterosaur2.getAltitude());
        Assertions.assertEquals(0, pterosaur2.getSpeed());
        Assertions.assertEquals(65, pterosaur2.getEnergy()); //Carnivore looses 25 energy from eating plant
    }
}
