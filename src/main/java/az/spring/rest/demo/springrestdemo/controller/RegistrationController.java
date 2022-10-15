package az.spring.rest.demo.springrestdemo.controller;

import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.RegistrationResponse;
import az.spring.rest.demo.springrestdemo.service.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/registration")
@Tag(name = "Qeydiyyat servisləri")

public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping
    @Operation(summary = "Siyahıya baxmaq (ümumi çıxarış)")
    public RegistrationResponse getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{registration-id}")
    @Operation(summary = "İd-ə görə çağırma")
    public RegistrationDto getInfo(@PathVariable("registration-id") long id) {
        return registrationService.getRegistration(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Login-ə görə axtarış")
    public RegistrationResponse getInfoByUsername(@RequestParam("Login") String login) {
        return registrationService.getInfoByUsername(login);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid RegistrationDto registrationDto) {
        registrationService.insert(registrationDto);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Əlavə etmə")
    public void update(@RequestBody RegistrationDto registrationDto, @PathVariable("id") long id) {
        registrationService.update(registrationDto, id);
    }

    @PatchMapping("/{id}")
    public void updateSome(@RequestBody RegistrationDto registrationDto, @PathVariable("id") long id) {
        registrationService.updateSome(registrationDto, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Silmək")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        registrationService.delete(id);
    }

}
