package az.spring.rest.demo.springrestdemo.service;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface SecurityConfigurationService extends SecurityFilterChain {
    void configure(HttpSecurity httpSecurity) throws Exception;

    @Override
    boolean matches(HttpServletRequest request);

    @Override
    List<Filter> getFilters();
}
