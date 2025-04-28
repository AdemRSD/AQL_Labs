package TP3.Partie1.Exo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Test
    void testGetUserById_CallsFindUserByIdWithCorrectId() {
        // Arrange
        long userId = 1L;
        User expectedUser = new User(userId, "Alice");
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);
        UserService userService = new UserService(userRepository);

        // Act
        User actualUser = userService.getUserById(userId);

        // Assert
        assertNotNull(actualUser);
        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getName(), actualUser.getName());
        verify(userRepository).findUserById(userId);
    }
}
