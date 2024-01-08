package com.dillo.hireme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        // Allow public access to login and registration pages
                        .requestMatchers("/login", "/register").permitAll()
                        // Allow access to the dashboard for any authenticated user
                        .requestMatchers("/dashboard").authenticated()
                        // Define role-based access for other pages
                        .requestMatchers("/coordinator/**").hasRole("coordinator")
                        .requestMatchers("/recruiter/**").hasRole("recruiter")
                        .requestMatchers("/hiringmanager/**").hasRole("hiringmanager")
                        .requestMatchers("/admin/**").hasRole("admin")
                        // Allow CORS preflight requests
                        .requestMatchers(CorsUtils::isCorsRequest).permitAll()
                        // Require authentication for all other URLs
                        .anyRequest().authenticated()

                )
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/dashboard")
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login")
                );
        return http.build();
    }
}
