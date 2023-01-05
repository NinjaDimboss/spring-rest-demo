package az.spring.rest.demo.springrestdemo.controller;

import az.spring.rest.demo.springrestdemo.rest.model.dto.LoginDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.LoginResponse;
import az.spring.rest.demo.springrestdemo.rest.model.response.LoginResponsePass;
import az.spring.rest.demo.springrestdemo.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
@Tag(name = "Login servisləri")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
    private final LoginService loginService;
//
//    @GetMapping
//    @Operation(summary = "Daxilolanların siyahısı")
//    public LoginResponse  getAllRegistrations() {
//        return loginService.getInfoByUsername();
//    }

    @PostMapping
    @Operation(summary = "Siyahının ötürülməsi")
    public LoginResponse getAllRegistrationsPass(@RequestBody LoginDto dto) {
        return loginService.getInfoByUsernameAndPassword(dto.getUsername(), dto.getPassword());
    }
}
