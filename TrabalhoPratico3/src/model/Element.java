package model;

/**
 * The type Element.
 */
public class Element {

    /**
     * The Atomic Aumber.
     */
    public int atomicNumber;
    /**
     * The Element.
     */
    public String element;
    /**
     * The Symbol.
     */
    public String symbol;
    /**
     * The Atomic Weight.
     */
    public double atomicWeight;
    /**
     * The Atomic Mass.
     */
    public double atomicMass;
    /**
     * The Period.
     */
    public int period;
    /**
     * The Group.
     */
    public int group;
    /**
     * The Phase.
     */
    public String phase;
    /**
     * The Most Stable Crystal.
     */
    public String mostStableCrystal;
    /**
     * The Type.
     */
    public String type;
    /**
     * The Ionic Radius.
     */
    public double ionicRadius;
    /**
     * The Atomic Radius.
     */
    public double atomicRadius;
    /**
     * The Electronegativity.
     */
    public double electronegativity;
    /**
     * The First Ionization Potential.
     */
    public double firstIonizationPotential;
    /**
     * The Density.
     */
    public double density;
    /**
     * The Melting Point.
     */
    public double meltingPoint;
    /**
     * The Boiling Point.
     */
    public double boilingPoint;
    /**
     * The Isotopes.
     */
    public int isotopes;
    /**
     * The Discoverer.
     */
    public String discoverer;
    /**
     * The Year of Discovery.
     */
    public int yearOfDiscovery;
    /**
     * The Specific Heat Capacity.
     */
    public double specificHeatCapacity;
    /**
     * The Electronic Configuration.
     */
    public String electronConfiguration;
    /**
     * The Display Row.
     */
    public int displayRow;
    /**
     * The Display Column.
     */
    public int displayColumn;

    /**
     * Instantiates a new Element.
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
     */
    public Element(String atomicNumber, String element, String symbol, String atomicWeight, String atomicMass, String period, String group, String phase, String mostStableCrystal, String type, String ionicRadius, String atomicRadius, String electronegativity, String firstIonizationPotential, String density, String meltingPoint, String boilingPoint, String isotopes, String discoverer, String yearOfDiscovery, String specificHeatCapacity, String electronConfiguration, String displayRow, String displayColumn) {
        this.atomicNumber = this.checkNumericDataIntegerNumbers(atomicNumber);
        this.element = this.checkStringData(element);
        this.symbol = this.checkStringData(symbol);
        this.atomicWeight = this.checkNumericDataDoubleNumbers(atomicWeight);
        this.atomicMass = this.checkNumericDataDoubleNumbers(atomicMass);
        this.period = this.checkNumericDataIntegerNumbers(period);
        this.group = this.checkNumericDataIntegerNumbers(group);
        this.phase = this.checkStringData(phase);
        this.mostStableCrystal = this.checkStringData(mostStableCrystal);
        this.type = this.checkStringData(type);
        this.ionicRadius = this.checkNumericDataDoubleNumbers(ionicRadius);
        this.atomicRadius = this.checkNumericDataDoubleNumbers(atomicRadius);
        this.electronegativity = this.checkNumericDataDoubleNumbers(electronegativity);
        this.firstIonizationPotential = this.checkNumericDataDoubleNumbers(firstIonizationPotential);
        this.density = this.checkNumericDataDoubleNumbers(density);
        this.meltingPoint = this.checkNumericDataDoubleNumbers(meltingPoint);
        this.boilingPoint = this.checkNumericDataDoubleNumbers(boilingPoint);
        this.isotopes = this.checkNumericDataIntegerNumbers(isotopes);
        this.discoverer = this.checkStringData(discoverer);
        this.yearOfDiscovery = this.checkNumericDataIntegerNumbers(yearOfDiscovery);
        this.specificHeatCapacity = this.checkNumericDataDoubleNumbers(specificHeatCapacity);
        this.electronConfiguration = this.checkStringData(electronConfiguration);
        this.displayRow = this.checkNumericDataIntegerNumbers(displayRow);
        this.displayColumn = this.checkNumericDataIntegerNumbers(displayColumn);
    }

    /**
     * Check if the string in the file exists.
     *
     * @param data the data
     * @return the data
     */
    public String checkStringData(String data) {
        if (data.isEmpty())
            return "";
        return data;
    }

    /**
     * Check if the value in the file exists.
     *
     * @param data the data
     * @return the value
     */
    public double checkNumericDataDoubleNumbers(String data) {
        if (data.isEmpty())
            return -1;
        return Double.parseDouble(data);
    }

    /**
     * Check if the value in the file exists.
     *
     * @param data the data
     * @return the value
     */
    public int checkNumericDataIntegerNumbers(String data) {
        if (data.isEmpty())
            return -1;
        return Integer.parseInt(data);
    }

    /**
     * Gets atomic number.
     *
     * @return the atomic number
     */
    public int getAtomicNumber() {
        return this.atomicNumber;
    }

    /**
     * Gets element.
     *
     * @return the element
     */
    public String getElement() {
        return this.element;
    }

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * Gets atomic mass.
     *
     * @return the atomic mass
     */
    public double getAtomicMass() {
        return this.atomicMass;
    }

    /**
     * Gets electronic configuration.
     *
     * @return the electronic configuration
     */
    public String getElectronConfiguration() {
        return this.electronConfiguration;
    }

    /**
     * Gets phase.
     *
     * @return the phase
     */
    public String getPhase() {
        return this.phase;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets discoverer.
     *
     * @return the discoverer
     */
    public String getDiscoverer() {
        return this.discoverer;
    }

    /**
     * Gets year of discovery.
     *
     * @return the year of discovery
     */
    public int getYearOfDiscovery() {
        return this.yearOfDiscovery;
    }

    /**
     * Compare order.
     *
     * @param o the o
     * @return 0 if they are equal, -1 if this is smaller than o and 1 if this is bigger than o
     */
    public int compareOrder(Element o) {
        //Se forem as duas maisculas ou as duas minusculas
        if (this.getDiscoverer().length() != 0 && o.getDiscoverer().length() != 0) {
            if ((this.getDiscoverer().substring(0, 1).toUpperCase().equals(this.getDiscoverer().substring(0, 1)) && o.getDiscoverer().substring(0, 1).toUpperCase().equals(o.getDiscoverer().substring(0, 1)))
                    || (this.getDiscoverer().substring(0, 1).toLowerCase().equals(this.getDiscoverer().substring(0, 1)) && o.getDiscoverer().substring(0, 1).toLowerCase().equals(o.getDiscoverer().substring(0, 1)))) {
                if (this.getDiscoverer().compareTo(o.getDiscoverer()) == 0) {
                    return Integer.compare(o.getYearOfDiscovery(), this.getYearOfDiscovery());
                }
                return this.getDiscoverer().compareTo(o.getDiscoverer());
            }
        }

        return -this.getDiscoverer().compareTo(o.getDiscoverer());
    }
}
