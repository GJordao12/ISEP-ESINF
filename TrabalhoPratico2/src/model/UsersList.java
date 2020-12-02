package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Users List.
 */
public class UsersList {

    /**
     * The User List.
     */
    public List<User> m_UserLst;

    /**
     * Instantiates a new Users List.
     */
    public UsersList() {
        this.m_UserLst = new ArrayList<>();
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        return this.m_UserLst;
    }

    /**
     * New user.
     *
     * @param id   the id
     * @param age  the age
     * @param city the city
     * @return the user
     */
    public User newUser(String id, String age, String city) {
        return new User(id, age, city);
    }

    /**
     * Register user.
     *
     * @param m_oUser the user
     */
    public void registerUser(User m_oUser) {
        this.m_UserLst.add(m_oUser);
    }

    /**
     * Check if one user exits.
     *
     * @param m_oUser the user
     * @return true if exists or false if it doesn't exists
     */
    public boolean exitsUser(User m_oUser) {
        return this.m_UserLst.contains(m_oUser);
    }

    /**
     * Gets user by id.
     *
     * @param userID the user's id
     * @return the user
     */
    public User getUserById(String userID) {
        for (User user : m_UserLst) {
            if (user.getID().equalsIgnoreCase(userID)) {
                return user;
            }
        }
        return null;
    }
}