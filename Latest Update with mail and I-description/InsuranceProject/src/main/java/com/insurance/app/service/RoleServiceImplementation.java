package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.app.dao.RoleDao;
import com.insurance.app.model.Role;

/** The Class RoleServiceImplementation. */
@Service
public class RoleServiceImplementation implements RoleService {

    /** The dao. */
    @Autowired
    RoleDao dao;

    /** Gets the role by id.
     *
     * @param roleId
     *            the role id
     * @return the role by id */
    public Optional<Role> getRoleById(int roleId) {
        return dao.findById(roleId);
    }

    /** Gets the roles.
     *
     * @return the roles */
    public List<Role> getRoles() {
        return dao.findAll();
    }

}
