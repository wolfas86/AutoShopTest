package lt.codeacademy.javau5.autopart;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lt.codeacademy.javau5.autopartshop.models.Role;
import lt.codeacademy.javau5.autopartshop.models.User;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testSetAndGetId() {
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    public void testSetAndGetUsername() {
        user.setUsername("testUser");
        assertEquals("testUser", user.getUsername());
    }

    @Test
    public void testSetAndGetEmail() {
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        user.setPassword("securePassword");
        assertEquals("securePassword", user.getPassword());
    }

    @Test
    public void testSetAndGetRoles() {
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        roles.add(role);
        user.setRoles(roles);
        assertEquals(roles, user.getRoles());
    }

    @Test
    public void testConstructor() {
        User newUser = new User("testUser", "test@example.com", "securePassword");
        assertEquals("testUser", newUser.getUsername());
        assertEquals("test@example.com", newUser.getEmail());
        assertEquals("securePassword", newUser.getPassword());
    }
}
