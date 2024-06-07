package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.service.RoleService;
import it.epicode.dataLayer.entities.Role;
import it.epicode.dataLayer.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RolesRepository roles;


    @Override
    public Role addRole(String roleName) {
        var r = new Role();
        r.setName(roleName);
        roles.save(r);
        return r;
    }
}
