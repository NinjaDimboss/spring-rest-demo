package az.spring.rest.demo.springrestdemo.rest.model.response;

import az.spring.rest.demo.springrestdemo.rest.model.dto.LoginDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponsePass {
    private List<LoginDto>loginDtos;
    private List<LoginDto>passwordDtos;
}
