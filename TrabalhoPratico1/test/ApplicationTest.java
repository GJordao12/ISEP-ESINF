import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * The type Application test.
 */
class ApplicationTest {

    /**
     * Instance of Application.
     */
    private final Application instance;

    /**
     * Instantiates a new Application test.
     */
    public ApplicationTest() {
        instance = new Application();
        instance.readData();
    }

    /**
     * Reads the file and stores the information on the map test.
     */
    @Test
    public void readDataTest() {
        System.out.println("readData()");
        System.out.println("Amount of Locations");
        int expResultLocations = 210;
        assertEquals(expResultLocations, instance.map.keySet().size());
        System.out.println("Amount of Lines");
        int expResultLines = 46288;
        int resultLines = 0;
        for (ISO i : instance.map.keySet()) {
            resultLines += instance.map.get(i).size();
        }
        assertEquals(expResultLines, resultLines);
    }

    /**
     * locations ordered in ascending order of the minimum number of days that was necessary to reach 50000 positive cases test.
     */
    @Test
    void casesInMinDaysTest() {
        System.out.println("casesInMinDays()");
        Map<String, Integer> expMap = new LinkedHashMap<>();
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"CHN\"", "\"Asia\"", "\"China\"", "2020-02-13", 59865), 43);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ITA\"", "\"Europe\"", "\"Italy\"", "2020-03-22", 53578), 81);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ESP\"", "\"Europe\"", "\"Spain\"", "2020-03-25", 57506), 84);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"USA\"", "\"North America\"", "\"United States\"", "2020-03-25", 55231), 84);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"DEU\"", "\"Europe\"", "\"Germany\"", "2020-03-29", 52547), 88);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"FRA\"", "\"Europe\"", "\"France\"", "2020-04-01", 52128), 91);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"IRN\"", "\"Asia\"", "\"Iran\"", "2020-04-03", 50468), 93);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"GBR\"", "\"Europe\"", "\"United Kingdom\"", "2020-04-05", 53160), 95);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"TUR\"", "\"Asia\"", "\"Turkey\"", "2020-04-12", 52167), 102);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"RUS\"", "\"Europe\"", "\"Russia\"", "2020-04-22", 52763), 112);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"BRA\"", "\"South America\"", "\"Brazil\"", "2020-04-25", 52995), 115);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"CAN\"", "\"North America\"", "\"Canada\"", "2020-04-29", 50015), 119);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"BEL\"", "\"Europe\"", "\"Belgium\"", "2020-05-01", 50527), 121);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"PER\"", "\"South America\"", "\"Peru\"", "2020-05-06", 51189), 126);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"IND\"", "\"Asia\"", "\"India\"", "2020-05-07", 52952), 127);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"SAU\"", "\"Asia\"", "\"Saudi Arabia\"", "2020-05-17", 52016), 137);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"MEX\"", "\"North America\"", "\"Mexico\"", "2020-05-19", 51633), 139);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"CHL\"", "\"South America\"", "\"Chile\"", "2020-05-21", 53617), 141);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"PAK\"", "\"Asia\"", "\"Pakistan\"", "2020-05-22", 50694), 142);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"QAT\"", "\"Asia\"", "\"Qatar\"", "2020-05-29", 50914), 149);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"BGD\"", "\"Asia\"", "\"Bangladesh\"", "2020-06-03", 52445), 154);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ZAF\"", "\"Africa\"", "\"South Africa\"", "2020-06-09", 50879), 160);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"BLR\"", "\"Europe\"", "\"Belarus\"", "2020-06-10", 50265), 161);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"SWE\"", "\"Europe\"", "\"Sweden\"", "2020-06-13", 50349), 164);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"COL\"", "\"South America\"", "\"Colombia\"", "2020-06-15", 50939), 166);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"EGY\"", "\"Africa\"", "\"Egypt\"", "2020-06-19", 50437), 170);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ECU\"", "\"South America\"", "\"Ecuador\"", "2020-06-21", 50183), 172);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ARG\"", "\"South America\"", "\"Argentina\"", "2020-06-26", 52444), 177);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"IDN\"", "\"Asia\"", "\"Indonesia\"", "2020-06-26", 50187), 177);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"NLD\"", "\"Europe\"", "\"Netherlands\"", "2020-06-27", 50005), 178);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"IRQ\"", "\"Asia\"", "\"Iraq\"", "2020-07-02", 51524), 183);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ARE\"", "\"Asia\"", "\"United Arab Emirates\"", "2020-07-04", 50141), 185);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"KWT\"", "\"Asia\"", "\"Kuwait\"", "2020-07-07", 50644), 188);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"KAZ\"", "\"Asia\"", "\"Kazakhstan\"", "2020-07-08", 51059), 189);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"OMN\"", "\"Asia\"", "\"Oman\"", "2020-07-09", 50207), 190);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"PHL\"", "\"Asia\"", "\"Philippines\"", "2020-07-09", 50359), 190);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"UKR\"", "\"Europe\"", "\"Ukraine\"", "2020-07-09", 50414), 190);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"BOL\"", "\"South America\"", "\"Bolivia\"", "2020-07-15", 50867), 196);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"PAN\"", "\"North America\"", "\"Panama\"", "2020-07-17", 50373), 198);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"DOM\"", "\"North America\"", "\"Dominican Republic\"", "2020-07-18", 50113), 199);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ISR\"", "\"Asia\"", "\"Israel\"", "2020-07-20", 50289), 201);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"SGP\"", "\"Asia\"", "\"Singapore\"", "2020-07-27", 50369), 208);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"PRT\"", "\"Europe\"", "\"Portugal\"", "2020-07-27", 50164), 208);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ROU\"", "\"Europe\"", "\"Romania\"", "2020-08-01", 50886), 213);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"GTM\"", "\"North America\"", "\"Guatemala\"", "2020-08-02", 50979), 214);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"POL\"", "\"Europe\"", "\"Poland\"", "2020-08-08", 50324), 220);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"JPN\"", "\"Asia\"", "\"Japan\"", "2020-08-13", 50444), 225);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"HND\"", "\"North America\"", "\"Honduras\"", "2020-08-17", 50502), 229);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"NGA\"", "\"Africa\"", "\"Nigeria\"", "2020-08-20", 50488), 232);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"MAR\"", "\"Africa\"", "\"Morocco\"", "2020-08-23", 50812), 235);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"BHR\"", "\"Asia\"", "\"Bahrain\"", "2020-08-26", 50076), 238);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"ETH\"", "\"Africa\"", "\"Ethiopia\"", "2020-08-31", 51122), 243);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"VEN\"", "\"South America\"", "\"Venezuela\"", "2020-09-05", 50973), 248);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"CRI\"", "\"North America\"", "\"Costa Rica\"", "2020-09-10", 51224), 253);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"NPL\"", "\"Asia\"", "\"Nepal\"", "2020-09-11", 50465), 254);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"UZB\"", "\"Asia\"", "\"Uzbekistan\"", "2020-09-19", 50253), 262);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"DZA\"", "\"Africa\"", "\"Algeria\"", "2020-09-22", 50023), 265);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"CZE\"", "\"Europe\"", "\"Czech Republic\"", "2020-09-22", 50764), 265);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"CHE\"", "\"Europe\"", "\"Switzerland\"", "2020-09-22", 50264), 265);
        expMap.put(String.format("| %-15s | %-20s | %-25s | %-20s | %-20d", "\"MDA\"", "\"Europe\"", "\"Moldova\"", "2020-09-27", 50534), 270);
        assertEquals(expMap, instance.casesInMinDays());
    }

    /**
     * Total of new_cases/new_deaths by continent/month, ordered by continent/month test.
     */
    @Test
    void casesDeathsPerContMonthTest() {
        System.out.println("casesDeathsPerContMonth()");
        Map<String, Map<Integer, List<Integer>>> expMap = new LinkedHashMap<>();

        expMap.put("\"Africa\"", new LinkedHashMap<>());
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(0);
        expMap.get("\"Africa\"").put(1, list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        expMap.get("\"Africa\"").put(2, list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5134);
        list3.add(166);
        expMap.get("\"Africa\"").put(3, list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(31598);
        list4.add(1425);
        expMap.get("\"Africa\"").put(4, list4);
        List<Integer> list5 = new ArrayList<>();
        list5.add(105535);
        list5.add(2480);
        expMap.get("\"Africa\"").put(5, list5);
        List<Integer> list6 = new ArrayList<>();
        list6.add(251824);
        list6.add(5807);
        expMap.get("\"Africa\"").put(6, list6);
        List<Integer> list7 = new ArrayList<>();
        list7.add(516291);
        list7.add(9433);
        expMap.get("\"Africa\"").put(7, list7);
        List<Integer> list8 = new ArrayList<>();
        list8.add(336450);
        list8.add(10274);
        expMap.get("\"Africa\"").put(8, list8);
        List<Integer> list9 = new ArrayList<>();
        list9.add(220699);
        list9.add(5873);
        expMap.get("\"Africa\"").put(9, list9);

        expMap.put("\"Asia\"", new LinkedHashMap<>());
        List<Integer> list10 = new ArrayList<>();
        list10.add(9766);
        list10.add(213);
        expMap.get("\"Asia\"").put(1, list10);
        List<Integer> list11 = new ArrayList<>();
        list11.add(73473);
        list11.add(2679);
        expMap.get("\"Asia\"").put(2, list11);
        List<Integer> list12 = new ArrayList<>();
        list12.add(86771);
        list12.add(3997);
        expMap.get("\"Asia\"").put(3, list12);
        List<Integer> list13 = new ArrayList<>();
        list13.add(337267);
        list13.add(11375);
        expMap.get("\"Asia\"").put(4, list13);
        List<Integer> list14 = new ArrayList<>();
        list14.add(603767);
        list14.add(12005);
        expMap.get("\"Asia\"").put(5, list14);
        List<Integer> list15 = new ArrayList<>();
        list15.add(1148151);
        list15.add(25589);
        expMap.get("\"Asia\"").put(6, list15);
        List<Integer> list16 = new ArrayList<>();
        list16.add(1957780);
        list16.add(39565);
        expMap.get("\"Asia\"").put(7, list16);
        List<Integer> list17 = new ArrayList<>();
        list17.add(2809542);
        list17.add(46760);
        expMap.get("\"Asia\"").put(8, list17);
        List<Integer> list18 = new ArrayList<>();
        list18.add(3413861);
        list18.add(50030);
        expMap.get("\"Asia\"").put(9, list18);

        expMap.put("\"Europe\"", new LinkedHashMap<>());
        List<Integer> list19 = new ArrayList<>();
        list19.add(15);
        list19.add(0);
        expMap.get("\"Europe\"").put(1, list19);
        List<Integer> list20 = new ArrayList<>();
        list20.add(1136);
        list20.add(23);
        expMap.get("\"Europe\"").put(2, list20);
        List<Integer> list21 = new ArrayList<>();
        list21.add(436524);
        list21.add(27926);
        expMap.get("\"Europe\"").put(3, list21);
        List<Integer> list22 = new ArrayList<>();
        list22.add(855609);
        list22.add(105377);
        expMap.get("\"Europe\"").put(4, list22);
        List<Integer> list23 = new ArrayList<>();
        list23.add(613244);
        list23.add(42562);
        expMap.get("\"Europe\"").put(5, list23);
        List<Integer> list24 = new ArrayList<>();
        list24.add(454466);
        list24.add(15584);
        expMap.get("\"Europe\"").put(6, list24);
        List<Integer> list25 = new ArrayList<>();
        list25.add(458299);
        list25.add(10221);
        expMap.get("\"Europe\"").put(7, list25);
        List<Integer> list26 = new ArrayList<>();
        list26.add(764576);
        list26.add(9890);
        expMap.get("\"Europe\"").put(8, list26);
        List<Integer> list27 = new ArrayList<>();
        list27.add(1339629);
        list27.add(13456);
        expMap.get("\"Europe\"").put(9, list27);

        expMap.put("\"North America\"", new LinkedHashMap<>());
        List<Integer> list28 = new ArrayList<>();
        list28.add(9);
        list28.add(0);
        expMap.get("\"North America\"").put(1, list28);
        List<Integer> list29 = new ArrayList<>();
        list29.add(75);
        list29.add(0);
        expMap.get("\"North America\"").put(2, list29);
        List<Integer> list30 = new ArrayList<>();
        list30.add(176306);
        list30.add(3382);
        expMap.get("\"North America\"").put(3, list30);
        List<Integer> list31 = new ArrayList<>();
        list31.add(952660);
        list31.add(63107);
        expMap.get("\"North America\"").put(4, list31);
        List<Integer> list32 = new ArrayList<>();
        list32.add(872349);
        list32.add(55701);
        expMap.get("\"North America\"").put(5, list32);
        List<Integer> list33 = new ArrayList<>();
        list33.add(1043615);
        list33.add(42897);
        expMap.get("\"North America\"").put(6, list33);
        List<Integer> list34 = new ArrayList<>();
        list34.add(2271190);
        list34.add(48876);
        expMap.get("\"North America\"").put(7, list34);
        List<Integer> list35 = new ArrayList<>();
        list35.add(1852313);
        list35.add(52821);
        expMap.get("\"North America\"").put(8, list35);
        List<Integer> list36 = new ArrayList<>();
        list36.add(1450729);
        list36.add(37360);
        expMap.get("\"North America\"").put(9, list36);

        expMap.put("\"Oceania\"", new LinkedHashMap<>());
        List<Integer> list37 = new ArrayList<>();
        list37.add(7);
        list37.add(0);
        expMap.get("\"Oceania\"").put(1, list37);
        List<Integer> list38 = new ArrayList<>();
        list38.add(19);
        list38.add(0);
        expMap.get("\"Oceania\"").put(2, list38);
        List<Integer> list39 = new ArrayList<>();
        list39.add(5298);
        list39.add(21);
        expMap.get("\"Oceania\"").put(3, list39);
        List<Integer> list40 = new ArrayList<>();
        list40.add(2812);
        list40.add(95);
        expMap.get("\"Oceania\"").put(4, list40);
        List<Integer> list41 = new ArrayList<>();
        list41.add(503);
        list41.add(15);
        expMap.get("\"Oceania\"").put(5, list41);
        List<Integer> list42 = new ArrayList<>();
        list42.add(705);
        list42.add(2);
        expMap.get("\"Oceania\"").put(6, list42);
        List<Integer> list43 = new ArrayList<>();
        list43.add(8750);
        list43.add(87);
        expMap.get("\"Oceania\"").put(7, list43);
        List<Integer> list44 = new ArrayList<>();
        list44.add(11296);
        list44.add(432);
        expMap.get("\"Oceania\"").put(8, list44);
        List<Integer> list45 = new ArrayList<>();
        list45.add(3850);
        list45.add(312);
        expMap.get("\"Oceania\"").put(9, list45);

        expMap.put("\"South America\"", new LinkedHashMap<>());
        List<Integer> list46 = new ArrayList<>();
        list46.add(0);
        list46.add(0);
        expMap.get("\"South America\"").put(1, list46);
        List<Integer> list47 = new ArrayList<>();
        list47.add(1);
        list47.add(0);
        expMap.get("\"South America\"").put(2, list47);
        List<Integer> list48 = new ArrayList<>();
        list48.add(12354);
        list48.add(305);
        expMap.get("\"South America\"").put(3, list48);
        List<Integer> list49 = new ArrayList<>();
        list49.add(152202);
        list49.add(7797);
        expMap.get("\"South America\"").put(4, list49);
        List<Integer> list50 = new ArrayList<>();
        list50.add(688417);
        list50.add(31222);
        expMap.get("\"South America\"").put(5, list50);
        List<Integer> list51 = new ArrayList<>();
        list51.add(1336057);
        list51.add(44261);
        expMap.get("\"South America\"").put(6, list51);
        List<Integer> list52 = new ArrayList<>();
        list52.add(1841061);
        list52.add(58034);
        expMap.get("\"South America\"").put(7, list52);
        List<Integer> list53 = new ArrayList<>();
        list53.add(2206025);
        list53.add(59364);
        expMap.get("\"South America\"").put(8, list53);
        List<Integer> list54 = new ArrayList<>();
        list54.add(1735437);
        list54.add(48690);
        expMap.get("\"South America\"").put(9, list54);
        assertEquals(expMap, instance.casesDeathsPerContMonth());
    }

    /**
     * Locations ordered by decreasing order of the number of new positive cases each day for a given month and continent test.
     */
    @Test
    void contCasesPerDayOfMonthTest() {
        System.out.println("contCasesPerDayOfMonth()");
        Map<Integer, Map<String, Integer>> expMap = new LinkedHashMap<>();
        expMap.put(1, new LinkedHashMap<>());
        expMap.get(1).put("\"Ecuador\"", 0);
        expMap.get(1).put("\"Brazil\"", 0);
        expMap.put(2, new LinkedHashMap<>());
        expMap.get(2).put("\"Ecuador\"", 0);
        expMap.get(2).put("\"Brazil\"", 0);
        expMap.put(3, new LinkedHashMap<>());
        expMap.get(3).put("\"Ecuador\"", 0);
        expMap.get(3).put("\"Brazil\"", 0);
        expMap.put(4, new LinkedHashMap<>());
        expMap.get(4).put("\"Ecuador\"", 0);
        expMap.get(4).put("\"Brazil\"", 0);
        expMap.put(5, new LinkedHashMap<>());
        expMap.get(5).put("\"Ecuador\"", 0);
        expMap.get(5).put("\"Brazil\"", 0);
        expMap.put(6, new LinkedHashMap<>());
        expMap.get(6).put("\"Ecuador\"", 0);
        expMap.get(6).put("\"Brazil\"", 0);
        expMap.put(7, new LinkedHashMap<>());
        expMap.get(7).put("\"Ecuador\"", 0);
        expMap.get(7).put("\"Brazil\"", 0);
        expMap.put(8, new LinkedHashMap<>());
        expMap.get(8).put("\"Ecuador\"", 0);
        expMap.get(8).put("\"Brazil\"", 0);
        expMap.put(9, new LinkedHashMap<>());
        expMap.get(9).put("\"Ecuador\"", 0);
        expMap.get(9).put("\"Brazil\"", 0);
        expMap.put(10, new LinkedHashMap<>());
        expMap.get(10).put("\"Ecuador\"", 0);
        expMap.get(10).put("\"Brazil\"", 0);
        expMap.put(11, new LinkedHashMap<>());
        expMap.get(11).put("\"Ecuador\"", 0);
        expMap.get(11).put("\"Argentina\"", 0);
        expMap.get(11).put("\"Brazil\"", 0);
        expMap.put(12, new LinkedHashMap<>());
        expMap.get(12).put("\"Ecuador\"", 0);
        expMap.get(12).put("\"Argentina\"", 0);
        expMap.get(12).put("\"Brazil\"", 0);
        expMap.put(13, new LinkedHashMap<>());
        expMap.get(13).put("\"Ecuador\"", 0);
        expMap.get(13).put("\"Argentina\"", 0);
        expMap.get(13).put("\"Brazil\"", 0);
        expMap.put(14, new LinkedHashMap<>());
        expMap.get(14).put("\"Ecuador\"", 0);
        expMap.get(14).put("\"Argentina\"", 0);
        expMap.get(14).put("\"Brazil\"", 0);
        expMap.put(15, new LinkedHashMap<>());
        expMap.get(15).put("\"Ecuador\"", 0);
        expMap.get(15).put("\"Argentina\"", 0);
        expMap.get(15).put("\"Brazil\"", 0);
        expMap.put(16, new LinkedHashMap<>());
        expMap.get(16).put("\"Ecuador\"", 0);
        expMap.get(16).put("\"Argentina\"", 0);
        expMap.get(16).put("\"Brazil\"", 0);
        expMap.put(17, new LinkedHashMap<>());
        expMap.get(17).put("\"Ecuador\"", 0);
        expMap.get(17).put("\"Argentina\"", 0);
        expMap.get(17).put("\"Brazil\"", 0);
        expMap.put(18, new LinkedHashMap<>());
        expMap.get(18).put("\"Ecuador\"", 0);
        expMap.get(18).put("\"Argentina\"", 0);
        expMap.get(18).put("\"Brazil\"", 0);
        expMap.put(19, new LinkedHashMap<>());
        expMap.get(19).put("\"Ecuador\"", 0);
        expMap.get(19).put("\"Argentina\"", 0);
        expMap.get(19).put("\"Brazil\"", 0);
        expMap.put(20, new LinkedHashMap<>());
        expMap.get(20).put("\"Ecuador\"", 0);
        expMap.get(20).put("\"Argentina\"", 0);
        expMap.get(20).put("\"Brazil\"", 0);
        expMap.put(21, new LinkedHashMap<>());
        expMap.get(21).put("\"Ecuador\"", 0);
        expMap.get(21).put("\"Argentina\"", 0);
        expMap.get(21).put("\"Brazil\"", 0);
        expMap.put(22, new LinkedHashMap<>());
        expMap.get(22).put("\"Ecuador\"", 0);
        expMap.get(22).put("\"Argentina\"", 0);
        expMap.get(22).put("\"Brazil\"", 0);
        expMap.put(23, new LinkedHashMap<>());
        expMap.get(23).put("\"Ecuador\"", 0);
        expMap.get(23).put("\"Argentina\"", 0);
        expMap.get(23).put("\"Brazil\"", 0);
        expMap.put(24, new LinkedHashMap<>());
        expMap.get(24).put("\"Ecuador\"", 0);
        expMap.get(24).put("\"Argentina\"", 0);
        expMap.get(24).put("\"Brazil\"", 0);
        expMap.put(25, new LinkedHashMap<>());
        expMap.get(25).put("\"Ecuador\"", 0);
        expMap.get(25).put("\"Argentina\"", 0);
        expMap.get(25).put("\"Brazil\"", 0);
        expMap.put(26, new LinkedHashMap<>());
        expMap.get(26).put("\"Brazil\"", 1);
        expMap.get(26).put("\"Ecuador\"", 0);
        expMap.get(26).put("\"Argentina\"", 0);
        expMap.put(27, new LinkedHashMap<>());
        expMap.get(27).put("\"Ecuador\"", 0);
        expMap.get(27).put("\"Argentina\"", 0);
        expMap.get(27).put("\"Brazil\"", 0);
        expMap.put(28, new LinkedHashMap<>());
        expMap.get(28).put("\"Peru\"", 0);
        expMap.get(28).put("\"Ecuador\"", 0);
        expMap.get(28).put("\"Argentina\"", 0);
        expMap.get(28).put("\"Brazil\"", 0);
        expMap.put(29, new LinkedHashMap<>());
        expMap.get(29).put("\"Peru\"", 0);
        expMap.get(29).put("\"Ecuador\"", 0);
        expMap.get(29).put("\"Argentina\"", 0);
        expMap.get(29).put("\"Brazil\"", 0);
        assertEquals(expMap, instance.contCasesPerDayOfMonth(Continent.SA, 2));
    }

    /**
     * All Locations with more than 70% of smokers, ordered by decreasing order of the number of new deaths test.
     */
    @Test
    void smokersByNewDeathsTest() {
        System.out.println("smokersByNewDeaths()");
        Map<ISO, Integer> expMap = new LinkedHashMap<>();

        expMap.put(new ISO("\"RUS\"", Continent.EU, "\"Russia\"", "NA", "NA", "NA", "NA", "23.4", "58.3", "NA", "NA"), 20385);
        expMap.put(new ISO("\"CHL\"", Continent.SA, "\"Chile\"", "NA", "NA", "NA", "NA", "34.2", "41.5", "NA", "NA"), 12698);
        expMap.put(new ISO("\"IDN\"", Continent.AS, "\"Indonesia\"", "NA", "NA", "NA", "NA", "2.8", "76.1", "NA", "NA"), 10473);
        expMap.put(new ISO("\"BIH\"", Continent.EU, "\"Bosnia and Herzegovina\"", "NA", "NA", "NA", "NA", "30.2", "47.7", "NA", "NA"), 822);
        expMap.put(new ISO("\"BGR\"", Continent.EU, "\"Bulgaria\"", "NA", "NA", "NA", "NA", "30.1", "44.4", "NA", "NA"), 807);
        expMap.put(new ISO("\"SRB\"", Continent.EU, "\"Serbia\"", "NA", "NA", "NA", "NA", "37.7", "40.2", "NA", "NA"), 748);
        expMap.put(new ISO("\"GRC\"", Continent.EU, "\"Greece\"", "NA", "NA", "NA", "NA", "35.3", "52", "NA", "NA"), 383);
        expMap.put(new ISO("\"HRV\"", Continent.EU, "\"Croatia\"", "NA", "NA", "NA", "NA", "34.3", "39.9", "NA", "NA"), 272);
        expMap.put(new ISO("\"MNE\"", Continent.EU, "\"Montenegro\"", "NA", "NA", "NA", "NA", "44", "47.9", "NA", "NA"), 163);
        expMap.put(new ISO("\"CUB\"", Continent.NA, "\"Cuba\"", "NA", "NA", "NA", "NA", "17.1", "53.3", "NA", "NA"), 122);
        expMap.put(new ISO("\"LVA\"", Continent.EU, "\"Latvia\"", "NA", "NA", "NA", "NA", "25.6", "51", "NA", "NA"), 36);
        expMap.put(new ISO("\"CYP\"", Continent.EU, "\"Cyprus\"", "NA", "NA", "NA", "NA", "19.6", "52.7", "NA", "NA"), 22);
        expMap.put(new ISO("\"PNG\"", Continent.OC, "\"Papua New Guinea\"", "NA", "NA", "NA", "NA", "23.5", "48.8", "NA", "NA"), 7);
        expMap.put(new ISO("\"TLS\"", Continent.EU, "\"Timor\"", "NA", "NA", "NA", "NA", "6.3", "78.1", "NA", "NA"), 0);
        assertEquals(expMap, instance.smokersByNewDeaths());
    }
}