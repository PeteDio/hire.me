package com.dillo.hireme.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.dillo.hireme.entity.User;
import com.dillo.hireme.repository.UserRepository;
import com.dillo.hireme.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAuthenticateUser_Success() {
        // Arrange
        String username = "pedro@mail.com";
        String password = "asdf1234";
        User mockUser = new User();
        mockUser.setPassword(passwordEncoder.encode(password));

        when(userRepository.findByEmail(username)).thenReturn(mockUser);
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

        // Act
        boolean result = userService.authenticateUser(username, password);

        // Assert
        assertTrue(result);
    }

    @Test
    void testAuthenticateUser_WrongPassword() {
        // Arrange
        String username = "test@example.com";
        String password = "password123";
        User mockUser = new User();
        mockUser.setPassword(passwordEncoder.encode("differentPassword"));

        when(userRepository.findByEmail(username)).thenReturn(mockUser);
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(false);

        // Act
        boolean result = userService.authenticateUser(username, password);

        // Assert
        assertFalse(result);
    }
    @Test
    void testAuthenticateUser_UserNotFound() {
        // Arrange
        String username = "nonexistent@example.com";
        String password = "password123";

        when(userRepository.findByEmail(username)).thenReturn(null);

        // Act
        boolean result = userService.authenticateUser(username, password);

        // Assert
        assertFalse(result);
    }
}