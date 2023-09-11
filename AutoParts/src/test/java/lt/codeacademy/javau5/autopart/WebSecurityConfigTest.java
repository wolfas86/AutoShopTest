package lt.codeacademy.javau5.autopart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class WebSecurityConfigTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncoderShouldBeInstanceOfBCryptPasswordEncoder() {
        assertTrue(passwordEncoder instanceof BCryptPasswordEncoder);
    }
}
