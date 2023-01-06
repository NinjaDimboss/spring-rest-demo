package az.spring.rest.demo.springrestdemo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Service
@EnableSwagger2
public interface JWTSecurityConfigService extends SecurityConfigurationService{
    void configure(HttpSecurity http) throws Exception;
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception;

    void configure(WebSecurity web);
}
