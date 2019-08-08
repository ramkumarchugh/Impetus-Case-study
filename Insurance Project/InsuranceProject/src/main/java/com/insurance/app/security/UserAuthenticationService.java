
package com.insurance.app.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.insurance.app.model.User;
import com.insurance.app.service.UserService;

/** Service to authenticate user. */

@Service
public class UserAuthenticationService implements UserDetailsService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(UserAuthenticationService.class);

    /** The user service. */
    @Autowired
    private UserService userService;

    /** Load user by user name.
     *
     * @param username
     *            the user name
     * @return the user details */
    @Override
    public UserDetails loadUserByUsername(String username) {
        LOGGER.info("getting user details:" + username);
        User user = userService.getUserByEmail(username);
        LOGGER.info("found user details:" + user);
        if (user != null) {
            return new AuthenticationUserDetails(user);
        } else {
            throw new UsernameNotFoundException("Invalid Credentials!");
        }
    }

}
