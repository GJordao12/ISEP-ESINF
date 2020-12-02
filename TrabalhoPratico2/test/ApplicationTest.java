import model.Constants;
import model.User;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Application Test.
 */
class ApplicationTest {

    private final Application app;
    private final FileReader fileReader;

    /**
     * Instantiates a new Application Test.
     */
    public ApplicationTest() {
        app = new Application();
        fileReader = new FileReader(app, Constants.FILE_S_USER_PATH, Constants.FILE_S_COUNTRY_PATH, Constants.FILE_S_RELATIONSHIP_PATH, Constants.FILE_S_BORDERS_PATH);
        fileReader.run();
    }

    /**
     * Test more popular.
     */
    @org.junit.jupiter.api.Test
    void morePopular() {
        System.out.println("More Popular");
        List<User> expResult = new ArrayList<>();
        User u33 = app.getUsersList().getUserById("u33");
        expResult.add(u33);
        User u1 = app.getUsersList().getUserById("u1");
        expResult.add(u1);
        User u3 = app.getUsersList().getUserById("u3");
        expResult.add(u3);
        User u9 = app.getUsersList().getUserById("u9");
        expResult.add(u9);
        assertEquals(expResult, app.morePopular(3));
    }

    /**
     * Test minimum number of connections.
     */
    @org.junit.jupiter.api.Test
    void minimumNumberOfConnections() {
        System.out.println("Minimum Number Of Connections");
        int expResult = 5;
        assertEquals(expResult, app.minimumNumberOfConnections());
    }

    /**
     * Test nearby friends.
     */
    @org.junit.jupiter.api.Test
    void nearbyFriends() {
        System.out.println("Nearby Friends");
        Map<String, HashSet<String>> expResult = new HashMap<>();
        expResult.put("paramaribo", new HashSet<>());
        expResult.get("paramaribo").add("u6");
        expResult.get("paramaribo").add("u14");
        expResult.get("paramaribo").add("u4");
        expResult.put("brasilia", new HashSet<>());
        expResult.get("brasilia").add("u20");
        expResult.get("brasilia").add("u32");
        expResult.put("montevideu", new HashSet<>());
        expResult.get("montevideu").add("u7");
        expResult.put("lapaz", new HashSet<>());
        expResult.get("lapaz").add("u9");
        expResult.get("lapaz").add("u2");
        expResult.put("quito", new HashSet<>());
        expResult.get("quito").add("u5");
        expResult.get("quito").add("u3");
        assertEquals(expResult, app.nearbyFriends("u1", 3));
    }

    /**
     * Test cities with greater centrality.
     */
    @org.junit.jupiter.api.Test
    void citiesWithGreaterCentrality() {
        System.out.println(("Cities With Greater Centrality"));
        List<String> expResult = new ArrayList<>();
        expResult.add("lapaz");
        expResult.add("assuncao");
        expResult.add("georgetwon");
        assertEquals(expResult, app.citiesWithGreaterCentrality(3, 5));
    }

    /**
     * Test shortest path between two users.
     */
    @org.junit.jupiter.api.Test
    void shortestPathBetweenTwoUsers() {
        System.out.println("Shortest Path Between Two Users");
        Map<LinkedList<String>, Double> expResult = new HashMap<>();
        LinkedList<String> aux = new LinkedList<>();
        aux.add("brasilia");
        aux.add("paramaribo");
        aux.add("georgetwon");
        aux.add("caracas");
        aux.add("bogota");
        aux.add("quito");
        aux.add("lima");
        aux.add("lapaz");
        expResult.put(aux, 8083.40693111275);
        assertEquals(expResult, app.shortestPathBetweenTwoUsers("u1", "u2", 3));
    }

    /**
     * Test gets amount of friends per country.
     */
    @org.junit.jupiter.api.Test
    void getAmountOfFriendsPerCountry() {
        System.out.println("Get Amount Of Friends Per Country");
        User u = app.getUsersList().getUserById("u1");
        Map<String, Integer> expResult = new HashMap<>();
        expResult.put("paramaribo", 3);
        expResult.put("brasilia", 2);
        expResult.put("montevideu", 1);
        expResult.put("lapaz", 2);
        expResult.put("quito", 2);
        assertEquals(expResult, app.getAmountOfFriendsPerCountry(u));
    }

    /**
     * Test sort map.
     */
    @org.junit.jupiter.api.Test
    void sortMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 3);
        map.put("b", 1);
        map.put("c", 2);
        System.out.println("Map Sort by Type 0 (crescent)");
        Map<String, Integer> expResult = new HashMap<>();
        expResult.put("b", 1);
        expResult.put("c", 2);
        expResult.put("a", 3);
        Map<String, Integer> result = app.sortMap(map, 0);
        assertEquals(expResult, result);
        System.out.println("Map Sort by Type 1 (reversed)");
        expResult.clear();
        expResult.put("a", 3);
        expResult.put("c", 2);
        expResult.put("b", 1);
        result = app.sortMap(map, 1);
        assertEquals(expResult, result);
    }

    /**
     * Test permute.
     */
    @org.junit.jupiter.api.Test
    void permute() {
        System.out.println("Permute");
        List<String> aux = new ArrayList<>();
        aux.add("a");
        aux.add("b");
        List<List<String>> expResult = new ArrayList<>();
        List<String> permute1 = new ArrayList<>();
        permute1.add("a");
        permute1.add("b");
        expResult.add(permute1);
        List<String> permute2 = new ArrayList<>();
        permute2.add("b");
        permute2.add("a");
        expResult.add(permute2);
        List<List<String>> result = app.permute(aux);
        assertEquals(expResult, result);

    }
}