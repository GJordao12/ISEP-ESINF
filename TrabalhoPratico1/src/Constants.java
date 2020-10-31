import java.time.LocalDate;
import java.time.Month;

/**
 * The type Constants.
 */
public class Constants {

    /**
     * The constant FILE_PATH.
     */
    public static final String FILE_PATH = "Files\\owid-covid-data.csv";
    /**
     * The constant NA_STRING.
     */
    public static final String NA_STRING = "NA";
    /**
     * The constant CASES.
     */
    public static final int CASES = 50000;
    /**
     * The constant INITIAL_DATE.
     */
    public static final LocalDate INITIAL_DATE = LocalDate.of(2020, Month.JANUARY, 1);
    /**
     * The constant SMOKERS_PERCENTAGE.
     */
    public static final double SMOKERS_PERCENTAGE = 70.0;
    /**
     * The constant FILE_SPLIT.
     */
    public static final String FILE_SPLIT = ",";
    /**
     * The constant DATE_SPLIT.
     */
    public static final String DATE_SPLIT = "-";

}
