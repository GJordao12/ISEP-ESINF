import java.util.*;

public class MainApp {

    private static final Scanner text = new Scanner(System.in);

    public static void main(String[] args) {

        Application app = new Application();
        app.readData();

        if (app.flag) {
            int option = 99;
            while (option != 0) {
                System.out.println();
                System.out.println("================================================================MENU================================================================");
                System.out.println();
                System.out.println("Welcome to the International Covid Research Lab!");
                System.out.println("1:  Check the Locations with minimum amount of days to reach 50000 positive covid cases.");
                System.out.println("2:  Check the stats (new cases and new deaths) within every month per continent.");
                System.out.println("3:  Check the information about positive covid cases by your choice (Continent and Month).");
                System.out.println("4:  Check the relation between smokers percentage population and total deaths per Location.");
                System.out.println("0:  Close program.");
                System.out.println();
                System.out.print("Select the option that you want to check: ");
                option = text.nextInt();
                text.nextLine();
                System.out.println();
                System.out.println("====================================================================================================================================");
                switch (option) {
                    case 1:
                        Map<String, Integer> mapPrintCase1 = app.casesInMinDays();
                        if (mapPrintCase1.isEmpty()) {
                            System.out.print("\nERROR: No Location has reached 50000 positive covid cases!\n");
                        } else {
                            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------");
                            System.out.printf("| %-15s | %-20s | %-25s | %-20s | %-20s | %-10s |", "ISO Code", "Continent", "Location", "Date", "Total Cases", "Minimum Days");
                            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------");
                            for (String s : mapPrintCase1.keySet()) {
                                System.out.printf("%s | %-12d |%n", s, mapPrintCase1.get(s));
                            }
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
                        }
                        break;
                    case 2:
                        TreeMap<String, TreeMap<Integer, List<Integer>>> mapPrintCase2 = app.casesDeathsPerContMonth();
                        if (mapPrintCase2.isEmpty()) {
                            System.out.print("\nERROR: No information from any month on any continent!\n");
                        } else {
                            System.out.println("\n--------------------------------------------------------------------------------------------------");
                            System.out.printf("| %-20s | %-20s | %-25s | %-20s |", "Continent", "Month", "New Cases", "New Deaths");
                            System.out.println("\n--------------------------------------------------------------------------------------------------");
                            for (String s : mapPrintCase2.keySet()) {
                                for (Integer i : mapPrintCase2.get(s).keySet()) {
                                    System.out.printf("| %-20s | %-20d | %-25d | %-20d |\n", s, i, mapPrintCase2.get(s).get(i).get(0), mapPrintCase2.get(s).get(i).get(1));
                                }
                                System.out.println("--------------------------------------------------------------------------------------------------");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("\nPlease insert the necessary data:");
                        Continent continent = null;
                        int month = 0;
                        while (continent == null) {
                            System.out.print("Continent -> ");
                            continent = Continent.setContinent(text.nextLine().trim());
                            if (continent == null) {
                                System.out.println("Please enter a valid Continent!");
                            }
                        }
                        while (month > 12 || month < 1) {
                            System.out.print("Month (1-12) -> ");
                            month = text.nextInt();
                            if (month > 12 || month < 1) {
                                System.out.println("Please enter a valid Month!");
                            }
                        }
                        System.out.println();
                        TreeMap<Integer, HashMap<String, Integer>> mapPrintCase3 = app.contCasesPerDayOfMonth(Continent.EU, 9);
                        if (mapPrintCase3.isEmpty()) {
                            System.out.printf("ERROR: No information on the %dth month of %s!\n", month, continent.toString());
                        } else {
                            for (Integer i : mapPrintCase3.keySet()) {
                                System.out.print("---------------------------------------------\n");
                                System.out.printf("| %-41s |\n", String.format("Cases Of Day %d", i));
                                System.out.print("---------------------------------------------\n");
                                for (String s : mapPrintCase3.get(i).keySet()) {
                                    System.out.printf("| %-29s %-11d |\n", s, mapPrintCase3.get(i).get(s));
                                }
                                System.out.print("---------------------------------------------\n");
                                System.out.println();
                            }
                        }
                        break;
                    case 4:
                        Map<ISO, Integer> mapPrintCase4 = app.smokersByNewDeaths();
                        if (mapPrintCase4.isEmpty()) {
                            System.out.print("\nERROR: No Location has more than 70% of smokers!\n");
                        } else {
                            System.out.println("\n---------------------------------------------------------------------------");
                            System.out.printf("| %-30s | %-20s | %-12s |", "Location", "Smokers Percentages (%)", "Total Deaths");
                            System.out.println("\n---------------------------------------------------------------------------");
                            for (ISO i : mapPrintCase4.keySet()) {
                                System.out.printf("| %-30s | %-23.2f | %-12d |%n", i.getLocation(), i.getSmokersPercentage(), mapPrintCase4.get(i));
                            }
                            System.out.println("---------------------------------------------------------------------------");
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
