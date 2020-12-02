import model.Constants;
import model.User;

import java.util.*;

public class MainApp {

    private static final Scanner text = new Scanner(System.in);

    public static void main(String[] args) {

        Application app = new Application();
        FileReader fileReader = new FileReader(app, Constants.FILE_S_USER_PATH, Constants.FILE_S_COUNTRY_PATH, Constants.FILE_S_RELATIONSHIP_PATH, Constants.FILE_S_BORDERS_PATH);
        fileReader.run();

        if (fileReader.flag) {
            int option = 99;
            while (option != 0) {
                System.out.println();
                System.out.println("================================================================MENU================================================================");
                System.out.println();
                System.out.println("Welcome to Tinder2.0!");
                System.out.println("1:  Read the file you want (NOTE: As default the small file is read).");
                System.out.println("2:  Check the common friends among the number (that you want) of most popular users on the network.");
                System.out.println("3:  Check the minimum number of connections necessary for any user to be able to contact any other user on this network.");
                System.out.println("4:  Check the nearby friends from a user you choose within the number of borders inserted.");
                System.out.println("5:  Check the number of cities with greater centrality where at least an inserted percentage of users live.");
                System.out.println("6:  Check the shortest terrestrial path between two users passing by an inserted number of cities where each user has the largest number of friends.");
                System.out.println("0:  Close program.");
                System.out.println();
                System.out.print("Select the option that you want to check: ");
                option = text.nextInt();
                text.nextLine();
                System.out.println();
                System.out.println("====================================================================================================================================");
                switch (option) {
                    case 1:
                        System.out.println("\n==========================SUB-MENU==========================\n");
                        System.out.println("1:  Read the Small File.");
                        System.out.println("2:  Read the Big File.");
                        System.out.println("\n============================================================\n");

                        int optionSubMenu = 0;
                        while (optionSubMenu != 1 && optionSubMenu != 2) {
                            System.out.print("Select the file that you want to read: ");
                            optionSubMenu = text.nextInt();
                            if (optionSubMenu != 1 && optionSubMenu != 2) {
                                System.out.println("Please enter a valid option!");
                            }
                        }

                        app = new Application();
                        if (optionSubMenu == 1) {
                            fileReader = new FileReader(app, Constants.FILE_S_USER_PATH, Constants.FILE_S_COUNTRY_PATH, Constants.FILE_S_RELATIONSHIP_PATH, Constants.FILE_S_BORDERS_PATH);
                        } else {
                            fileReader = new FileReader(app, Constants.FILE_B_USER_PATH, Constants.FILE_B_COUNTRY_PATH, Constants.FILE_B_RELATIONSHIP_PATH, Constants.FILE_B_BORDERS_PATH);
                        }
                        fileReader.run();

                        System.out.println("\nFile Read with Success!");
                        break;
                    case 2:
                        System.out.println("\nPlease insert the necessary data:");
                        int amount = -1;

                        while (amount > app.userList.getUsers().size() || amount < 1) {
                            System.out.printf("\nInsert the top (1-%d) of friendships do you want to view: ", app.userList.getUsers().size());
                            amount = text.nextInt();
                            if (amount > app.userList.getUsers().size() || amount < 1) {
                                System.out.println("Please enter a valid amount of users!");
                            }
                        }

                        System.out.println();

                        List<User> listEx2 = app.morePopular(amount);
                        System.out.println("----------------------");
                        System.out.printf("| %-5s | %-10s |\n", "Rank", "User's ID");
                        System.out.println("----------------------");
                        for (int i = 0; i < amount; i++) {
                            System.out.printf("| %-5d | %-10s |\n", i + 1, listEx2.get(i).getID());
                        }

                        System.out.println("----------------------");

                        if (!listEx2.subList(amount, listEx2.size()).isEmpty()) {
                            System.out.println("\n----------------------");
                            System.out.printf("| %-14s |\n", "Common Friends IDs");
                            System.out.println("----------------------");
                            for (int i = amount; i < listEx2.size(); i++) {
                                System.out.printf("| %-18s |\n", listEx2.get(i).getID());
                            }
                            System.out.println("----------------------");
                        } else {
                            System.out.println("\nNo Common Friends!");
                        }
                        break;
                    case 3:
                        int minimumConnections = app.minimumNumberOfConnections();
                        if (minimumConnections == -1) {
                            System.out.println("\nThe network of friendships is not connected.");
                        } else {
                            System.out.println("\nThe minimum number of connections necessary for any user to be able to contact any other user in this network is " + minimumConnections + ".");
                        }
                        break;
                    case 4:
                        System.out.println("\nPlease insert the necessary data:");
                        String userId = null;
                        int borders = -1;

                        while (app.userList.getUserById(userId) == null) {
                            System.out.print("\nInsert the User's Id that you want see the nearby friends of: ");
                            userId = text.nextLine().trim();
                            if (app.userList.getUserById(userId) == null) {
                                System.out.println("Please enter a valid user!");
                            }
                        }

                        while (borders < 0) {
                            System.out.printf("\nInsert the amount of borders away to see %s's friends: ", userId);
                            borders = text.nextInt();
                            if (borders < 0) {
                                System.out.println("Invalid number of borders!");
                            }
                        }

                        System.out.println();

                        Map<String, HashSet<String>> mapEx4 = app.nearbyFriends(userId, borders);
                        if (!mapEx4.isEmpty()) {
                            for (String country : mapEx4.keySet()) {
                                System.out.println("----------------------------------");
                                System.out.printf("| %-30s |\n", String.format("Friends Ids from %s", country));
                                System.out.println("----------------------------------");
                                for (String id : mapEx4.get(country)) {
                                    System.out.printf("| %-30s |\n", id);
                                }
                                System.out.println("----------------------------------\n");
                            }
                        } else {
                            System.out.printf("User %s has no friends %d borders away!\n", userId, borders);
                        }
                        break;
                    case 5:
                        System.out.println("\nPlease insert the necessary data:");
                        int amountOfCities = -1;
                        float percentage = -1;

                        while (amountOfCities <= 0 || amountOfCities > app.countriesList.getCountries().size()) {
                            System.out.printf("\nInsert the top (1-%d) of cities you want to view: ", app.countriesList.getCountries().size());
                            amountOfCities = text.nextInt();
                            if (amountOfCities <= 0 || amountOfCities > app.countriesList.getCountries().size()) {
                                System.out.println("Invalid amount of cities!");
                            }
                        }

                        while (percentage < 0 || percentage > 100) {
                            System.out.print("\nInsert the minimum relative percentage of users: ");
                            percentage = text.nextFloat();
                            if (percentage < 0 || percentage > 100) {
                                System.out.println("Invalid percentage!");
                            }
                        }

                        System.out.println();

                        List<String> listEx5 = app.citiesWithGreaterCentrality(amountOfCities, percentage);
                        if (!listEx5.isEmpty()) {
                            if (listEx5.size() != amountOfCities) {
                                System.out.printf("There are not enough cities for the top%d so we present the biggest top we could find.\n\n", amountOfCities);
                            }
                            System.out.println("------------------------");
                            System.out.printf("| %-5s | %-12s |\n", "Rank", "City");
                            System.out.println("------------------------");
                            for (int i = 0; i < listEx5.size(); i++) {
                                System.out.printf("| %-5d | %-12s |\n", i + 1, listEx5.get(i));
                            }
                            System.out.println("------------------------");
                        } else {
                            System.out.printf("No results to top%d with %.2f%% percentage of users!\n", amountOfCities, percentage);
                        }
                        break;
                    case 6:
                        System.out.println("\nPlease insert the necessary data:");
                        String userId1 = null;
                        String userId2 = null;
                        int amountOfIntermediateCities = 0;

                        while (app.userList.getUserById(userId1) == null) {
                            System.out.print("\nInsert the first user's Id : ");
                            userId1 = text.nextLine().trim();
                            if (app.userList.getUserById(userId1) == null) {
                                System.out.println("Please enter a valid user!");
                            }
                        }

                        while (app.userList.getUserById(userId2) == null) {
                            System.out.print("\nInsert the second user's Id : ");
                            userId2 = text.nextLine().trim();
                            if (app.userList.getUserById(userId2) == null) {
                                System.out.println("Please enter a valid user!");
                            }
                        }

                        while (amountOfIntermediateCities <= 0) {
                            System.out.print("\nInsert the amount of intermediate cities: ");
                            amountOfIntermediateCities = text.nextInt();
                            if (amountOfIntermediateCities <= 0) {
                                System.out.println("Invalid number of intermediate cities!");
                            }
                        }

                        System.out.println();

                        Map<LinkedList<String>, Double> mapEx6 = app.shortestPathBetweenTwoUsers(userId1, userId2, amountOfIntermediateCities);
                        if (!mapEx6.isEmpty()) {
                            for (LinkedList<String> l : mapEx6.keySet()) {
                                System.out.print("Path: ");
                                for (int i = 0; i < l.size(); i++) {
                                    System.out.print(l.get(i));
                                    if (i != l.size() - 1) {
                                        System.out.print(" -> ");
                                    }
                                }
                                System.out.printf("\nDistance: %.2f km\n", mapEx6.get(l));
                            }
                        } else {
                            System.out.printf("No results passing through %d intermediate cities!\n", amountOfIntermediateCities);
                        }
                        break;
                    case 0:
                        System.out.println("\nClosing program...");
                        System.out.println();
                        System.out.println("====================================================================================================================================");
                        break;
                    default:
                        System.out.println("\nInvalid option, try again...");
                        break;
                }
            }
        }
    }
}
