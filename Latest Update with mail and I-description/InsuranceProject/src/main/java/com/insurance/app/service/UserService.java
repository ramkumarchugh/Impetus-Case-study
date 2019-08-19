package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import com.insurance.app.model.Role;
import com.insurance.app.model.User;


/** The Interface UserService. */
public interface UserService {

    /** Gets the user by id.
     *
     * @param userId
     *            the user id
     * @return the user by id */
    Optional<User> getUserById(int userId);

    /** Gets the user by role id.
     *
     * @param roleId
     *            the role id
     * @return the user by role id */
    List<User> getUserByRoleId(int roleId);

    /** Gets the user by email.
     *
     * @param email
     *            the email
     * @return the user by email */
    User getUserByEmail(String email);

    /** Gets the users.
     *
     * @return the users */
    List<User> getUsers();

    /** Adds the new user.
     *
     * @param adduser
     *            the add user
     * @return the user */
    User addNewUser(User adduser);

    /** Update user.
     *
     * @param updateuser
     *            the update user
     * @return the user */
    User updateUser(User updateuser);

    /** Delete user by id.
     *
     * @param userId
     *            the user id */
    void deleteUserById(int userId);

}
