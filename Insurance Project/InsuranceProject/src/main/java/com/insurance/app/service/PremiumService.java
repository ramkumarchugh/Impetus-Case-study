package com.insurance.app.service;

import com.insurance.app.model.Premium;

/** The Interface PremiumService. */
public interface PremiumService {

    /** Calculate premium.
     *
     * @param premium
     *            the premium
     * @return the int */
    int calculatePremium(Premium premium);

}
