package com.insurance.app.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/** security related configuration. */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /** The user authorization service. */
    @Autowired
    private UserAuthenticationService userAuthService;

    
    
    /** Configure.
     *
     * @param http
     * @throws Exception
     *             the exception */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().addFilter(corsFilter()).authorizeRequests()
                .antMatchers("OPTIONS", "/**").permitAll().antMatchers("/application","/application/*", "/insurance", "/insurance/logout").permitAll()
                .antMatchers("/user/authenticate").hasAnyAuthority("User", "ADMIN", "UnderWriter")
                // .antMatchers("/insurance/admin/**").hasAuthority("ADMIN")
                // .antMatchers("/insurance/underwriter/**").hasAuthority("UNDER_WRITER")
                .anyRequest().authenticated().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/insurance/logout", "GET"))
                .logoutSuccessHandler(customLogoutHandler()).and().httpBasic();
    }
//validateLogin
    /** Configure global.
     *
     * @param auth
     *            the authorization
     * @throws Exception
     *             the exception */
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new PasswordEncoder() {

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                System.out.println("password match is :" + encode(rawPassword).equalsIgnoreCase(encodedPassword));
                System.out.println("--" + encode(rawPassword) + " ---" + encodedPassword);
                return encode(rawPassword).equalsIgnoreCase(encodedPassword);
            }

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }
        };
        auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder);
    }

    /** Cors filter.
     *
     * @return the cors filter */
    private CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("OPTIONS", "GET", "POST", "PUT", "DELETE"));
        List<String> headers = configuration.getAllowedHeaders();
        headers = headers != null ? headers : new ArrayList<>();
        headers.add("content-type");
        headers.add("content-length");
        headers.add("Authorization");
        headers.add("access-control-allow-origin");
        headers.add("Access-Control-Allow-Origin");
        headers.add("access-control-allow-headers");
        headers.add("access-control-allow-credentials");
        headers.add("access-control-allow-origin");
        configuration.setAllowedHeaders(headers);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }

    /** Custom logout handler.
     *
     * @return the logout success handler */
    private LogoutSuccessHandler customLogoutHandler() {
        return (req, res, auth) -> {
            if (auth != null && auth.getDetails() != null) {
                req.getSession().invalidate();
            }
            res.setStatus(HttpServletResponse.SC_OK);
        };
    }
}
