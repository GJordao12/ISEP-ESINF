package model;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Users List Test.
 */
class UsersListTest {

    private final UsersList ul;

    /**
     * Instantiates a new Users List Test.
     */
    public UsersListTest() {
        ul = new UsersList();
    }

    /**
     * Test gets user by id.
     */
    @org.junit.jupiter.api.Test
    void getUserById() {
        System.out.println("Get User By ID");
        User u1 = new User("u1", "12", "Lisboa");
        ul.registerUser(u1);
        assertEquals(u1, ul.getUserById("u1"));
    }
}