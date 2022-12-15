package az.spring.rest.demo.springrestdemo.service;

import az.spring.rest.demo.springrestdemo.rest.model.response.LoginResponse;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResponse getInfoByUsername ();

}
