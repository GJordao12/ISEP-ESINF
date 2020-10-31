import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Application.
 */
public class Application {

    /**
     * The Flag.
     */
    public boolean flag = true;
    /**
     * The Map with ISO, Date and Data about Covid.
     */
    public Map<ISO, TreeMap<LocalDate, Data>> map;

    /**
     * Instantiates a new Application.
     */
    public Application() {
        this.map = new LinkedHashMap<>();
    }

    /**
     * Reads the file and stores the information on the map.
     */
    void readData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_PATH));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(Constants.FILE_SPLIT);
                ISO i = new ISO(data[0].trim(), Continent.setContinent(data[1].trim()), data[2].trim(), data[10].trim(), data[11].trim(), data[12].trim(), data[13].trim(), data[14].trim(), data[15].trim(), data[16].trim(), data[17].trim());
                if (this.map.isEmpty() || !this.map.containsKey(i)) {
                    this.map.put(i, new TreeMap<>());
                }
                String[] StringDate = data[3].trim().split(Constants.DATE_SPLIT);
                LocalDate date = LocalDate.of(Integer.parseInt(StringDate[0]), Integer.parseInt(StringDate[1]), Integer.parseInt(StringDate[2]));
                this.map.get(i).put(date, new Data(data[4].trim(), data[5].trim(), data[6].trim(), data[7].trim(), data[8].trim(), data[9].trim()));
            }
        } catch (FileNotFoundException fne) {
            flag = false;
            System.out.println("\nERROR: File not Found, please insert a file and restart the Application!");
        } catch (IOException io) {
            flag = false;
            System.out.println("\nERROR: File has no information, please change the file and restart the Application!");
        } catch (ArrayIndexOutOfBoundsException ai) {
            flag = false;
            System.out.println("\nERROR: File does not have all the necessary information, please change the file and restart the Application!");
        } catch (NumberFormatException nf) {
            flag = false;
            System.out.println("\nERROR: File does not have the information placed correctly, please change the file and restart the Application!");
        } catch (DateTimeException dt) {
            flag = false;
            System.out.println("\nERROR: File does not have dates with the expected format (yyyy-mm-dd), please change the file and restart the Application!");
        }
    }

    /**
     * Returns a map of locations ordered in ascending order of the minimum number of days that was
     * necessary to reach 50000 positive cases.
     *
     * @return map of locations ordered in ascending order of the minimum number of days that was necessary to reach 50000 positive cases
     */
    Map<String, Integer> casesInMinDays() {

        Map<String, Integer> mapAux = new HashMap<>();

        for (ISO i : this.map.keySet()) {
            if (this.map.get(i).get(this.map.get(i).lastKey()).getTotalCases() > Constants.CASES) {
                for (LocalDate d : this.map.get(i).keySet()) {
                    if (this.map.get(i).get(d).getTotalCases() > Constants.CASES) {
                        String text = String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", i.getCode(), i.getContinent(), i.getLocation(), d.toString(), this.map.get(i).get(d).getTotalCases());
                        mapAux.put(text, (int) ChronoUnit.DAYS.between(Constants.INITIAL_DATE, d));
                        break;
                    }
                }
            }
        }
        return mapAux.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, content) -> content, LinkedHashMap::new));
    }

    /**
     * Returns a map with the total of new_cases/new_deaths by continent/month, ordered by continent/month.
     *
     * @return the map with the total of new_cases/new_deaths by continent/month, ordered by continent/month
     */
    TreeMap<String, TreeMap<Integer, List<Integer>>> casesDeathsPerContMonth() {

        TreeMap<String, TreeMap<Integer, List<Integer>>> mapAux = new TreeMap<>();

        for (ISO i : this.map.keySet()) {
            String continent = i.getContinent().toString();
            if (mapAux.isEmpty() || !mapAux.containsKey(continent)) {
                mapAux.put(continent, new TreeMap<>());
            }
            for (LocalDate d : this.map.get(i).keySet()) {
                int month = d.getMonthValue();
                if (mapAux.get(continent).isEmpty() || !mapAux.get(continent).containsKey(month)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(0);
                    list.add(0);
                    mapAux.get(continent).put(month, list);
                }
                mapAux.get(continent).get(month).set(0, this.map.get(i).get(d).getNewCases() + mapAux.get(continent).get(month).get(0));
                mapAux.get(continent).get(month).set(1, this.map.get(i).get(d).getNewDeaths() + mapAux.get(continent).get(month).get(1));
            }
        }
        return mapAux;
    }

    /**
     * Returns for each day of a given month and for a given continent, a map with the locations ordered by
     * decreasing order of the number of new positive cases.
     *
     * @param cont  the continent
     * @param month the month
     * @return a map with the locations ordered by decreasing order of the number of new positive cases
     */
    TreeMap<Integer, HashMap<String, Integer>> contCasesPerDayOfMonth(Continent cont, int month) {

        TreeMap<Integer, HashMap<String, Integer>> mapAux = new TreeMap<>();

        for (ISO i : this.map.keySet()) {
            if (i.getContinent().equals(cont)) {
                for (LocalDate d : this.map.get(i).keySet()) {
                    if (d.getMonthValue() == month) {
                        if (mapAux.isEmpty() || !mapAux.containsKey(d.getDayOfMonth())) {
                            mapAux.put(d.getDayOfMonth(), new HashMap<>());
                        }
                        mapAux.get(d.getDayOfMonth()).put(i.getLocation(), this.map.get(i).get(d).getNewCases());
                    }
                }
            }
        }
        mapAux.replaceAll((i, v) -> v.entrySet().stream().sorted((Map.Entry.<String, Integer>comparingByValue().reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, content) -> content, LinkedHashMap::new)));
        return mapAux;
    }

    /**
     * Returns a map with all locations with more than 70% of smokers, ordered by
     * decreasing order of the number of new deaths.
     *
     * @return the map with all locations with more than 70% of smokers, ordered by decreasing order of the number of new deaths
     */
    Map<ISO, Integer> smokersByNewDeaths() {

        Map<ISO, Integer> mapAux = new HashMap<>();
        for (ISO i : this.map.keySet()) {
            if (i.getSmokersPercentage() > Constants.SMOKERS_PERCENTAGE) {
                mapAux.put(i, this.map.get(i).get(this.map.get(i).lastKey()).getTotalDeaths());
            }
        }
        return mapAux.entrySet().stream().sorted((Map.Entry.<ISO, Integer>comparingByValue().reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, content) -> content, LinkedHashMap::new));
    }
}
