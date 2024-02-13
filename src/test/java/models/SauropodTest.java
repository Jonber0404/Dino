package models;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SauropodTest {

    @Test
    public void testWalk(){
        Sauropod dino1 = new Sauropod
                ("Astrodon", true, false, false, 20.4, 0, 40);

        assertEquals(dino1.getEnergy(), 100);
        assertEquals(dino1.getWalkingSpeed(), 0);

        dino1.walk();
        assertTrue(dino1.getWalkingSpeed() > 0);
        assertTrue(dino1.getEnergy() < 100);
    }

    @Test
    public void testWalkOlderSauropod(){
        Sauropod dino1 = new Sauropod
                ("Astrodon", true, false, false, 20.4, 0, 40);
        Sauropod dino2 = new Sauropod
                ("Brachiosaurus", true, false, false, 25, 0, 80);

        assertEquals(dino1.getEnergy(), dino2.getEnergy());
        assertEquals(dino1.getWalkingSpeed(), dino2.getWalkingSpeed());

        dino1.walk();
        dino2.walk();
        assertEquals(dino1.getEnergy(), dino2.getEnergy());
        assertNotEquals(dino1.getWalkingSpeed(), dino2.getWalkingSpeed());

    }

    @Test
    public void testSleep(){
        Sauropod dino1 = new Sauropod
                ("Astrodon", true, false, false, 20.4, 0, 40);
        dino1.setEnergy(0);
        assertEquals(dino1.getEnergy(), 0);

        dino1.sleep(5);
        assertEquals(dino1.getEnergy(), 25);
    }

}
