package az.spring.rest.demo.springrestdemo.service;

import az.spring.rest.demo.springrestdemo.model.Registration;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.RegistrationResponse;

public interface RegistrationService {
    RegistrationResponse getAllRegistrations();
    RegistrationDto getRegistration(long id);
    RegistrationResponse getInfoByUsername (String login);
    void insert(RegistrationDto registrationDto);
    void update(RegistrationDto registrationDto, long id);
    void updateSome(RegistrationDto registrationDto, long id);
    void delete(long id);
}
