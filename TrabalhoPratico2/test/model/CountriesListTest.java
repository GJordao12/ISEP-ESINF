package model;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Countries List Test.
 */
class CountriesListTest {

    private final CountriesList cl;

    /**
     * Instantiates a new Countries List Test.
     */
    public CountriesListTest() {
        cl = new CountriesList();
    }

    /**
     * Test get country by country.
     */
    @org.junit.jupiter.api.Test
    void getCountryByCountry(){
        System.out.println("Get Country By Country");
        Country c1 = new Country("argentina", "americasul", "41.67", "buenosaires", "-34.6131500", "-58.3772300");
        cl.registerCountry(c1);
        assertEquals(c1,cl.getCountryByCountry("argentina"));
    }

    /**
     * Test gets distance.
     */
    @org.junit.jupiter.api.Test
    void getDistance() {
        System.out.println("Distance between two countries");
        Country c1 = new Country("argentina", "americasul", "41.67", "buenosaires", "-34.6131500", "-58.3772300");
        Country c2 = new Country("bolivia", "americasul", "9.70", "lapaz", "-16.5000000", "-68.1500000");
        assertEquals(2236.7809710310194,cl.getDistance(c1,c2));
    }
}