package it.epicode.presentationlayer.controller;

import it.epicode.businessLayer.dto.RegisterUserDto;
import it.epicode.businessLayer.dto.RegisteredUserDto;
import it.epicode.businessLayer.services.UserService;
import it.epicode.presentationlayer.exceptions.FieldValidationException;
import it.epicode.presentationlayer.model.LoginModel;
import it.epicode.presentationlayer.model.RegisterUserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService users;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Validated RegisterUserModel model, //
                                     BindingResult validation, UriComponentsBuilder uri) {

        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }

        var r = users.register(RegisterUserDto.builder()
                .withUsername(model.username())
                .withEmail(model.email())
                .withPassword(model.password())
                .withNome(model.nome())
                .withCognome(model.cognome())
                .withAvatar(model.avatar())
                .withRoles(String.valueOf(model.roles()))
                .build());

        var headers = new HttpHeaders();
        headers.add("Location", uri.path("/api/users/{id}").buildAndExpand(r.getId()).toString());
        return new ResponseEntity<>(r, headers, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginModel model, //
                                   BindingResult validation) {
        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }

        return new ResponseEntity<>(users.login(model.username(), model.password()).orElseThrow(), //
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<RegisteredUserDto> get(@PathVariable long id) {
        return users.get(id);
    }

}
