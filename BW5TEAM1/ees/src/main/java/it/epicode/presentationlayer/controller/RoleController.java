package it.epicode.presentationlayer.controller;

import it.epicode.businessLayer.services.RoleService;
import it.epicode.dataLayer.entities.Role;
import it.epicode.presentationlayer.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    private RoleService roles;


    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody RoleModel model) {

        Role savedRole = roles.save(model.name());
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }
}
