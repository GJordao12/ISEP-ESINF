import model.ElectronicConfiguration;
import model.Element;

import java.util.*;

public class MainApp {

    private static final Scanner text = new Scanner(System.in);

    public static void main(String[] args) {

        Application app = new Application();
        app.readElements();

        if (app.flag) {
            int option = 99;
            while (option != 0) {
                System.out.println();
                System.out.println("======================================================================MENU======================================================================");
                System.out.println();
                System.out.println("Welcome to Periodic Table!");
                System.out.println("1:  Search for elements by any of the following fields: Atomic Number, Element, Symbol or Atomic Mass.");
                System.out.println("2:  Check the amount of occurrences for each Electronic Configuration.");
                System.out.println("3:  Create a tree with the Electronic Configurations placed in decreasing order.");
                System.out.println("4:  Check the distance between the two furthest Electronic Configurations.");
                System.out.println("5:  Create a Binary Complete Tree.");
                System.out.println("0:  Close program.");
                System.out.println();
                System.out.print("Select the option that you want to check: ");
                option = text.nextInt();
                text.nextLine();
                System.out.println();
                System.out.println("================================================================================================================================================");
                switch (option) {
                    case 1:
                        System.out.println("\n==========================SUB-MENU==========================\n");
                        System.out.println("1:  Atomic Number.");
                        System.out.println("2:  Element.");
                        System.out.println("3:  Symbol.");
                        System.out.println("4:  Atomic Mass.");
                        System.out.println("\n============================================================\n");

                        int optionSubMenu = 0;
                        while (optionSubMenu != 1 && optionSubMenu != 2 && optionSubMenu != 3 && optionSubMenu != 4) {
                            System.out.print("Select the option by which you want to search for elements: ");
                            optionSubMenu = text.nextInt();
                            if (optionSubMenu != 1 && optionSubMenu != 2 && optionSubMenu != 3 && optionSubMenu != 4) {
                                System.out.println("Please enter a valid option!");
                            }
                        }

                        List<Element> listEx1 = new ArrayList<>();
                        TreeMap<String, TreeMap<String, Integer>> treeMapEx1;
                        text.nextLine();

                        switch (optionSubMenu) {
                            case 1:
                                int minimumAtomicNumber;
                                int maximumAtomicNumber;

                                System.out.print("\nInsert minimum Element's Atomic Number: ");
                                minimumAtomicNumber = text.nextInt();

                                do {
                                    System.out.print("\nInsert maximum Element's Atomic Number: ");
                                    maximumAtomicNumber = text.nextInt();
                                    if (maximumAtomicNumber < minimumAtomicNumber) {
                                        System.out.println("Please enter a Element's Atomic Number bigger than first!");
                                    }
                                } while (maximumAtomicNumber < minimumAtomicNumber);

                                listEx1 = app.getElementByAtomicNumber(minimumAtomicNumber, maximumAtomicNumber);
                                break;
                            case 2:
                                String minimumElement = null;
                                String maximumElement;

                                while (app.elementsList.getElementByElement(minimumElement) == null) {
                                    System.out.print("\nInsert minimum Element's Name: ");
                                    minimumElement = text.nextLine().trim();
                                    if (app.elementsList.getElementByElement(minimumElement) == null) {
                                        System.out.println("Please enter a valid Element's Name!");
                                    }
                                }

                                minimumElement = app.elementsList.getCorrectElement(minimumElement);

                                do {
                                    System.out.print("\nInsert maximum Element's Name: ");
                                    maximumElement = text.nextLine().trim();
                                    if (app.elementsList.getElementByElement(maximumElement) == null) {
                                        System.out.println("Please enter a valid Element's Name!");
                                    } else {

                                        assert minimumElement != null;

                                        maximumElement = app.elementsList.getCorrectElement(maximumElement);

                                        if ((maximumElement.compareTo(minimumElement)) < 0) {
                                            System.out.println("Please enter a Element's Name bigger than first!");
                                        }
                                    }
                                } while (app.elementsList.getElementByElement(maximumElement) == null || ((maximumElement.compareTo(Objects.requireNonNull(minimumElement))) < 0));

                                listEx1 = app.getElementByElement(minimumElement, maximumElement);
                                break;
                            case 3:
                                String minimumSymbol = null;
                                String maximumSymbol;

                                while (app.elementsList.getElementBySymbol(minimumSymbol) == null) {
                                    System.out.print("\nInsert minimum Element's Symbol: ");
                                    minimumSymbol = text.nextLine().trim();
                                    if (app.elementsList.getElementBySymbol(minimumSymbol) == null) {
                                        System.out.println("Please enter a valid Element's Symbol!");
                                    }
                                }

                                minimumSymbol = app.elementsList.getCorrectSymbol(minimumSymbol);

                                do {
                                    System.out.print("\nInsert maximum Element's Symbol: ");
                                    maximumSymbol = text.nextLine().trim();
                                    if (app.elementsList.getElementBySymbol(maximumSymbol) == null) {
                                        System.out.println("Please enter a valid Element's Symbol!");
                                    } else {

                                        assert minimumSymbol != null;

                                        maximumSymbol = app.elementsList.getCorrectSymbol(maximumSymbol);
                                        if ((maximumSymbol.compareTo(minimumSymbol)) < 0) {
                                            System.out.println("Please enter a Element's Symbol bigger than first!");
                                        }
                                    }
                                } while (app.elementsList.getElementBySymbol(maximumSymbol) == null || ((maximumSymbol.compareTo(Objects.requireNonNull(minimumSymbol))) < 0));

                                listEx1 = app.getElementBySymbol(minimumSymbol, maximumSymbol);
                                break;
                            case 4:
                                double minimumAtomicMass;
                                double maximumAtomicMass;

                                System.out.print("\nInsert minimum Element's Atomic Mass: ");
                                minimumAtomicMass = text.nextDouble();

                                do {
                                    System.out.print("\nInsert maximum Element's Atomic Mass: ");
                                    maximumAtomicMass = text.nextInt();
                                    if (maximumAtomicMass < minimumAtomicMass) {
                                        System.out.println("Please enter a EElement's Atomic Mass bigger than first!");
                                    }
                                } while (maximumAtomicMass < minimumAtomicMass);

                                listEx1 = app.getElementByAtomicMass(minimumAtomicMass, maximumAtomicMass);
                                break;
                        }

                        System.out.println("\nSearching....\n");

                        if (listEx1.isEmpty()) {
                            System.out.println("ERROR: No results!");
                        } else {
                            System.out.println("===============================================================================================================================================================");
                            System.out.printf("| %-13s | %-18s | %-6s | %-15s | %-12s | %-25s | %-28s | %-17s | \n", "Atomic Number", "Element", "Symbol", "Atomic Mass", "Phase", "Type", "Discoverer", "Year of Discovery");
                            System.out.println("===============================================================================================================================================================");
                            for (Element element : listEx1) {
                                String year = "";
                                if (element.getYearOfDiscovery() != -1) {
                                    year = "" + element.getYearOfDiscovery();
                                }
                                System.out.printf("| %-13s | %-18s | %-6s | %-15s | %-12s | %-25s | %-28s | %-17s | \n", element.getAtomicNumber(), element.getElement(), element.getSymbol(), element.getAtomicMass(), element.getPhase(), element.getType(), element.getDiscoverer(), year);
                            }
                            System.out.println("===============================================================================================================================================================\n\n");

                            treeMapEx1 = app.getGroupedByTypeAndPhase(listEx1);

                            System.out.println("======================================================================================================");
                            for (String group : treeMapEx1.keySet()) {
                                System.out.printf("| %-23s ", "");
                                for (String type : treeMapEx1.get(group).keySet()) {
                                    System.out.printf("| %-12s ", type);
                                }
                                System.out.printf("| %-12s |", "TOTAL");
                                break;
                            }
                            System.out.println("\n======================================================================================================");

                            for (String group : treeMapEx1.keySet()) {
                                System.out.printf("| %-23s ", group);
                                int total = 0;
                                for (String type : treeMapEx1.get(group).keySet()) {
                                    total = total + treeMapEx1.get(group).get(type);
                                    System.out.printf("| %-12s ", treeMapEx1.get(group).get(type));
                                }
                                System.out.printf("| %-12s |\n", total);
                            }
                            System.out.println("======================================================================================================\n");
                        }

                        break;
                    case 2:
                        Map<String, Integer> mapEx2 = app.getConfiguration();

                        int amount = -1;

                        if (!mapEx2.isEmpty()) {
                            for (String s : mapEx2.keySet()) {
                                if (amount == mapEx2.get(s)) {
                                    System.out.print(", " + s);
                                } else {
                                    if (amount != -1) {
                                        System.out.print("]");
                                    }
                                    System.out.printf("\n%-3d  [%s", mapEx2.get(s), s);
                                }
                                amount = mapEx2.get(s);
                            }
                            System.out.print("]\n");
                        } else {
                            System.out.println("No results!\n");
                        }
                        break;
                    case 3:
                        app.createConfigurationsOccurrencesTree();
                        System.out.println("\nTree created with success!\n");

                        System.out.println(app.elementsConfigurationOccurrencesTree.toString());
                        break;
                    case 4:
                        Map<List<ElectronicConfiguration>, Integer> mapEx4 = app.distanceBetweenTheTwoFurthestConfigurations();
                        List<ElectronicConfiguration> listEx4 = mapEx4.keySet().iterator().next();

                        System.out.printf("\nThe distance between the two furthest configurations (%s and %s) is: %d\n", listEx4.get(0).getElectronConfiguration(), listEx4.get(1).getElectronConfiguration(), mapEx4.get(listEx4));
                        break;
                    case 5:
                        if (app.createBinaryCompleteTree()) {
                            System.out.println("\nComplete Tree created with success!\n");
                            System.out.println(app.elementsConfigurationOccurrencesTree.toString());
                        } else {
                            System.out.println("\nImpossible create a Complete Tree!");
                        }
                        break;
                    case 0:
                        System.out.println("\nClosing program...");
                        System.out.println();
                        System.out.println("================================================================================================================================================");
                        break;
                    default:
                        System.out.println("\nInvalid option, try again...");
                        break;
                }
            }
        }
    }
}
