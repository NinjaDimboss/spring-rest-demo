package az.spring.rest.demo.springrestdemo.controller;

import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationRequestDto;
import az.spring.rest.demo.springrestdemo.rest.model.dto.RegistrationResponseDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.RegistrationResponse;
import az.spring.rest.demo.springrestdemo.service.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @GetMapping("/search")
    @Operation(summary = "Username-ə görə axtarış")
    public RegistrationResponse getInfoByUsername(@RequestParam("username") String username) {
        return registrationService.getInfoByUsername(username);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Username əlavə etmək")
    public ResponseEntity<RegistrationResponseDto> insert(@RequestBody @Valid RegistrationRequestDto registrationRequestDto) {
        return ResponseEntity.ok(registrationService.insert(registrationRequestDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "İD-ə görə silmə")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Integer id) {
        registrationService.delete(id);
    }
}
