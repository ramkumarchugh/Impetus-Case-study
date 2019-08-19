package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.app.dao.InsuranceDao;
import com.insurance.app.model.Role;
import com.insurance.app.model.User;

/** The Class UserServiceImplementation. */
@Service
public class UserServiceImplementation implements UserService {

    /** The dao. */
    @Autowired
    InsuranceDao dao;

    /** Gets the users.
     *
     * @return the users */
    public List<User> getUsers() {
        return dao.findAll();
    }

    /** Gets the user by id.
     *
     * @param userId
     *            the user id
     * @return the user by id */
    public Optional<User> getUserById(int userId) {
        return dao.findById(userId);
    }

    /** Gets the user by role id.
     *
     * @param roleId
     *            the role id
     * @return the user by role id */
    public List<User> getUserByRoleId(int roleId) {

        return dao.findByRole(roleId);
    }

    /** Gets the user by email.
     *
     * @param email
     *            the email
     * @return the user by email */
    public User getUserByEmail(String email) {

        return dao.findByEmail(email);
    }

    /** Adds the new user.
     *
     * @param user
     *            the user
     * @return the user */
    public User addNewUser(User user) {
        Role r = new Role();
        r.setroleId(3);
        user.setRole(r);

        return dao.save(user);
    }

    /** Update user.
     *
     * @param user
     *            the user
     * @return the user */
    public User updateUser(User user) {
        return dao.save(user);
    }

    /** Delete user by id.
     *
     * @param userId
     *            the user id */
    public void deleteUserById(int userId) {
        dao.deleteById(userId);
    }

}
