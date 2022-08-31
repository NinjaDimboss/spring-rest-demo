package az.spring.rest.demo.springrestdemo.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private long id;

    @NotBlank(message = "Ad boş olmamalıdır!")
    private String ad;
    @NotBlank(message = "Ad boş olmamalıdır!")
    private String soyad;
    private String Login;
    private String password;
}
