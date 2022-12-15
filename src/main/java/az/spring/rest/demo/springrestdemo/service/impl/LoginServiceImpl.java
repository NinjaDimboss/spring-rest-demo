package az.spring.rest.demo.springrestdemo.service.impl;

import az.spring.rest.demo.springrestdemo.repository.LoginRepository;
import az.spring.rest.demo.springrestdemo.repository.RegistrationRepository;
import az.spring.rest.demo.springrestdemo.rest.model.response.LoginResponse;
import az.spring.rest.demo.springrestdemo.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;


    @Override
    public LoginResponse getInfoByUsername() {
        return null;
    }
}
