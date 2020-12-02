package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Country Test.
 */
class CountryTest {

    /**
     * Test equals.
     */
    @org.junit.jupiter.api.Test
    void testEquals() {
        System.out.println("Equals to two equals users");
        Country c1 = new Country("argentina", "americasul", "41.67", "buenosaires", "-34.6131500", "-58.3772300");
        Country c2 = new Country("argentina", "americasul", "41.67", "buenosaires", "-34.6131500", "-58.3772300");
        assertEquals(true, c1.equals(c2));
        System.out.println("Equals to two different users");
        Country c3 = new Country("bolivia", "americasul", "9.70", "lapaz", "-16.5000000", "-68.1500000");
        Country c4 = new Country("argentina", "americasul", "41.67", "buenosaires", "-34.6131500", "-58.3772300");
        assertEquals(false, c3.equals(c4));
    }
}