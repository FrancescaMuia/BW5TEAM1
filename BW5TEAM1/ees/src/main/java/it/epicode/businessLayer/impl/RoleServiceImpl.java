package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.services.RoleService;
import it.epicode.dataLayer.entities.Role;
import it.epicode.dataLayer.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RolesRepository roles;

    @Override
    public Role save(String roleName) {
        var r = new Role();
        r.setName(roleName);
        roles.save(r);
        return r;
    }
}
