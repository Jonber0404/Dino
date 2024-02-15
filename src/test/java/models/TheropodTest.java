package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheropodTest {
    @Test
    public void testSleep(){
        Theropod thero1 = new Theropod("Tyrannosaurus", false, true, false, 20);
        thero1.setEnergy(0);
        assertEquals(thero1.getEnergy(), 0);

        thero1.sleep(5);
        assertEquals(thero1.getEnergy(), 35);
    }

    @Test
    public void testHuntWithEnoughEnergy() {
        // Arrange
        Theropod theropod = new Theropod("Tyrannosaurus", false, true, false, 8);
        theropod.setEnergy(50);

        // Act
        theropod.hunt();

        // Assert
        assertEquals(40, theropod.getEnergy()); // Expecting energy to decrease by 10 after hunting
    }

    @Test
    public void testHuntWithoutEnoughEnergy() {
        // Arrange
        Theropod theropod = new Theropod("Tyrannosaurus", false, true, false, 8);
        theropod.setEnergy(5); // Set energy below the required threshold for hunting

        // Act
        theropod.hunt();

        // Assert
        assertEquals(5, theropod.getEnergy()); // Expecting energy to remain the same
    }

}

