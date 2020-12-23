import Tree.AVL;
import model.ElectronicConfiguration;
import model.Element;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Application test.
 */
public class ApplicationTest {

    /**
     * Instance of Application.
     */
    private final Application instance;

    /**
     * Instantiates a new Application test.
     */
    public ApplicationTest() {
        instance = new Application();
        instance.readElements();
    }

    /**
     * Read elements Test.
     */
    @Test
    public void readElements() {
        System.out.println("readElements()");

        int expResult1 = 118;

        System.out.println("Amount of Elements");
        assertEquals(expResult1, instance.elementsList.getElements().size());

        System.out.println("Amount of Elements Atomic Numbers");
        assertEquals(expResult1, instance.elementsAtomicNumberTree.size());

        System.out.println("Amount of Elements Name");
        assertEquals(expResult1, instance.elementsNameTree.size());

        System.out.println("Amount of Elements Symbol");
        assertEquals(expResult1, instance.elementsSymbolTree.size());

        System.out.println("Amount of Elements AtomicMass");
        assertEquals(expResult1, instance.elementsAtomicMassTree.size());

        int expResult2 = 96;

        System.out.println("Amount of Elements Configuration");
        assertEquals(expResult2, instance.elementsConfigurationTree.size());
    }

    /**
     * Gets element by atomic number Test.
     */
    @Test
    public void getElementByAtomicNumber() {
        System.out.println("getElementByAtomicNumber()");

        List<Element> listExpResult = new ArrayList<>();

        listExpResult.add(instance.elementsList.getElementByAtomicNumber(14));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(12));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(15));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(11));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(10));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(13));

        assertEquals(listExpResult, instance.getElementByAtomicNumber(10, 15));
    }

    /**
     * Gets element by element Test.
     */
    @Test
    public void getElementByElement() {
        System.out.println("getElementByElement()");

        List<Element> listExpResult = new ArrayList<>();

        listExpResult.add(instance.elementsList.getElementByAtomicNumber(58));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(27));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(55));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(20));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(6));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(17));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(98));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(24));

        assertEquals(listExpResult, instance.getElementByElement("Calcium", "Cobalt"));
    }

    /**
     * Gets element by symbol Test.
     */
    @Test
    public void getElementBySymbol() {
        System.out.println("getElementBySymbol()");

        List<Element> listExpResult = new ArrayList<>();

        listExpResult.add(instance.elementsList.getElementByAtomicNumber(33));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(85));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(56));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(5));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(79));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(18));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(95));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(4));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(13));

        assertEquals(listExpResult, instance.getElementBySymbol("Al", "Be"));
    }


    /**
     * Gets element by atomic mass Test.
     */
    @Test
    public void getElementByAtomicMass() {
        System.out.println("getElementByAtomicMass()");

        List<Element> listExpResult = new ArrayList<>();

        listExpResult.add(instance.elementsList.getElementByAtomicNumber(14));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(12));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(11));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(10));
        listExpResult.add(instance.elementsList.getElementByAtomicNumber(13));

        assertEquals(listExpResult, instance.getElementByAtomicMass(20, 30));
    }

    /**
     * Gets electronic configuration Test.
     */
    @Test
    public void getConfiguration() {
        System.out.println("getConfiguration()");

        Map<String, Integer> mapExpResult = new LinkedHashMap<>();

        mapExpResult.put("[Xe]", 32);
        mapExpResult.put("[Ar]", 18);
        mapExpResult.put("[Kr]", 18);
        mapExpResult.put("[Xe] 4f14", 17);
        mapExpResult.put("[Kr] 4d10", 9);
        mapExpResult.put("[Rn]", 9);
        mapExpResult.put("[Ar] 3d10", 8);
        mapExpResult.put("[He]", 8);
        mapExpResult.put("[Ne]", 8);
        mapExpResult.put("[Xe] 4f14 5d10", 8);
        mapExpResult.put("[Ar] 3d10 4s2", 7);
        mapExpResult.put("[He] 2s2", 7);
        mapExpResult.put("[Kr] 4d10 5s2", 7);
        mapExpResult.put("[Ne] 3s2", 7);
        mapExpResult.put("[Xe] 4f14 5d10 6s2", 7);
        mapExpResult.put("[Ar] 3d5", 2);
        mapExpResult.put("[Kr] 4d5", 2);
        mapExpResult.put("[Xe] 4f7", 2);

        assertEquals(mapExpResult, instance.getConfiguration());
    }

    /**
     * Create electronic configurations occurrences tree Test.
     */
    @Test
    public void createConfigurationsOccurrencesTree() {
        System.out.println("createConfigurationsOccurrencesTree()");

        AVL<ElectronicConfiguration> treeExpResult = new AVL<>();

        treeExpResult.insert(new ElectronicConfiguration("[Xe]", 32));
        treeExpResult.insert(new ElectronicConfiguration("[Ar]", 18));
        treeExpResult.insert(new ElectronicConfiguration("[Kr]", 18));
        treeExpResult.insert(new ElectronicConfiguration("[Xe] 4f14", 17));
        treeExpResult.insert(new ElectronicConfiguration("[Kr] 4d10", 9));
        treeExpResult.insert(new ElectronicConfiguration("[Rn]", 9));
        treeExpResult.insert(new ElectronicConfiguration("[Ar] 3d10", 8));
        treeExpResult.insert(new ElectronicConfiguration("[He]", 8));
        treeExpResult.insert(new ElectronicConfiguration("[Ne]", 8));
        treeExpResult.insert(new ElectronicConfiguration("[Xe] 4f14 5d10", 8));
        treeExpResult.insert(new ElectronicConfiguration("[Ar] 3d10 4s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[He] 2s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[Kr] 4d10 5s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[Ne] 3s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[Xe] 4f14 5d10 6s2", 7));

        instance.createConfigurationsOccurrencesTree();
        assertEquals(treeExpResult.toString(), instance.elementsConfigurationOccurrencesTree.toString());
    }

    /**
     * Distance between the two furthest electronic configurations Test.
     */
    @Test
    public void distanceBetweenTheTwoFurthestConfigurations() {
        System.out.println("createConfigurationOccurrencesTree()");

        ElectronicConfiguration ne = new ElectronicConfiguration("[Ne] 3s2", 7);
        ElectronicConfiguration ar = new ElectronicConfiguration("[Ar]", 18);

        List<ElectronicConfiguration> listAux = new ArrayList<>();
        listAux.add(ar);
        listAux.add(ne);

        Map<List<ElectronicConfiguration>, Integer> mapExpResult = new HashMap<>();
        mapExpResult.put(listAux, 7);

        assertEquals(mapExpResult.toString(), instance.distanceBetweenTheTwoFurthestConfigurations().toString());
    }

    /**
     * Create binary complete tree Test.
     */
    @Test
    public void createBinaryCompleteTree() {
        System.out.println("createBinaryCompleteTree()");

        AVL<ElectronicConfiguration> treeExpResult = new AVL<>();

        treeExpResult.insert(new ElectronicConfiguration("[Xe]", 32));
        treeExpResult.insert(new ElectronicConfiguration("[Ar]", 18));
        treeExpResult.insert(new ElectronicConfiguration("[Kr]", 18));
        treeExpResult.insert(new ElectronicConfiguration("[Xe] 4f14", 17));
        treeExpResult.insert(new ElectronicConfiguration("[Kr] 4d10", 9));
        treeExpResult.insert(new ElectronicConfiguration("[Rn]", 9));
        treeExpResult.insert(new ElectronicConfiguration("[Ar] 3d10", 8));
        treeExpResult.insert(new ElectronicConfiguration("[He]", 8));
        treeExpResult.insert(new ElectronicConfiguration("[Ne]", 8));
        treeExpResult.insert(new ElectronicConfiguration("[Xe] 4f14 5d10", 8));
        treeExpResult.insert(new ElectronicConfiguration("[Ar] 3d10 4s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[He] 2s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[Kr] 4d10 5s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[Ne] 3s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[Xe] 4f14 5d10 6s2", 7));
        treeExpResult.insert(new ElectronicConfiguration("[He] 2s1", 1));


        assertTrue(instance.createBinaryCompleteTree());
        assertEquals(treeExpResult.toString(), instance.elementsConfigurationOccurrencesTree.toString());
    }
}