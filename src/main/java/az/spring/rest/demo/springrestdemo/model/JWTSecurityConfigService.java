package az.spring.rest.demo.springrestdemo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

public interface JWTSecurityConfigService {
    void configure(WebSecurity web);

    @Bean
    WebSecurityCustomizer webSecurityCustomizer();

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception;

    void configure(HttpSecurity http) throws Exception;
}
