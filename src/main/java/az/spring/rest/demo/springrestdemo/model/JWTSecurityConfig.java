package az.spring.rest.demo.springrestdemo.model;

import az.spring.rest.demo.springrestdemo.repository.RegistrationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebSecurity
@Service

public class JWTSecurityConfig implements JWTSecurityConfigService {
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v3/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/**",
                "/swagger-ui.html",
                "http://localhost:8088/swagger-ui/index.html#/",
                "/swagger-ui/**");
    }
    @Override
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers();
    }
    private final RegistrationRepository registrationRepository;


    public JWTSecurityConfig(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Bean
    @Override
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(authz -> authz.antMatchers(HttpMethod.GET, "/**")
                        .hasAuthority("Qəbul etmə")
                        .antMatchers(HttpMethod.POST, "/**").permitAll()
                        .anyRequest()
                        .authenticated())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return httpSecurity.build();
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/loggin").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger-resources/**").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger-ui/**").permitAll()
                .antMatchers(HttpMethod.POST,"/swagger-ui/**").permitAll()
                .antMatchers(HttpMethod.GET,"/v2/api-docs").permitAll()
                .anyRequest()
                .authenticated();
    }


    @Configuration
    @Service
    @EnableSwagger2
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
    public class SecurityConfigurationService implements az.spring.rest.demo.springrestdemo.model.SecurityConfigurationService {
        private static final String[] AUTH_WHITELIST = {

                "/v2/api-docs/**",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui/index.html#/"
        };
        @Override
        public void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.authorizeRequests()
                    .antMatchers(AUTH_WHITELIST).permitAll()
                    .antMatchers("/swagger-ui/**", "swagger-ui/index.html#/").authenticated();

        }
    }
}



