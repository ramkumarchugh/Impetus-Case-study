package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import com.insurance.app.model.Role;

/** The Interface RoleService. */
public interface RoleService {

    /** Gets the role by id.
     *
     * @param roleId
     *            the role id
     * @return the role by id */
    Optional<Role> getRoleById(int roleId);

    /** Gets the roles.
     *
     * @return the roles */
    List<Role> getRoles();

}
