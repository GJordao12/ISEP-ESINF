import Tree.AVL;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Application.
 */
public class Application {
    /**
     * The Elements List.
     */
    public ElementsList elementsList;
    /**
     * The Elements Atomic Number Tree.
     */
    public AVL<Integer> elementsAtomicNumberTree;
    /**
     * The Elements Name Tree.
     */
    public AVL<String> elementsNameTree;
    /**
     * The Elements Symbol Tree.
     */
    public AVL<String> elementsSymbolTree;
    /**
     * The Elements Atomic Mass Tree.
     */
    public AVL<Double> elementsAtomicMassTree;
    /**
     * The Elements Configuration Tree.
     */
    public AVL<String> elementsConfigurationTree;
    /**
     * The Elements Configuration Occurrences Tree.
     */
    public AVL<ElectronicConfiguration> elementsConfigurationOccurrencesTree;
    /**
     * The Flag.
     */
    public boolean flag;

    /**
     * Instantiates a new Application.
     */
    public Application() {
        this.elementsList = new ElementsList();
        this.elementsAtomicNumberTree = new AVL<>();
        this.elementsNameTree = new AVL<>();
        this.elementsSymbolTree = new AVL<>();
        this.elementsAtomicMassTree = new AVL<>();
        this.elementsConfigurationTree = new AVL<>();
        this.elementsConfigurationOccurrencesTree = new AVL<>();
        this.flag = true;
    }

    /**
     * Read elements.
     */
    void readElements() {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(Constants.FILE_PATH));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(Constants.FILE_SPLIT);
                Element fullElement = this.elementsList.newElement(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim(), data[6].trim(),
                        data[7].trim(), data[8].trim(), data[9].trim(), data[10].trim(), data[11].trim(), data[12].trim(), data[13].trim(), data[14].trim(), data[15].trim(),
                        data[16].trim(), data[17].trim(), data[18].trim(), data[19].trim(), data[20].trim(), data[21].trim(), data[22].trim(), data[23].trim());
                if (!this.elementsList.exitsElement(fullElement)) {
                    this.elementsList.registerElement(fullElement);
                    this.elementsAtomicNumberTree.insert(fullElement.getAtomicNumber());
                    this.elementsNameTree.insert(fullElement.getElement());
                    this.elementsSymbolTree.insert(fullElement.getSymbol());
                    this.elementsAtomicMassTree.insert(fullElement.getAtomicMass());
                    this.elementsConfigurationTree.insert(fullElement.getElectronConfiguration());
                }
            }
        } catch (IOException io) {
            flag = false;
            System.out.println("\nERROR: File has no information, please change the file and restart the Application!");
        } catch (ArrayIndexOutOfBoundsException ai) {
            flag = false;
            System.out.println("\nERROR: File does not have all the necessary information, please change the file and restart the Application!");
        } catch (NumberFormatException nf) {
            flag = false;
            System.out.println("\nERROR: File does not have the information placed correctly, please change the file and restart the Application!");
        }
    }

    /**
     * Gets element by atomic number.
     *
     * @param minimumAtomicNumber the atomic number
     * @param maximumAtomicNumber the maximum atomic number
     * @return the list with elements
     */
    public List<Element> getElementByAtomicNumber(int minimumAtomicNumber, int maximumAtomicNumber) {
        List<Element> listWithElements = new ArrayList<>();

        if (minimumAtomicNumber == maximumAtomicNumber) {
            Element e = this.elementsList.getElementByAtomicNumber(minimumAtomicNumber);
            if (e != null) {
                listWithElements.add(e);
            }
        } else {
            for (Integer atomicNumber : this.elementsAtomicNumberTree.find(this.elementsAtomicNumberTree.root, minimumAtomicNumber, maximumAtomicNumber)) {
                listWithElements.add(this.elementsList.getElementByAtomicNumber(atomicNumber));
            }
        }

        if (!listWithElements.isEmpty()) {
            listWithElements.sort(Element::compareOrder);
        }

        return listWithElements;
    }

    /**
     * Gets element by element.
     *
     * @param minimumElement the minimum element
     * @param maximumElement the maximum element
     * @return the list with elements
     */
    public List<Element> getElementByElement(String minimumElement, String maximumElement) {
        List<Element> listWithElements = new ArrayList<>();

        if (minimumElement.equalsIgnoreCase(maximumElement)) {
            Element e = this.elementsList.getElementByElement(minimumElement);
            if (e != null) {
                listWithElements.add(e);
            }
        } else {
            for (String element : this.elementsNameTree.find(this.elementsNameTree.root, minimumElement, maximumElement)) {
                listWithElements.add(this.elementsList.getElementByElement(element));
            }

            if (!listWithElements.isEmpty()) {
                listWithElements.sort(Element::compareOrder);
            }
        }

        return listWithElements;
    }

    /**
     * Gets element by symbol.
     *
     * @param minimumSymbol the minimum symbol
     * @param maximumSymbol the maximum symbol
     * @return the list with elements
     */
    public List<Element> getElementBySymbol(String minimumSymbol, String maximumSymbol) {
        List<Element> listWithElements = new ArrayList<>();

        if (minimumSymbol.equalsIgnoreCase(maximumSymbol)) {
            Element e = this.elementsList.getElementBySymbol(minimumSymbol);
            if (e != null) {
                listWithElements.add(e);
            }
        } else {
            for (String symbol : this.elementsSymbolTree.find(this.elementsSymbolTree.root, minimumSymbol, maximumSymbol)) {
                listWithElements.add(this.elementsList.getElementBySymbol(symbol));
            }
        }

        if (!listWithElements.isEmpty()) {
            listWithElements.sort(Element::compareOrder);
        }

        return listWithElements;
    }

    /**
     * Gets element by atomic weight.
     *
     * @param minimumAtomicMass the minimum atomic weight
     * @param maximumAtomicMass the maximum atomic weight
     * @return the list with elements
     */
    List<Element> getElementByAtomicMass(double minimumAtomicMass, double maximumAtomicMass) {
        List<Element> listWithElements = new ArrayList<>();

        if (minimumAtomicMass == maximumAtomicMass) {
            Element e = this.elementsList.getElementByAtomicMass(minimumAtomicMass);
            if (e != null) {
                listWithElements.add(e);
            }
        } else {
            for (Double atomicMass : this.elementsAtomicMassTree.find(this.elementsAtomicMassTree.root, minimumAtomicMass, maximumAtomicMass)) {
                listWithElements.add(this.elementsList.getElementByAtomicMass(atomicMass));
            }
        }

        if (!listWithElements.isEmpty()) {
            listWithElements.sort(Element::compareOrder);
        }

        return listWithElements;
    }

    /**
     * Gets electronic configurations.
     *
     * @return the map with electronic configurations and occurrences
     */
    Map<String, Integer> getConfiguration() {
        Map<String, Integer> mapWithNecessaryInformation = new LinkedHashMap<>();

        TreeMap<String, Integer> mapAux = this.elementsConfigurationTree.findOccurrences(this.elementsConfigurationTree.root);

        for (String s : mapAux.keySet()) {
            if (mapAux.get(s) > 1) {
                mapWithNecessaryInformation.put(s, mapAux.get(s));
            }
        }

        return mapWithNecessaryInformation.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue, (key, content) -> content, LinkedHashMap::new));
    }

    /**
     * Create electronic configurations occurrences tree.
     */
    void createConfigurationsOccurrencesTree() {

        if (this.elementsConfigurationOccurrencesTree.size() == 0) {

            Map<String, Integer> mapAux = getConfiguration();

            for (String s : mapAux.keySet()) {
                if (mapAux.get(s) > 2) {
                    ElectronicConfiguration c = new ElectronicConfiguration(s, mapAux.get(s));
                    this.elementsConfigurationOccurrencesTree.insert(c);
                }
            }
        }
    }

    /**
     * Distance between the two furthest electronic configurations.
     *
     * @return the distance and the two electronic configurations
     */
    Map<List<ElectronicConfiguration>, Integer> distanceBetweenTheTwoFurthestConfigurations() {

        createConfigurationsOccurrencesTree();

        return this.elementsConfigurationOccurrencesTree.findMaximumDistance();
    }

    /**
     * Create binary complete tree.
     *
     * @return the boolean
     */
    boolean createBinaryCompleteTree() {
        createConfigurationsOccurrencesTree();

        boolean isComplete = this.elementsConfigurationOccurrencesTree.isComplete();

        if (!isComplete) {
            List<String> uniqueElectronicConfigurations = new ArrayList<>();

            TreeMap<String, Integer> mapAux = this.elementsConfigurationTree.findOccurrences(this.elementsConfigurationTree.root);

            for (String s : mapAux.keySet()) {
                if (mapAux.get(s) == 1) {
                    uniqueElectronicConfigurations.add(s);
                }
            }

            int count = 0;

            while (count < uniqueElectronicConfigurations.size()) {
                ElectronicConfiguration c = new ElectronicConfiguration(uniqueElectronicConfigurations.get(count), 1);
                this.elementsConfigurationOccurrencesTree = new AVL<>();
                createConfigurationsOccurrencesTree();
                this.elementsConfigurationOccurrencesTree.insert(c);
                count++;
                isComplete = this.elementsConfigurationOccurrencesTree.isComplete();
                if (isComplete) {
                    break;
                }
            }
        }

        return isComplete;

    }

    /**
     * Gets grouped by type and phase.
     *
     * @param listWithElements the list with elements
     * @return the map grouped by type and phase
     */
    TreeMap<String, TreeMap<String, Integer>> getGroupedByTypeAndPhase(List<Element> listWithElements) {
        TreeMap<String, TreeMap<String, Integer>> mapAux = new TreeMap<>();

        for (Element e : listWithElements) {
            String type;
            if (e.getType().length() == 0) {
                type = "(Without Type)";
            } else {
                type = e.getType();
            }
            if (mapAux.isEmpty() || !mapAux.containsKey(type)) {
                mapAux.put(type, new TreeMap<>());
                mapAux.get(type).put("artificial", 0);
                mapAux.get(type).put("gas", 0);
                mapAux.get(type).put("liq", 0);
                mapAux.get(type).put("solid", 0);
            }

            int amountIndividual = mapAux.get(type).get(e.getPhase()) + 1;
            mapAux.get(type).put(e.getPhase(), amountIndividual);
        }

        return mapAux;
    }
}
