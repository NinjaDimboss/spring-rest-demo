package az.spring.rest.demo.springrestdemo.service;

import az.spring.rest.demo.springrestdemo.model.Registration;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.RegistrationResponse;

public interface RegistrationService {
    RegistrationResponse getAllRegistrations();
    RegistrationResponse getInfoByUsername (String username);
    void insert(RegistrationDto registrationDto);


}
