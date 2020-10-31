import java.util.Objects;

/**
 * The type ISO.
 */
public class ISO {

    /**
     * ISO code.
     */
    private final String code;
    /**
     * Continent.
     */
    private final Continent continent;
    /**
     * location.
     */
    private final String location;

    /**
     * Population.
     */
    private final long population;

    /**
     * Aged 65 Older.
     */
    private final float aged65Older;

    /**
     * Cardio Vascular Death Rate.
     */
    private final float cardiovascDeathRate;

    /**
     * Diabetes Prevalence.
     */
    private final float diabetesPrevalence;

    /**
     * Percentage of female smokers.
     */
    private final float femaleSmokers;
    /**
     * Percentage of male smokers.
     */
    private final float maleSmokers;

    /**
     * Hospital Beds Per Thousand.
     */
    private final float hospitalBedsPerThousand;

    /**
     * Life Expectancy.
     */
    private final float lifeExpectancy;

    /**
     * Instantiates a new Iso.
     *
     * @param code                    the ISO code
     * @param continent               the continent
     * @param location                the location
     * @param population              the population
     * @param aged65Older             the aged 65 older
     * @param cardiovascDeathRate     the cardio vascular death rate
     * @param diabetesPrevalence      the diabetes prevalence
     * @param femaleSmokers           the percentage of female smokers
     * @param maleSmokers             the percentage of male smokers
     * @param hospitalBedsPerThousand the hospital beds per thousand
     * @param lifeExpectancy          the life expectancy
     */
    public ISO(String code, Continent continent, String location, String population, String aged65Older, String cardiovascDeathRate,
               String diabetesPrevalence, String femaleSmokers, String maleSmokers, String hospitalBedsPerThousand, String lifeExpectancy) {
        this.code = this.checkStringData(code);
        this.continent = continent;
        this.location = this.checkStringData(location);
        this.population = this.checkPopulationData(population);
        this.aged65Older = this.checkNumericData(aged65Older);
        this.cardiovascDeathRate = this.checkNumericData(cardiovascDeathRate);
        this.diabetesPrevalence = this.checkNumericData(diabetesPrevalence);
        this.femaleSmokers = this.checkNumericData(femaleSmokers);
        this.maleSmokers = this.checkNumericData(maleSmokers);
        this.hospitalBedsPerThousand = this.checkNumericData(hospitalBedsPerThousand);
        this.lifeExpectancy = this.checkNumericData(lifeExpectancy);
    }

    /**
     * Gets ISO code.
     *
     * @return the ISO code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Gets continent.
     *
     * @return the continent
     */
    public Continent getContinent() {
        return this.continent;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Gets smokers percentage.
     *
     * @return the smokers percentage
     */
    public float getSmokersPercentage() {
        return this.femaleSmokers + this.maleSmokers;
    }

    /**
     * Check if the value in the file exists or if it is represented as NA.
     *
     * @param data the data
     * @return the value
     */
    public float checkNumericData(String data) {
        if (data.equalsIgnoreCase(Constants.NA_STRING) || data.equalsIgnoreCase("\"" + Constants.NA_STRING + "\"") || data.isEmpty())
            return 0;
        return Float.parseFloat(data);
    }

    /**
     * Check if the value in the file exists or if it is represented as NA.
     *
     * @param data the data
     * @return the population
     */
    public long checkPopulationData(String data) {
        if (data.equalsIgnoreCase(Constants.NA_STRING) || data.equalsIgnoreCase("\"" + Constants.NA_STRING + "\"") || data.isEmpty())
            return 0;
        return Long.parseLong(data);
    }

    /**
     * Check if the data in the file exists or if it is represented as NA.
     *
     * @param data the data
     * @return the string
     */
    public String checkStringData(String data) {
        if (data.equalsIgnoreCase(Constants.NA_STRING) || data.equalsIgnoreCase("\"" + Constants.NA_STRING + "\"") || data.isEmpty())
            return null;
        return data;
    }

    /**
     * Checks if two objects are equal.
     *
     * @param o ISO
     * @return true if two objects are equals and false if two objects are different
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ISO)) return false;
        ISO iso = (ISO) o;
        return Objects.equals(getCode(), iso.getCode());
    }

    /**
     * Generates the hash code.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return this.getCode().hashCode();
    }
}
