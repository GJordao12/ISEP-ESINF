package model;

import java.util.Objects;

/**
 * The type Configuration.
 */
public class ElectronicConfiguration implements Comparable<ElectronicConfiguration> {

    /**
     * The Electronic Configuration.
     */
    public String electronConfiguration;
    /**
     * The Occurrences.
     */
    public int occurrences;

    /**
     * Instantiates a new Electronic Configuration.
     *
     * @param electronicConfiguration the electronic configuration
     * @param occurrences             the occurrences
     */
    public ElectronicConfiguration(String electronicConfiguration, int occurrences) {
        this.electronConfiguration = electronicConfiguration;
        this.occurrences = occurrences;
    }

    /**
     * Gets occurrences.
     *
     * @return the occurrences
     */
    public int getOccurrences() {
        return this.occurrences;
    }

    /**
     * Gets electronic configuration.
     *
     * @return the electron configuration
     */
    public String getElectronConfiguration() {
        return this.electronConfiguration;
    }

    /**
     * Compare to electronic configuration objects.
     *
     * @param o object
     * @return 0 if they are equal, -1 if this is smaller than o and 1 if this is bigger than o
     */
    @Override
    public int compareTo(ElectronicConfiguration o) {
        return this.getElectronConfiguration().compareTo(o.getElectronConfiguration());
    }

    /**
     * Check if two electronic configuration objects are equal.
     *
     * @param o object
     * @return true if they are equal or false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectronicConfiguration)) return false;
        ElectronicConfiguration that = (ElectronicConfiguration) o;
        return Objects.equals(getElectronConfiguration(), that.getElectronConfiguration());
    }

    /**
     * String representation of the electronic configuration.
     *
     * @return String representation of the electronic configuration
     */
    @Override
    public String toString() {
        return String.format("Configuration: %s Occurrences: %d", this.getElectronConfiguration(), this.getOccurrences());
    }
}
