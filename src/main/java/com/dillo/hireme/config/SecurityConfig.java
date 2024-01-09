package com.dillo.hireme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.csrf(csrf -> csrf.disable());

        http.authorizeRequests()
                        .requestMatchers(
                                new AntPathRequestMatcher("/")).authenticated()
                        .anyRequest().permitAll();
                http.formLogin(form -> form
                        // this is the URL for the login page
                        .loginPage("/login")
                        // this is the URL to submit the login form
                        .loginProcessingUrl("/login")
                        .permitAll()
                        .failureUrl("/login?error=true"));

                http.logout(
                        logout -> logout
                                .invalidateHttpSession(true)
                                // this is the URL to submit the logout form
                                .logoutUrl("/logout")
                                // this is the URL to go to after logout
                                .logoutSuccessUrl("/"));
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
