package az.spring.rest.demo.springrestdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (
        info = @Info(
                title = "Registration Service",
                description = "Cybernet qeydiyyat portalı",
                version = "2"
        )
)
public class SpringRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestDemoApplication.class, args);
    }

}
