package az.spring.rest.demo.springrestdemo.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private String email;
    private String username;
    private String password;
}
