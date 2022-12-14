package az.spring.rest.demo.springrestdemo.rest.model.response;

import az.spring.rest.demo.springrestdemo.enums.ErrorCodeEnum;
import az.spring.rest.demo.springrestdemo.rest.model.dto.LoginDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LoginResponse {
    private ErrorCodeEnum status;

    public LoginResponse() {
        this.status = ErrorCodeEnum.OK;
    }
}
