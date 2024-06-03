package it.epicode.presentationLayer.controllers;

import it.epicode.businessLayer.services.UtenteService;
import it.epicode.businessLayer.services.dto.RegisterUtenteDto;
import it.epicode.businessLayer.services.dto.RegisteredUtenteDto;
import it.epicode.presentationLayer.controllers.exceptions.FieldValidationException;
import it.epicode.presentationLayer.controllers.models.LoginModel;
import it.epicode.presentationLayer.controllers.models.RegisterUtenteModel;
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
@RequestMapping("/api/users")
public class UtenteController {

    @Autowired
    private UtenteService users;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Validated RegisterUtenteModel model, //
                                      BindingResult validation, UriComponentsBuilder uri) {
        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }
        var r = users.register(RegisterUtenteDto.builder() //
                .withNomeUtente(model.nomeUtente()) //
                .withPassword(model.password()) //
                .withEmail(model.email()).withRoles(model.roles()).build());
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

        return new ResponseEntity<>(users.login(model.nomeUtente(), model.password()).orElseThrow(), //
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<RegisteredUtenteDto> get(@PathVariable long id) {
        return users.get(id);
    }
}

