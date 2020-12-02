package model;

import java.util.Objects;

/**
 * The type User.
 */
public class User implements Comparable<User> {

    /**
     * The user's id.
     */
    private String id;
    /**
     * The user's age.
     */
    private int age;
    /**
     * The user's city.
     */
    private String city;
    /**
     * The user's friends.
     */
    private int amountOfFriends;

    /**
     * Instantiates a new User.
     *
     * @param id   the user's id
     * @param age  the user's age
     * @param city the user's city
     */
    public User(String id, String age, String city) {
        this.id = id;
        this.age = Integer.parseInt(age);
        this.city = city;
        this.amountOfFriends = 0;
    }

    /**
     * Gets user's id.
     *
     * @return the user's id
     */
    public String getID() {
        return this.id;
    }

    /**
     * Gets user's city.
     *
     * @return the user's city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Gets amount of user's friends.
     *
     * @return the amount of user's friends
     */
    public int getAmountOfFriends() {
        return this.amountOfFriends;
    }

    /**
     * Add user's friend.
     */
    public void addFriend() {
        this.amountOfFriends = this.amountOfFriends + 1;
    }

    /**
     * Check if two users are equals.
     *
     * @param o User
     * @return true if two users are equals or false if two users are different
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    /**
     * Compare the amount of user's friends between two users.
     *
     * @param other User
     * @return -1 if user have more friends than other or 1 if user have less friends than other or 0 if they have the same amount of friends
     */
    @Override
    public int compareTo(User other) {
        return -Integer.compare(this.getAmountOfFriends(), other.getAmountOfFriends());
    }
}
