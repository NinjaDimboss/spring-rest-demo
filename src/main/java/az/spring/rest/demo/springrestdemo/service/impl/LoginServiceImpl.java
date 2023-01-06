package az.spring.rest.demo.springrestdemo.service.impl;

import az.spring.rest.demo.springrestdemo.enums.ErrorCodeEnum;
import az.spring.rest.demo.springrestdemo.model.Login;
import az.spring.rest.demo.springrestdemo.repository.LoginRepository;
import az.spring.rest.demo.springrestdemo.rest.model.response.LoginResponse;
import az.spring.rest.demo.springrestdemo.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;


    @Override
    public LoginResponse getInfoByUsernameAndPassword(String username, String password) {
        LoginResponse response = new LoginResponse();
        Login login = loginRepository.findByUsernameAndPassword(username, password);
        if (login == null)
            response.setStatus(ErrorCodeEnum.USER_NOT_FOUND);
        else
            response.setStatus(ErrorCodeEnum.OK);

        return response;
    }
}
