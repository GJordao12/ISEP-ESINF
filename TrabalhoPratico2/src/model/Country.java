package model;

import java.util.Objects;

/**
 * The type Country.
 */
public class Country {

    /**
     * The Country.
     */
    private String country;
    /**
     * The Continent.
     */
    private String continent;
    /**
     * The Population.
     */
    private float population;
    /**
     * The Capital.
     */
    private String capital;
    /**
     * The Latitude.
     */
    private double latitude;
    /**
     * The Longitude.
     */
    private double longitude;

    /**
     * Instantiates a new Country.
     *
     * @param country    the country
     * @param continent  the continent
     * @param population the population
     * @param capital    the capital
     * @param latitude   the latitude
     * @param longitude  the longitude
     */
    public Country(String country, String continent, String population, String capital, String latitude, String longitude) {
        this.country = country;
        this.continent = continent;
        this.population = Float.parseFloat(population);
        this.capital = capital;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Gets capital.
     *
     * @return the capital
     */
    public String getCapital() {
        return this.capital;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Check if two countries are equals.
     *
     * @param o User
     * @return true if two countries are equals or false if two countries are different
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country1 = (Country) o;
        return Objects.equals(getCountry(), country1.getCountry());
    }
}
