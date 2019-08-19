package com.insurance.app.security;

import java.util.List;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.insurance.app.model.User;

/** The Class AuthenticationUserDetails. */
public class AuthenticationUserDetails implements UserDetails {

    /** The enable. */
    private boolean enable;

    /** The user name. */
    private String username;

    /** The password. */
    private String password;

    /** The authorities. */
    private List<GrantedAuthority> authorities;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** Instantiates a new authentication user details.
     *
     * @param user
     *            the user */
    public AuthenticationUserDetails(User user) {
        super();
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.enable = true;
        System.out.println("---" + user.getRole().getroleName());
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getroleName());
        ;
        authorities = Arrays.asList(authority);
    }

    /** Gets the authorities.
     *
     * @return the authorities */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /** Gets the password.
     *
     * @return the password */
    @Override
    public String getPassword() {
        return password;
    }

    /** Gets the user name.
     *
     * @return the user name */
    @Override
    public String getUsername() {
        return username;
    }

    /** Checks if is account non expired.
     *
     * @return true, if is account non expired */
    @Override
    public boolean isAccountNonExpired() {
        return enable;
    }

    /** Checks if is account non locked.
     *
     * @return true, if is account non locked */
    @Override
    public boolean isAccountNonLocked() {
        return enable;
    }

    /** Checks if is credentials non expired.
     *
     * @return true, if is credentials non expired */
    @Override
    public boolean isCredentialsNonExpired() {
        return enable;
    }

    /** Checks if is enabled.
     *
     * @return true, if is enabled */
    @Override
    public boolean isEnabled() {
        return enable;
    }

}
