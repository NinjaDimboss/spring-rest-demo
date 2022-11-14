package az.spring.rest.demo.springrestdemo.service;

import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationDto;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationRequestDto;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationResponseDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.RegistrationResponse;

public interface RegistrationService {
    RegistrationResponse getAllRegistrations();
    RegistrationResponse getInfoByUsername (String username);
    RegistrationResponseDto insert(RegistrationRequestDto registrationRequestDto);
    void delete(Integer id);
}
