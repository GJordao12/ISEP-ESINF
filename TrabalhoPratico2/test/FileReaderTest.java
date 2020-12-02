import model.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type File Reader Test.
 */
class FileReaderTest {

    private final Application app;
    private final FileReader fileReader;

    /**
     * Instantiates a new File Reader Test.
     */
    public FileReaderTest() {
        app = new Application();
        fileReader = new FileReader(app, Constants.FILE_S_USER_PATH, Constants.FILE_S_COUNTRY_PATH, Constants.FILE_S_RELATIONSHIP_PATH, Constants.FILE_S_BORDERS_PATH);
        fileReader.run();
    }

    /**
     * Test read users.
     */
    @org.junit.jupiter.api.Test
    void readUsers() {
        System.out.println("Amount of Users");
        int expResult = 26;
        assertEquals(expResult, app.getUsersList().getUsers().size());
    }

    /**
     * Test read relationships.
     */
    @org.junit.jupiter.api.Test
    void readRelationships() {
        System.out.println("Amount of Vertices (Matrix Users)");
        int expResult = 26;
        assertEquals(expResult, app.getUsersRelationships().numVertices());
        System.out.println("Amount of Edges (Matrix Users)");
        expResult = 45;
        assertEquals(expResult, app.getUsersRelationships().numEdges());
    }

    /**
     * Test read countries.
     */
    @org.junit.jupiter.api.Test
    void readCountries() {
        System.out.println("Amount of Countries");
        int expResult = 13;
        assertEquals(expResult, app.getCountriesList().getCountries().size());
    }

    /**
     * Test read borders.
     */
    @org.junit.jupiter.api.Test
    void readBorders() {
        System.out.println("Amount of Vertices (Map Countries)");
        int expResult = 13;
        assertEquals(expResult, app.getCapitalsRelations().numVertices());
        System.out.println("Amount of Edges (Map Countries)");
        expResult = 50;
        assertEquals(expResult, app.getCapitalsRelations().numEdges());
    }
}