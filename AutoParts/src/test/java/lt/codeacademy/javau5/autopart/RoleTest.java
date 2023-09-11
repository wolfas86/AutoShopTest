package lt.codeacademy.javau5.autopart;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lt.codeacademy.javau5.autopartshop.models.ERole;
import lt.codeacademy.javau5.autopartshop.models.Role;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role();
    }

    @Test
    public void testSetAndGetId() {
        role.setId(1);
        assertEquals(Integer.valueOf(1), role.getId());
    }

    @Test
    public void testSetAndGetName() {
        role.setName(ERole.ROLE_USER); // Assuming ERole has a ROLE_USER value
        assertEquals(ERole.ROLE_USER, role.getName());
    }

    @Test
    public void testConstructor() {
        Role newRole = new Role(ERole.ROLE_USER); // Assuming ERole has a ROLE_USER value
        assertEquals(ERole.ROLE_USER, newRole.getName());
    }
}
