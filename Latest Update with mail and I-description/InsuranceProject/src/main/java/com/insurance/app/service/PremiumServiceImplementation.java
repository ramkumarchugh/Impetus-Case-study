package com.insurance.app.service;

import org.springframework.stereotype.Service;

import com.insurance.app.model.Premium;

/**
 * The Class PremiumServiceImplementation.
 */
@Service
public class PremiumServiceImplementation extends Premium implements PremiumService {

    /**
     * Calculate premium.
     *
     * @param premium the premium
     * @return the integer
     */
    @Override
    public int calculatePremium(Premium premium) {

        int sumAssured = premium.getSumAssured();
        int age = premium.getAge();
        int noOfYears = premium.getNoOfYears();
        int noOfDependents = premium.getNoOfDependents();
        int result = 0;

        if (age > 17 && age < 50) {
            result = ((sumAssured * 5) / 1000 + noOfDependents * 3000 + 1000) * noOfYears;
        }

        else {
            result = ((sumAssured * 5) / 1000 + noOfDependents * 3000 + 3000) * noOfYears;
        }

        return result;

    }

}
