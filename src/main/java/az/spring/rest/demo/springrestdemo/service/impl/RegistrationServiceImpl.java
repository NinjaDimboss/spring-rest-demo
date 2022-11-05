package az.spring.rest.demo.springrestdemo.service.impl;

import az.spring.rest.demo.springrestdemo.enums.ErrorCodeEnum;
import az.spring.rest.demo.springrestdemo.exception.CustomNotFoundException;
import az.spring.rest.demo.springrestdemo.model.Registration;
import az.spring.rest.demo.springrestdemo.repository.RegistrationRepository;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationDto;
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
    public void insert(RegistrationDto registrationDto) {
        Registration registration = new Registration();
        BeanUtils.copyProperties(registrationDto, registration);
        registrationRepository.save(registration);
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
}
