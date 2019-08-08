package com.insurance.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/** The Class InsuranceProjectApplication. */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class InsuranceProjectApplication {

    /** The main method.
     *
     * @param args
     *            the arguments */
    public static void main(String[] args) {
        SpringApplication.run(InsuranceProjectApplication.class, args);
    }

}
