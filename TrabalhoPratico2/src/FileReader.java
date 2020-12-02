import adjacencyMap.Graph;
import adjacencyMatrix.AdjacencyMatrixGraph;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The type File reader.
 */
public class FileReader {

    /**
     * The Users list.
     */
    public UsersList usersList;
    /**
     * The Countries list.
     */
    public CountriesList countriesList;
    /**
     * The Users Relationships.
     */
    public AdjacencyMatrixGraph<User, Integer> usersRelationships;
    /**
     * The Capitals Relations.
     */
    public Graph<String, Integer> capitalsRelations;
    /**
     * The File User Path.
     */
    public final String FILE_USER_PATH;
    /**
     * The File Country Path.
     */
    public final String FILE_COUNTRY_PATH;
    /**
     * The File Relationship Path.
     */
    public final String FILE_RELATIONSHIP_PATH;
    /**
     * The File Borders Path.
     */
    public final String FILE_BORDERS_PATH;
    /**
     * The Flag.
     */
    public boolean flag = true;

    /**
     * Instantiates a new File reader.
     *
     * @param app                    the application
     * @param FILE_USER_PATH         the file user path
     * @param FILE_COUNTRY_PATH      the file country path
     * @param FILE_RELATIONSHIP_PATH the file relationship path
     * @param FILE_BORDERS_PATH      the file borders path
     */
    public FileReader(Application app, String FILE_USER_PATH, String FILE_COUNTRY_PATH, String FILE_RELATIONSHIP_PATH, String FILE_BORDERS_PATH) {
        this.usersList = app.getUsersList();
        this.countriesList = app.getCountriesList();
        this.usersRelationships = app.getUsersRelationships();
        this.capitalsRelations = app.getCapitalsRelations();
        this.FILE_USER_PATH = FILE_USER_PATH;
        this.FILE_COUNTRY_PATH = FILE_COUNTRY_PATH;
        this.FILE_RELATIONSHIP_PATH = FILE_RELATIONSHIP_PATH;
        this.FILE_BORDERS_PATH = FILE_BORDERS_PATH;
    }

    /**
     * Run.
     */
    public void run() {
        readUsers();
        readRelationships();
        readCountries();
        readBorders();
    }

    /**
     * Read users.
     */
    void readUsers() {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(this.FILE_USER_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(Constants.FILE_SPLIT);
                User u = this.usersList.newUser(data[0].trim(), data[1].trim(), data[2].trim());
                if (!this.usersList.exitsUser(u)) {
                    this.usersList.registerUser(u);
                }
            }
        } catch (IOException io) {
            flag = false;
            System.out.println("\nERROR: File \"users\" has no information, please change the file and restart the Application!");
        } catch (ArrayIndexOutOfBoundsException ai) {
            flag = false;
            System.out.println("\nERROR: File \"users\" does not have all the necessary information, please change the file and restart the Application!");
        } catch (NumberFormatException nf) {
            flag = false;
            System.out.println("\nERROR: File \"users\" does not have the information placed correctly, please change the file and restart the Application!");
        }
    }

    /**
     * Read relationships.
     */
    void readRelationships() {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(this.FILE_RELATIONSHIP_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(Constants.FILE_SPLIT);
                User u1 = this.usersList.getUserById(data[0].trim());
                User u2 = this.usersList.getUserById(data[1].trim());
                if (this.usersList.exitsUser(u1) && this.usersList.exitsUser(u2)) {
                    if (!this.usersRelationships.checkVertex(u1)) {
                        this.usersRelationships.insertVertex(u1);
                    }
                    if (!this.usersRelationships.checkVertex(u2)) {
                        this.usersRelationships.insertVertex(u2);
                    }
                    this.usersRelationships.insertEdge(u1, u2, 1);
                    u1.addFriend();
                    u2.addFriend();
                }
            }
        } catch (IOException io) {
            flag = false;
            System.out.println("\nERROR: File \"relationships\" has no information, or does not exist, please change the file and restart the Application!");
        } catch (ArrayIndexOutOfBoundsException ai) {
            flag = false;
            System.out.println("\nERROR: File \"relationships\" does not have all the necessary information, please change the file and restart the Application!");
        } catch (NumberFormatException nf) {
            flag = false;
            System.out.println("\nERROR: File \"relationships\" does not have the information placed correctly, please change the file and restart the Application!");
        }
    }

    /**
     * Read countries.
     */
    void readCountries() {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(this.FILE_COUNTRY_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(Constants.FILE_SPLIT);
                Country c = this.countriesList.newCountry(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim());
                if (!this.countriesList.exitsCountry(c)) {
                    this.countriesList.registerCountry(c);
                }
            }
        } catch (IOException io) {
            flag = false;
            System.out.println("\nERROR: File \"countries\" has no information, or does not exist, please change the file and restart the Application!");
        } catch (ArrayIndexOutOfBoundsException ai) {
            flag = false;
            System.out.println("\nERROR: File \"countries\" does not have all the necessary information, please change the file and restart the Application!");
        } catch (NumberFormatException nf) {
            flag = false;
            System.out.println("\nERROR: File \"countries\" does not have the information placed correctly, please change the file and restart the Application!");
        }
    }

    /**
     * Read borders.
     */
    void readBorders() {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(this.FILE_BORDERS_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(Constants.FILE_SPLIT);
                Country c1 = this.countriesList.getCountryByCountry(data[0].trim());
                Country c2 = this.countriesList.getCountryByCountry(data[1].trim());
                if (this.countriesList.exitsCountry(c1) && this.countriesList.exitsCountry(c2)) {
                    if (!this.capitalsRelations.validVertex(c1.getCapital())) {
                        this.capitalsRelations.insertVertex(c1.getCapital());
                    }
                    if (!this.capitalsRelations.validVertex(c2.getCapital())) {
                        this.capitalsRelations.insertVertex(c2.getCapital());
                    }
                    this.capitalsRelations.insertEdge(c1.getCapital(), c2.getCapital(), 1, this.countriesList.getDistance(c1, c2));
                }
            }
        } catch (IOException io) {
            flag = false;
            System.out.println("\nERROR: File \"borders\" has no information, or does not exist, please change the file and restart the Application!");
        } catch (ArrayIndexOutOfBoundsException ai) {
            flag = false;
            System.out.println("\nERROR: File \"borders\" does not have all the necessary information, please change the file and restart the Application!");
        } catch (NumberFormatException nf) {
            flag = false;
            System.out.println("\nERROR: File \"borders\" does not have the information placed correctly, please change the file and restart the Application!");
        }
    }
}
