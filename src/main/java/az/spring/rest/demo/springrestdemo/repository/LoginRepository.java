package az.spring.rest.demo.springrestdemo.repository;

import az.spring.rest.demo.springrestdemo.model.Login;
import az.spring.rest.demo.springrestdemo.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    List<Login>findByUsername(String username);
}
