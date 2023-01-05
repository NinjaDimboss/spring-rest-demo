package az.spring.rest.demo.springrestdemo.service;

import az.spring.rest.demo.springrestdemo.rest.model.response.LoginResponse;
import az.spring.rest.demo.springrestdemo.rest.model.response.LoginResponsePass;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResponse getInfoByUsernameAndPassword (String username, String password);

}
