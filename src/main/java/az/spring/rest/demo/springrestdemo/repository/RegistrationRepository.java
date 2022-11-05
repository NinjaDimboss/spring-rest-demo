package az.spring.rest.demo.springrestdemo.repository;

import az.spring.rest.demo.springrestdemo.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration>findByUsername(String username);
}
