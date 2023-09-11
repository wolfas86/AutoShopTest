package lt.codeacademy.javau5.autopart;



import lt.codeacademy.javau5.autopartshop.models.User;
import lt.codeacademy.javau5.autopartshop.repositories.UserRepository;
import lt.codeacademy.javau5.autopartshop.security.UserDetailsServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    public void loadUserByUsername_ShouldReturnUserDetails_WhenUserIsFound() {
        // given
        User testUser = new User();
        testUser.setUsername("testUsername");

        when(userRepository.findByUsername("testUsername")).thenReturn(Optional.of(testUser));

        // when
        userDetailsService.loadUserByUsername("testUsername");

        // then
        verify(userRepository).findByUsername("testUsername");
    }

    @Test
    public void loadUserByUsername_ShouldThrowUsernameNotFoundException_WhenUserIsNotFound() {
        // given
        when(userRepository.findByUsername("testUsername")).thenReturn(Optional.empty());

        // then
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("testUsername"));
    }
}
