package az.spring.rest.demo.springrestdemo.rest.model.response;

import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponse {
    private List<RegistrationDto>registration;
}
