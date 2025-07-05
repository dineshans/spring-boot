package com.app.config;

import com.app.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private JWTUtil jwtUtil;
    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(JWTUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/h2-console/**","/auth/register").permitAll()
                .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().disable())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager,
                                                   JWTUtil jwtUtil) throws Exception {
        /*JWTAuthenticationFilter jwtAutFilter = new JWTAuthenticationFilter(authenticationManager, jwtUtil);
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("api/user-registration").permitAll()
                .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(jwtAutFilter, UsernamePasswordAuthenticationFilter.class);*/
        JWTAuthenticationFilter jwtAutFilter = new JWTAuthenticationFilter(authenticationManager, jwtUtil);
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/auth/register", "/api/user-registration").permitAll()
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAutFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(daoAuthenticationProvider()));
    }

    /*public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("dinesh-1")
                .password(new BCryptPasswordEncoder().encode("password1"))
                .roles("ADMIN")
                .build();
        UserDetails user2 = User.withUsername("dinesh-2")
                .password(new BCryptPasswordEncoder().encode("password2"))
                .roles("OWNER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }*/
}
