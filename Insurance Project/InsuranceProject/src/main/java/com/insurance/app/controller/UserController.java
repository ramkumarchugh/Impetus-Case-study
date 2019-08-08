package com.insurance.app.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.app.model.Dependent;
import com.insurance.app.model.User;
import com.insurance.app.service.DependentService;
import com.insurance.app.service.EmailService;
import com.insurance.app.service.UserService;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping(value = "/user")
 @CrossOrigin(origins="http://172.29.57.63:8080")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    /** The service. */
    @Autowired
    UserService service;

    @Autowired
    EmailService s;
    /**
     * Gets the users.
     *
     * @return the users
     */
    @GetMapping
   
    public List<User> getUsers() {
        LOGGER.info(this.getClass().getSimpleName() + " - Get all users service is invoked.");
        //s.sendSimpleMessage("divyansh.agnihotri@impetus.co.in", "Test", "mail from Insurance");
        return service.getUsers();
    }

    /**
     * Authenticate.
     *
     * @param principal the principal
     * @return the user
     */
    @GetMapping(value = "/authenticate")
    public User authenticate(Principal principal) {
        return service.getUserByEmail(principal.getName());
    }

    // Getting user by user id

    /**
     * Gets the user by id.
     *
     * @param userId the user id
     * @return the user by id
     * @throws Exception the exception
     */
    @GetMapping(value = "/{userId}")
    public User getUserById(@PathVariable int userId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Get user details by id is invoked.");

        Optional<User> user = service.getUserById(userId);
        if (!user.isPresent())
            throw new Exception("Could not find user with id- " + userId);

        return user.get();
    }

    /**
     * Gets the user by role id.
     *
     * @param roleId the role id
     * @return the user by role id
     * @throws Exception the exception
     */
    // Getting user by role id
    @GetMapping(value = "/role/{roleId}")

    public List<User> getUserByRoleId(@PathVariable int roleId) throws Exception

    {
        LOGGER.info(this.getClass().getSimpleName() + " - Get user details by role id is invoked ");
        List<User> userLst = service.getUserByRoleId(roleId);

        return userLst;
    }

    /**
     * Creates the user.
     *
     * @param newuser the new user
     * @return the user
     */
    @PostMapping
    public User createUser(@RequestBody User newuser) {
        LOGGER.info(this.getClass().getSimpleName() + " - Create new user method is invoked.");

        return service.addNewUser(newuser);

    }


    /**
     * Update user.
     *
     * @param updateuser the update user
     * @param userId the user id
     * @return the user
     * @throws Exception the exception
     */
    @PutMapping(value = "/{userId}")

    public User updateUser(@RequestBody User updateuser, @PathVariable int userId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Update user details by id is invoked.");

        

        /** if (!user.isPresent()) throw new Exception("Could not find user with id- " + userId); /* IMPORTANT - To prevent the overriding of the
         * existing value of the variables in the database, if that variable is not coming in the @RequestBody annotation object. if
         * (updateuser.getPassword() == null)// || updateuser.getPassword().isEmpty() updateuser.setPassword(user.get().getPassword()); if
         * (updateuser.getCity() == null) // || updateuser.getCity().isEmpty() updateuser.setCity(user.get().getCity()); if (updateuser.getState() ==
         * null) updateuser.setState(user.get().getState()); if (updateuser.getAddress() == null) updateuser.setAddress(user.get().getAddress()); if
         * (updateuser.getMob_no() == 0) updateuser.setMob_no(user.get().getMob_no()); // Required for the "where" clause in the sql query
         * template. */

        updateuser.setuserId(userId);
        return service.updateUser(updateuser);
    }

    /**
     * Delete user by id.
     *
     * @param userId the user id
     * @throws Exception the exception
     */
    @DeleteMapping(value = "/{userId}")

    public void deleteUserById(@PathVariable int userId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Delete user by id is invoked.");

        Optional<User> user = service.getUserById(userId);
        if (!user.isPresent())
            throw new Exception("Could not find user with id- " + userId);

        service.deleteUserById(userId);
    }

    /**
     * The ser.
     *
     */

    @Autowired
    DependentService ser;

    /**
     * Gets the dependents.
     *
     * @return the dependents
     */
    @GetMapping(value = "/dependent")
    public List<Dependent> getDependents() {
        LOGGER.info(this.getClass().getSimpleName() + " - Get all dependent details is invoked.");
        return ser.getDependents();
    }

    /**
     * Gets the dependent by id.
     *
     * @param dependentId the dependent id
     * @return the dependent by id
     * @throws Exception the exception
     */
    @GetMapping(value = "/dependent/{dependentId}")
    public Dependent getDependentById(@PathVariable int dependentId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Get dependent details by id is invoked.");

        Optional<Dependent> dependent = ser.getDependentById(dependentId);
        if (!dependent.isPresent())
            throw new Exception("Could not find dependent with id- " + dependentId);

        return dependent.get();

    }

    /**
     * Creates the dependent.
     *
     * @param newdependent the new dependent
     * @return the dependent
     */
    @PostMapping(value = "/dependent")
    public Dependent createDependent(@RequestBody Dependent newdependent) {
        LOGGER.info(this.getClass().getSimpleName() + " - Create new Dependent method is invoked.");
        Optional<User> userOpt = service.getUserById(newdependent.getUser().getuserId());
        User user = userOpt.get();
        newdependent.setUser(user);
        return ser.addNewDependent(newdependent);
    }

    /**
     * Update dependent.
     *
     * @param updatedependent the update dependent
     * @param dependentId the dependent id
     * @return the dependent
     * @throws Exception the exception
     */
    @PutMapping(value = "/dependent/{dependentId}")

    public Dependent updateDependent(@RequestBody Dependent updatedependent, @PathVariable int dependentId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Update dependent details by id is invoked.");

        updatedependent.setdependentId(dependentId);
        return ser.updateDependent(updatedependent);
    }

    /**
     * Delete dependent by id.
     *
     * @param dependentId the dependent id
     * @throws Exception the exception
     */
    @DeleteMapping(value = "/dependent/{dependentId}")
    public void deleteDependentById(@PathVariable int dependentId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Delete dependent by id is invoked.");
        Optional<Dependent> dependent = ser.getDependentById(dependentId);
        if (!dependent.isPresent())
            throw new Exception("Could not find user with id- " + dependentId);

        ser.deleteDependentById(dependentId);
    }

}


