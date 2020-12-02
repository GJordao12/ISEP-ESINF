import adjacencyMap.Graph;
import adjacencyMap.GraphAlgorithms;
import adjacencyMatrix.AdjacencyMatrixAlgorithms;
import adjacencyMatrix.AdjacencyMatrixGraph;
import model.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Application.
 */
public class Application {

    /**
     * The User List.
     */
    public UsersList userList;
    /**
     * The Countries List.
     */
    public CountriesList countriesList;
    /**
     * The User Relationships.
     */
    public AdjacencyMatrixGraph<User, Integer> userRelationships;
    /**
     * The Capitals Relations.
     */
    public Graph<String, Integer> capitalsRelations;

    /**
     * Instantiates a new Application.
     */
    public Application() {
        this.userList = new UsersList();
        this.countriesList = new CountriesList();
        this.userRelationships = new AdjacencyMatrixGraph<>();
        this.capitalsRelations = new Graph<>(false);
    }

    /**
     * Gets User List.
     *
     * @return the users list
     */
    public UsersList getUsersList() {
        return this.userList;
    }

    /**
     * Gets Countries List.
     *
     * @return the countries list
     */
    public CountriesList getCountriesList() {
        return this.countriesList;
    }

    /**
     * Gets User Relationships.
     *
     * @return the users relationships
     */
    public AdjacencyMatrixGraph<User, Integer> getUsersRelationships() {
        return this.userRelationships;
    }

    /**
     * Gets Capitals Relations.
     *
     * @return the capitals relations
     */
    public Graph<String, Integer> getCapitalsRelations() {
        return this.capitalsRelations;
    }

    /**
     * Return the common friends among the n most popular users on the network.
     *
     * @param amount the n most popular users
     * @return the common friends among the n most popular users
     */
    List<User> morePopular(int amount) {
        List<User> users = new ArrayList<>(this.userList.getUsers());
        Collections.sort(users);

        //save the top
        List<User> topUsersAndCommonFriends = users.subList(0, amount);

        //check common friends
        boolean flag = true;
        for (User user : this.userRelationships.adjVertices(topUsersAndCommonFriends.get(amount - 1))) {
            for (int i = 0; i < amount - 1; i++) {
                if ((this.userRelationships.getEdge(topUsersAndCommonFriends.get(i), user) == null)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                topUsersAndCommonFriends.add(user);
            } else {
                flag = true;
            }
        }
        return topUsersAndCommonFriends;
    }

    /**
     * Check if the friendship network is connected and, if so, return the minimum number of connections
     * necessary for any user to be able to contact any other user on this network.
     *
     * @return the minimum number of connections or -1 if the friendship network is not connected
     */
    int minimumNumberOfConnections() {
        User u = this.userList.getUsers().get(0);
        LinkedList<User> listAux = AdjacencyMatrixAlgorithms.BFS(this.userRelationships, u);
        if (this.userRelationships.numVertices() == listAux.size()) {
            //distance between the furthest points
            return AdjacencyMatrixAlgorithms.amountOfLayers(this.userRelationships, listAux.getLast());
        }
        return -1;
    }

    /**
     * Return to a user the friends who are nearby, that is, friends who live in cities that are within a certain
     * number of borders from that user's city. Return the respective friends of each near city.
     *
     * @param userId  the user's id
     * @param borders the borders
     * @return the friends of each near city
     */
    Map<String, HashSet<String>> nearbyFriends(String userId, int borders) {
        Map<String, HashSet<String>> mapAux = new HashMap<>();

        User u = this.userList.getUserById(userId);

        if (!this.capitalsRelations.validVertex(u.getCity())) {
            return mapAux;
        }

        //save the cities maximum n borders away
        LinkedList<String> citiesBordersAway = GraphAlgorithms.BreadthFirstSearch(this.capitalsRelations, u.getCity(), borders);

        //save the friends for each cities
        if (!citiesBordersAway.isEmpty()) {
            for (User user : this.userRelationships.adjVertices(u)) {
                if (citiesBordersAway.contains(user.getCity())) {
                    if (mapAux.isEmpty() || !mapAux.containsKey(user.getCity())) {
                        mapAux.put(user.getCity(), new HashSet<>());
                    }
                    mapAux.get(user.getCity()).add(user.getID());
                }
            }
        }
        return mapAux;
    }

    /**
     * Return the n cities with greater centrality, that is, the cities that on average are closer to all other cities
     * and where at least p% of the users of the friendship network live, where p% is the relative percentage of
     * users in each city.
     *
     * @param amountOfCities the n cities with greater centrality
     * @param percentage     the percentage
     * @return the n cities with greater centrality with at least p% of the users of the friendship network live
     */
    List<String> citiesWithGreaterCentrality(int amountOfCities, double percentage) {
        Map<String, Double> cities = new HashMap<>();
        List<String> topCountries = new ArrayList<>();

        //save the average distance from all other cities for each city
        int count = 0;
        for (Country c : this.countriesList.getCountries()) {
            String c1 = c.getCapital();
            if (cities.isEmpty() || !cities.containsKey(c1)) {
                cities.put(c1, 0.0);
            }
            for (int i = count + 1; i < this.countriesList.getCountries().size(); i++) {
                String c2 = this.countriesList.getCountries().get(i).getCapital();
                if (!cities.containsKey(c2)) {
                    cities.put(c2, 0.0);
                }
                double currentDistance = cities.get(c1);
                double distance = this.countriesList.getDistance(c, this.countriesList.getCountries().get(i));
                double newDistance = currentDistance + distance;
                cities.put(c1, newDistance);
                currentDistance = cities.get(c2);
                newDistance = currentDistance + distance;
                cities.put(c2, newDistance);
            }
            double totalDistance = cities.get(c1);
            double average = totalDistance / (this.countriesList.getCountries().size() - 1);
            cities.put(c1, average);
            count++;
        }

        //sort by average distance
        Map<String, Double> citiesSorted = cities.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, content) -> content, LinkedHashMap::new));

        //reuse the map
        citiesSorted.replaceAll((s, v) -> 0.0);

        //save the amount of users in each city
        for (User u : this.userRelationships.vertices()) {
            if (citiesSorted.containsKey(u.getCity())) {
                double amountOfUser = citiesSorted.get(u.getCity()) + 1;
                citiesSorted.put(u.getCity(), amountOfUser);
            }
        }

        //save the relative percentage of users in each city
        for (String s : citiesSorted.keySet()) {
            double individualPercentage = (citiesSorted.get(s) / this.userRelationships.numVertices()) * 100;
            citiesSorted.put(s, individualPercentage);
        }

        //save n most centrality with a percentage equal to or greater than that requested
        int contAux = 0;
        for (String s : citiesSorted.keySet()) {
            if (citiesSorted.get(s) >= percentage) {
                topCountries.add(s);
                contAux++;
            }
            if (contAux == amountOfCities) {
                break;
            }
        }
        return topCountries;
    }

    /**
     * Return the shortest terrestrial path between two users, passing through the n intermediate cities where
     * each user has the largest number of friends.
     *
     * @param userId1 the user id
     * @param userId2 the user id
     * @param amount  the n intermediate cities
     * @return the shortest terrestrial path between two users and distance in km
     */
    Map<LinkedList<String>, Double> shortestPathBetweenTwoUsers(String userId1, String userId2, int amount) {
        Map<LinkedList<String>, Double> pathsWithNecessaryCities = new HashMap<>();

        if(userId1.equals(userId2)) {
            return pathsWithNecessaryCities;
        }

        User u1 = this.userList.getUserById(userId1);
        String cityUser1 = u1.getCity();
        User u2 = this.userList.getUserById(userId2);
        String cityUser2 = u2.getCity();

        //two users who are from the same city cannot be done, because all cities must be different
        //if the city of one of the users doesn't have in the graph, it means that there are no connections so it’s impossible to connect them
        if (cityUser1.equalsIgnoreCase(cityUser2) || !this.capitalsRelations.validVertex(u1.getCity()) || !this.capitalsRelations.validVertex(u2.getCity()) || !GraphAlgorithms.BreadthFirstSearch(this.capitalsRelations, cityUser1, cityUser2)) {
            return pathsWithNecessaryCities;
        }

        LinkedList<String> topCities = new LinkedList<>();

        Map<String, Integer> citiesUser1 = this.getAmountOfFriendsPerCountry(u1);
        Map<String, Integer> citiesUser2 = this.getAmountOfFriendsPerCountry(u2);

        Map<String, Integer> citiesUser1Sorted = this.sortMap(citiesUser1, 1);
        Map<String, Integer> citiesUser2Sorted = this.sortMap(citiesUser2, 1);

        //save the u1 top friends
        int contAux = 0;
        for (String s : citiesUser1Sorted.keySet()) {
            if (!s.equals(cityUser1) && !s.equals(cityUser2)) {
                topCities.add(s);
            }
            contAux++;
            if (contAux == amount) {
                break;
            }
        }

        //save the u2 top friends
        contAux = 0;
        for (String s : citiesUser2Sorted.keySet()) {
            if (!topCities.contains(s) && !s.equals(cityUser1) && !s.equals(cityUser2)) {
                topCities.add(s);
            }
            contAux++;
            if (contAux == amount) {
                break;
            }
        }

        //save the shortest path
        if (!topCities.isEmpty()) {
            List<List<String>> allPaths = this.permute(topCities);
            LinkedList<String> path;
            LinkedList<String> pathAux;
            LinkedList<String> minimumPath;
            double minimumDistance = 500000000;
            double individualDistance;
            boolean flag;
            for (List<String> list : allPaths) {
                flag = true;
                path = new LinkedList<>();
                path.add(cityUser1);
                individualDistance = 0;
                for (String s : list) {
                    pathAux = new LinkedList<>();
                    double distance = GraphAlgorithms.shortestPath(this.capitalsRelations, path.getLast(), s, pathAux);
                    individualDistance = individualDistance + distance;
                    if (individualDistance > minimumDistance || distance == 0) {
                        flag = false;
                        break;
                    }
                    pathAux.removeFirst();
                    path.addAll(pathAux);
                }
                if (flag) {
                    pathAux = new LinkedList<>();
                    double distance = GraphAlgorithms.shortestPath(this.capitalsRelations, path.getLast(), cityUser2, pathAux);
                    individualDistance = individualDistance + distance;
                    if (distance != 0) {
                        pathAux.removeFirst();
                        path.addAll(pathAux);
                        if (individualDistance < minimumDistance) {
                            minimumPath = new LinkedList<>(path);
                            minimumDistance = individualDistance;
                            pathsWithNecessaryCities.clear();
                            pathsWithNecessaryCities.put(minimumPath, minimumDistance);
                        }
                    }
                }
            }
        }
        return pathsWithNecessaryCities;
    }

    /**
     * Gets amount of friends per country.
     *
     * @param u the user
     * @return the amount of friends per country
     */
    Map<String, Integer> getAmountOfFriendsPerCountry(User u) {
        Map<String, Integer> citiesUser = new HashMap<>();

        for (User user : this.userRelationships.adjVertices(u)) {
            if (citiesUser.isEmpty() || !citiesUser.containsKey(user.getCity())) {
                citiesUser.put(user.getCity(), 0);
            }
            int friends = citiesUser.get(user.getCity()) + 1;
            citiesUser.put(user.getCity(), friends);
        }
        return citiesUser;
    }

    /**
     * Sort map.
     *
     * @param map      the map
     * @param sortType the sort type 1 (reverse order) or 0 (crescent order)
     * @return the map sorted
     */
    Map<String, Integer> sortMap(Map<String, Integer> map, int sortType) {
        if (sortType == 0) {
            return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, content) -> content, LinkedHashMap::new));
        }
        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, content) -> content, LinkedHashMap::new));
    }

    /**
     * Permute List.
     *
     * @param citiesList the cities list
     * @return all permutations
     */
    public List<List<String>> permute(List<String> citiesList) {
        List<List<String>> result = new ArrayList<>();
        go(0, citiesList, result);
        return result;
    }

    /**
     * Recursive method for permute.
     *
     * @param start      start
     * @param citiesList cities list
     * @param result     all permutations
     */
    private void go(int start, List<String> citiesList, List<List<String>> result) {
        if (start == citiesList.size() - 1) {
            List<String> list = new ArrayList<>(citiesList);
            if (list.size() == citiesList.size()) {
                result.add(list);
            }
            return;
        }
        for (int i = start; i < citiesList.size(); i++) {
            Collections.swap(citiesList, i, start);
            go(start + 1, citiesList, result);
            Collections.swap(citiesList, i, start);
        }
    }
}
