package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type User Test.
 */
class UserTest {

    /**
     * Test equals.
     */
    @org.junit.jupiter.api.Test
    void testEquals() {
        System.out.println("Equals to two equals users");
        User u1 = new User("u1", "12", "Lisboa");
        User u2 = new User("u1", "12", "Lisboa");
        assertEquals(true, u1.equals(u2));
        System.out.println("Equals to two different users");
        User u3 = new User("u3", "12", "Lisboa");
        User u4 = new User("u4", "12", "Lisboa");
        assertEquals(false, u3.equals(u4));
    }

    /**
     * Test compare to.
     */
    @org.junit.jupiter.api.Test
    void testCompareTo() {
        System.out.println("Compare To");
        User u1 = new User("u1", "12", "Lisboa");
        User u2 = new User("u1", "12", "Lisboa");
        u1.addFriend();
        assertEquals(-1, u1.compareTo(u2));
    }
}