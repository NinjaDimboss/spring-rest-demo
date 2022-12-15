package az.spring.rest.demo.springrestdemo.controller;

import az.spring.rest.demo.springrestdemo.rest.model.response.LoginResponse;
import az.spring.rest.demo.springrestdemo.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
@Tag(name = "Login servisləri")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
    private final LoginService loginService;

    @GetMapping
    @Operation(summary = "Daxilolanların siyahısı")
    public LoginResponse  getAllRegistrations() {
        return loginService.getInfoByUsername();
    }
}
