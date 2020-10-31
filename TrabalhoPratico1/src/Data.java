/**
 * The type Data.
 */
public class Data {

    /**
     * Total covid cases.
     */
    private final int totalCases;
    /**
     * New covid cases.
     */
    private final int newCases;
    /**
     * Total covid deaths.
     */
    private final int totalDeaths;
    /**
     * New covid deaths.
     */
    private final int newDeaths;

    /**
     * Total covid tests.
     */
    private final int totalTests;

    /**
     * New covid tests.
     */
    private final int newTests;

    /**
     * Instantiates a new Data.
     *
     * @param totalCases  the total covid cases
     * @param newCases    the new covid cases
     * @param totalDeaths the total covid deaths
     * @param newDeaths   the new covid deaths
     * @param totalTests  the total covid tests
     * @param newTests    the new covid tests
     */
    public Data(String totalCases, String newCases, String totalDeaths, String newDeaths, String totalTests, String newTests) {
        this.totalCases = this.checkNumericData(totalCases);
        this.newCases = this.checkNumericData(newCases);
        this.totalDeaths = this.checkNumericData(totalDeaths);
        this.newDeaths = this.checkNumericData(newDeaths);
        this.totalTests = this.checkNumericData(totalTests);
        this.newTests = this.checkNumericData(newTests);
    }

    /**
     * Check if the value in the file exists or if it is represented as NA.
     *
     * @param data the data
     * @return the value
     */
    public int checkNumericData(String data) {
        if (data.equalsIgnoreCase(Constants.NA_STRING) || data.equalsIgnoreCase("\"" + Constants.NA_STRING + "\"") || data.isEmpty())
            return 0;
        return Integer.parseInt(data);
    }

    /**
     * Gets total covid cases.
     *
     * @return the total covid cases
     */
    public int getTotalCases() {
        return this.totalCases;
    }

    /**
     * Gets new covid cases.
     *
     * @return the new covid cases
     */
    public int getNewCases() {
        return this.newCases;
    }

    /**
     * Gets new covid deaths.
     *
     * @return the new covid deaths
     */
    public int getNewDeaths() {
        return this.newDeaths;
    }

    /**
     * Gets total covid deaths.
     *
     * @return the total covid deaths
     */
    public int getTotalDeaths() {
        return this.totalDeaths;
    }
}
