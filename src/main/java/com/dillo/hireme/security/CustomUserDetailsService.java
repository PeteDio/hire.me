package com.dillo.hireme.security;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dillo.hireme.entity.Role;
import com.dillo.hireme.entity.User;
import com.dillo.hireme.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * Loads a user's details by their email address for authentication purposes.
     *
     * @param email The user's email address
     * @return UserDetails object containing the user's information and authorities
     * @throws UsernameNotFoundException If the user is not found
     */
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) {
        //find user
        User user = userRepository.findByEmail(email);
        //get user role
        Role role = user.getRole();
        //create authority base on role name
        GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        //return user details
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
