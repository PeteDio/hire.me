package com.dillo.hireme.service.impl;

import com.dillo.hireme.entity.Role;
import com.dillo.hireme.entity.User;
import com.dillo.hireme.repository.RoleRepository;
import com.dillo.hireme.repository.UserRepository;
import com.dillo.hireme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, @Qualifier("passwordEncoder") PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void saveUser(User user){
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        Role role = roleRepository.findByName("coordinator");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public void updateUser(Long id, User updatedUser) {
    User userToUpdate = getUserById(id);
    userToUpdate.setFirstName(updatedUser.getFirstName());
    userToUpdate.setLastName(updatedUser.getLastName());
    userToUpdate.setPassword(updatedUser.getPassword());
    userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
    userRepository.deleteById(id);
    }

    @Override
    public void updateUserRole(Long id, String roleName) {
        User userToUpdateRole = getUserById(id);
        Role updatedRole = roleRepository.findByName(roleName);
        userToUpdateRole.setRole(updatedRole);
        userRepository.save(userToUpdateRole);
    }

    public boolean authenticateUser(String username, String password) {
        User user = getUserByEmail(username);
        if (user != null) {
            // Check if the provided password matches the stored hashed password
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public List<Role> getAllUserRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<User> getUsersByRoleId(Long roleId) {
        return userRepository.findByRoleId(roleId);
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("admin");
        return roleRepository.save(role);
    }
}
