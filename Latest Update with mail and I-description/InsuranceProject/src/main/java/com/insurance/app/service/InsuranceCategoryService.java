package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import com.insurance.app.model.InsuranceCategory;

/** The Interface InsuranceCategoryService. */
public interface InsuranceCategoryService {

    /** Gets the insurance category by id.
     *
     * @param insuranceId
     *            the insurance id
     * @return the insurance category by id */
    Optional<InsuranceCategory> getInsuranceCategoryById(int insuranceId);

    /** Gets the insurance category.
     *
     * @return the insurance category */
    List<InsuranceCategory> getInsuranceCategory();

    /** Update insurance.
     *
     * @param updateinsurance
     *            the update insurance
     * @return the insurance category */
    InsuranceCategory updateInsurance(InsuranceCategory updateinsurance);

}
