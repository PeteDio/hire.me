package com.dillo.hireme.service;

import com.dillo.hireme.entity.Role;
import com.dillo.hireme.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByEmail(String email);

    void updateUser(Long id, User updatedUser);

    void deleteUser(Long id);
    void updateUserRole(Long id, String roleName);
    boolean authenticateUser(String username, String password);
    List<Role> getAllUserRoles();

    List<User> getUsersByRoleId(Long roleId);
}
