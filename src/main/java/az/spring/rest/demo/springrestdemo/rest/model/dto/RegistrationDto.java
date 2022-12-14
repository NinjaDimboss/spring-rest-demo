package az.spring.rest.demo.springrestdemo.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Integer id;
    private String email;
    private String username;
    private String password;
}
