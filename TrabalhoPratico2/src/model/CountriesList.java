package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Countries List.
 */
public class CountriesList {

    /**
     * The Country List.
     */
    public List<Country> m_CountryLst;

    /**
     * Instantiates a new Countries List.
     */
    public CountriesList() {
        this.m_CountryLst = new ArrayList<>();
    }

    /**
     * Gets countries.
     *
     * @return the countries
     */
    public List<Country> getCountries() {
        return this.m_CountryLst;
    }

    /**
     * New country country.
     *
     * @param country    the country
     * @param continent  the continent
     * @param population the population
     * @param capital    the capital
     * @param latitude   the latitude
     * @param longitude  the longitude
     * @return the country
     */
    public Country newCountry(String country, String continent, String population, String capital, String latitude, String longitude) {
        return new Country(country, continent, population, capital, latitude, longitude);
    }

    /**
     * Register country.
     *
     * @param m_oCountry the country
     */
    public void registerCountry(Country m_oCountry) {
        this.m_CountryLst.add(m_oCountry);
    }

    /**
     * Check if one country exits.
     *
     * @param m_oCountry the m o country
     * @return the boolean
     */
    public boolean exitsCountry(Country m_oCountry) {
        return this.m_CountryLst.contains(m_oCountry);
    }

    /**
     * Gets country by country.
     *
     * @param country the country
     * @return the country
     */
    public Country getCountryByCountry(String country) {
        for (Country c : m_CountryLst) {
            if (c.getCountry().equalsIgnoreCase(country)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Gets distance.
     *
     * @param c1 the country
     * @param c2 the country
     * @return the distance
     */
    public double getDistance(Country c1, Country c2) {
        double lat1 = c1.getLatitude();
        double lon1 = c1.getLongitude();
        double lat2 = c2.getLatitude();
        double lon2 = c2.getLongitude();
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) *
                    Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            return dist;
        }
    }
}
