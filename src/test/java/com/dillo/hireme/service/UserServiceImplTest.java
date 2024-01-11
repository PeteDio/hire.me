package com.dillo.hireme.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.dillo.hireme.entity.Role;
import com.dillo.hireme.entity.User;
import com.dillo.hireme.repository.RoleRepository;
import com.dillo.hireme.repository.UserRepository;
import com.dillo.hireme.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;
@SpringBootTest
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @InjectMocks
    private UserServiceImpl userService;

//    @Test
//    public void testSaveUser() {
//        User user = new User();
//        user.setEmail("admin");
//        user.setPassword("password");
//        Role role = new Role();
//        role.setName("coordinator");
//        when(roleRepository.findByName(anyString())).thenReturn(role);
//        when(userRepository.save(any(User.class))).thenReturn(user);
//        userService.saveUser(user);
//        assertEquals(role, user.getRole());
//        verify(userRepository, times(2)).save(any(User.class));
//    }
//    @Test
//    public void testGetAllUsers() {
//        when(userRepository.findAll()).thenReturn(Collections.emptyList());
//        assertEquals(Collections.emptyList(), userService.getAllUsers());
//        verify(userRepository, times(1)).findAll();
//    }
    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        assertEquals(user, userService.getUserById(1L));
        verify(userRepository, times(1)).findById(1L);
    }
//    @Test
//    public void testGetUserByEmail() {
//        User user = new User();
//        user.setEmail("admin");
//        when(userRepository.findByEmail("admin")).thenReturn(user);
//        assertEquals(user, userService.getUserByEmail("admin"));
//        verify(userRepository, times(1)).findByEmail("admin");
//    }
//
//    @Test
//    public void testUpdateUser() {
//        User existingUser = new User();
//        existingUser.setId(1L);
//        existingUser.setFirstName("John");
//        existingUser.setLastName("Doe");
//        existingUser.setPassword("oldPassword");
//        User updatedUser = new User();
//        updatedUser.setId(1L);
//        updatedUser.setFirstName("Jane");
//        updatedUser.setLastName("Doe");
//        updatedUser.setPassword("newPassword");
//        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
//        userService.updateUser(1L, updatedUser);
//        assertEquals("Jane", existingUser.getFirstName());
//        assertEquals("Doe", existingUser.getLastName());
//        assertEquals("newPassword", existingUser.getPassword());
//        verify(userRepository, times(1)).save(existingUser);
//    }
//
//    @Test
//    public void testDeleteUser() {
//        doNothing().when(userRepository).deleteById(1L);
//        userService.deleteUser(1L);
//        verify(userRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testUpdateUserRole() {
//        User user = new User();
//        user.setId(1L);
//        Role updatedRole = new Role();
//        updatedRole.setId(2L);
//        updatedRole.setName("newRole");
//        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
//        when(roleRepository.findByName("newRole")).thenReturn(updatedRole);
//        userService.updateUserRole(1L, "newRole");
//        assertEquals(updatedRole, user.getRole());
//        verify(userRepository, times(1)).save(user);
//    }
//
//    @Test
//    public void testAuthenticate() {
//        User user = new User();
//        user.setEmail("admin");
//        user.setPassword("asdf1234");
//        when(userRepository.findByEmail("test@example.com")).thenReturn(user);
//        assertTrue(userService.authenticateUser("test@example.com", "password"));
//    }
}