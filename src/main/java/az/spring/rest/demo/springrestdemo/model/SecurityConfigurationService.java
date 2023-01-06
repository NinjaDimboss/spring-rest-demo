package az.spring.rest.demo.springrestdemo.model;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface SecurityConfigurationService {
    void configure(HttpSecurity httpSecurity) throws Exception;
}
