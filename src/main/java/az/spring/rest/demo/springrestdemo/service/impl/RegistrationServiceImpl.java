package az.spring.rest.demo.springrestdemo.service.impl;

import az.spring.rest.demo.springrestdemo.exception.IdNotFoundException;
import az.spring.rest.demo.springrestdemo.model.Registration;
import az.spring.rest.demo.springrestdemo.repository.RegistrationRepository;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationDto;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationRequestDto;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationResponseDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.RegistrationResponse;
import az.spring.rest.demo.springrestdemo.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class  RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;


    @Override
    public RegistrationResponse getAllRegistrations() {
        List<RegistrationDto> registrationDtoList = registrationRepository.findAll()
                .stream()
                .map(registration -> convertToDto(registration))
                .collect(Collectors.toList());
        return makeRegistrationResponse(registrationDtoList);

    }



    @Override
    public RegistrationResponse getInfoByUsername(String username) {
            List<RegistrationDto>registrations = registrationRepository.findByUsername(username)
                .stream()
                .map(registration -> convertToDto(registration))
                .collect(Collectors.toList());
            return makeRegistrationResponse(registrations);
    }

    @Override
    public RegistrationResponseDto insert(RegistrationRequestDto registrationRequestDto) {
        Registration registration = Registration.builder()
                .email(registrationRequestDto.getEmail())
                .username(registrationRequestDto.getUsername())
                .password(registrationRequestDto.getPassword())
                .build();
        //BeanUtils.copyProperties(registrationDto, registration);

        registration = registrationRepository.save(registration);
        RegistrationResponseDto dto = RegistrationResponseDto.builder()
                .id(registration.getId())
                .email(registration.getEmail())
                .username(registration.getUsername())
                .build();
        return dto;
    }




    private RegistrationDto convertToDto(Registration registration) {
        RegistrationDto registrationDto = new RegistrationDto();
        BeanUtils.copyProperties(registration, registrationDto);
        return registrationDto;
    }

    private RegistrationResponse makeRegistrationResponse(List<RegistrationDto> registrations) {
        return RegistrationResponse.builder()
                .registration(registrations)
                .build();

    }
    @Override
    public void delete(Integer id){
        registrationRepository.findById(id).orElseThrow(()-> new IdNotFoundException("Id not found. Id: " + id));
        registrationRepository.deleteById(id);
    }
}
