package az.spring.rest.demo.springrestdemo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.jwt.JwtDecoder;

@Service
public interface BasicConfigurationService {
    void configure(WebSecurity web);

    @Bean
    InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder);

    @Bean
    @DependsOn(value = "jwtDecoder")
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception;

    @Bean
    PasswordEncoder passwordEncoder();

    @Bean
    JwtDecoder jwtDecoder();
}
