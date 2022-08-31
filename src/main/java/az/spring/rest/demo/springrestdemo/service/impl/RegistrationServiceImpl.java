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
    public RegistrationDto getRegistration(long id) {
        return registrationRepository.findById(id)
                .map(registration -> convertToDto(registration))
                .orElseThrow(() -> new CustomNotFoundException(ErrorCodeEnum.REGISTER_NOT_FOUND));

    }

    @Override
    public RegistrationResponse getInfoByUsername(String login) {
            List<RegistrationDto>registrations = registrationRepository.findByLogin(login)
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


    @Override
    public void update(RegistrationDto registrationDto, long id) {
        Registration registration = getRegistrationById(id);
        registration.setPassword(registrationDto.getPassword());
        registration.setId(registrationDto.getId());
        registration.setLogin(registrationDto.getLogin());

        registrationRepository.save(registration);
    }

    @Override
    public void updateSome(RegistrationDto registrationDto, long id) {
        Registration registration = getRegistrationById(id);

        if (registrationDto.getPassword() != null)
        registration.setPassword(registrationDto.getPassword());

        if (registrationDto.getId() > 0)
        registration.setId(registrationDto.getId());

        if (registrationDto.getLogin() != null)
        registration.setLogin(registrationDto.getLogin());

        registrationRepository.save(registration);

    }

    @Override
    public void delete(long id) {
        Registration registration = getRegistrationById(id);
        registrationRepository.delete(registration);
    }

    private Registration getRegistrationById(long id) {
        return registrationRepository.findById(id)
                .orElseThrow(()-> new CustomNotFoundException(ErrorCodeEnum.REGISTER_NOT_FOUND));



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
