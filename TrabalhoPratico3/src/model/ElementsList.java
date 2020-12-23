package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Elements List.
 */
public class ElementsList {

    /**
     * The Elements List.
     */
    public List<Element> m_ElementsLst;

    /**
     * Instantiates a new Elements List.
     */
    public ElementsList() {
        this.m_ElementsLst = new ArrayList<>();
    }

    /**
     * Gets elements.
     *
     * @return the elements
     */
    public List<Element> getElements() {
        return this.m_ElementsLst;
    }

    /**
     * New element element.
     *
     * @param atomicNumber             the atomic number
     * @param element                  the element
     * @param symbol                   the symbol
     * @param atomicWeight             the atomic weight
     * @param atomicMass               the atomic mass
     * @param period                   the period
     * @param group                    the group
     * @param phase                    the phase
     * @param mostStableCrystal        the most stable crystal
     * @param type                     the type
     * @param ionicRadius              the ionic radius
     * @param atomicRadius             the atomic radius
     * @param electronegativity        the electronegativity
     * @param firstIonizationPotential the first ionization potential
     * @param density                  the density
     * @param meltingPoint             the melting point
     * @param boilingPoint             the boiling point
     * @param isotopes                 the isotopes
     * @param discoverer               the discoverer
     * @param yearOfDiscovery          the year of discovery
     * @param specificHeatCapacity     the specific heat capacity
     * @param electronConfiguration    the electronic configuration
     * @param displayRow               the display row
     * @param displayColumn            the display column
     * @return the element
     */
    public Element newElement(String atomicNumber, String element, String symbol, String atomicWeight, String atomicMass, String period, String group, String phase, String mostStableCrystal, String type, String ionicRadius, String atomicRadius, String electronegativity, String firstIonizationPotential, String density, String meltingPoint, String boilingPoint, String isotopes, String discoverer, String yearOfDiscovery, String specificHeatCapacity, String electronConfiguration, String displayRow, String displayColumn) {
        return new Element(atomicNumber, element, symbol, atomicWeight, atomicMass, period, group, phase, mostStableCrystal, type, ionicRadius, atomicRadius, electronegativity, firstIonizationPotential, density, meltingPoint, boilingPoint, isotopes, discoverer, yearOfDiscovery, specificHeatCapacity, electronConfiguration, displayRow, displayColumn);
    }

    /**
     * Register element.
     *
     * @param m_oElement the element
     */
    public void registerElement(Element m_oElement) {
        this.m_ElementsLst.add(m_oElement);
    }

    /**
     * Check if one element exits.
     *
     * @param m_oElement the element
     * @return the boolean
     */
    public boolean exitsElement(Element m_oElement) {
        return this.m_ElementsLst.contains(m_oElement);
    }

    /**
     * Gets element by atomic number.
     *
     * @param atomicNumber the atomic number
     * @return the element
     */
    public Element getElementByAtomicNumber(int atomicNumber) {
        for (Element e : m_ElementsLst) {
            if (e.getAtomicNumber() == atomicNumber) {
                return e;
            }
        }
        return null;
    }

    /**
     * Gets element by element.
     *
     * @param element the element
     * @return the element
     */
    public Element getElementByElement(String element) {
        for (Element e : this.m_ElementsLst) {
            if (e.getElement().equalsIgnoreCase(element)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Gets element by symbol.
     *
     * @param symbol the symbol
     * @return the element
     */
    public Element getElementBySymbol(String symbol) {
        for (Element e : m_ElementsLst) {
            if (e.getSymbol().equalsIgnoreCase(symbol)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Gets element by atomic weight.
     *
     * @param atomicMass the atomic weight
     * @return the element
     */
    public Element getElementByAtomicMass(double atomicMass) {
        for (Element e : m_ElementsLst) {
            if (e.getAtomicMass() == atomicMass) {
                return e;
            }
        }
        return null;
    }

    /**
     * Gets correct string element.
     *
     * @param element the string
     * @return the correct string element
     */
    public String getCorrectElement(String element) {
        for (Element e : this.m_ElementsLst) {
            if (e.getElement().equalsIgnoreCase(element)) {
                return e.getElement();
            }
        }
        return null;
    }

    /**
     * Gets correct string symbol.
     *
     * @param symbol the string
     * @return the correct string symbol
     */
    public String getCorrectSymbol(String symbol) {
        for (Element e : m_ElementsLst) {
            if (e.getSymbol().equalsIgnoreCase(symbol)) {
                return e.getSymbol();
            }
        }
        return null;
    }
}
