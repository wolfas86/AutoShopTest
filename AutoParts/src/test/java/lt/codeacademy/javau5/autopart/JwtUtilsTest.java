package lt.codeacademy.javau5.autopart;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.core.Authentication;

import lt.codeacademy.javau5.autopartshop.security.JwtUtils;
import lt.codeacademy.javau5.autopartshop.security.UserDetailsImpl;

@SpringBootTest
public class JwtUtilsTest {

    @MockBean
    private UserDetailsImpl userDetails;

    private JwtUtils jwtUtils;
    private Authentication authentication;


    @Test
    public void testGenerateJwtToken() {
        when(userDetails.getUsername()).thenReturn("testUser");
        
        String jwt = jwtUtils.generateJwtToken(authentication);

        assertNotNull(jwt);
    }

    @Test
    public void testGetUserNameFromJwtToken() {
        when(userDetails.getUsername()).thenReturn("testUser");
        
        String jwt = jwtUtils.generateJwtToken(authentication);

        String username = jwtUtils.getUserNameFromJwtToken(jwt);

        assertEquals("testUser", username);
    }

    @Test
    public void testValidateJwtToken() {
        when(userDetails.getUsername()).thenReturn("testUser");

        String jwt = jwtUtils.generateJwtToken(authentication);

        assertTrue(jwtUtils.validateJwtToken(jwt));
    }
}
