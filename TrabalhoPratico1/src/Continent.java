/**
 * The enum Continent.
 */
public enum Continent {

    /**
     * Asia.
     */
    AS() {
        @Override
        public String toString() {
            return "\"Asia\"";
        }
    },
    /**
     * Europe.
     */
    EU() {
        @Override
        public String toString() {
            return "\"Europe\"";
        }
    },
    /**
     * Africa.
     */
    AF() {
        public String toString() {
            return "\"Africa\"";
        }
    },
    /**
     * North America.
     */
    NA() {
        @Override
        public String toString() {
            return "\"North America\"";
        }
    },
    /**
     * South America.
     */
    SA() {
        @Override
        public String toString() {
            return "\"South America\"";
        }
    },
    /**
     * Oceania.
     */
    OC() {
        @Override
        public String toString() {
            return "\"Oceania\"";
        }
    };

    /**
     * Checks if the continent exists.
     *
     * @param continent the string continent
     * @return the object continent or null if not exits
     */
    public static Continent setContinent(String continent) {
        for (Continent c : Continent.values()) {
            if (c.toString().equalsIgnoreCase(continent) || c.toString().equalsIgnoreCase("\"" + continent + "\"")) {
                return c;
            }
        }
        return null;
    }
}
