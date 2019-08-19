package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.app.dao.InsuranceCategoryDao;
import com.insurance.app.model.InsuranceCategory;

/** The Class InsuranceCategoryServiceImplementation. */
@Service
public class InsuranceCategoryServiceImplementation implements InsuranceCategoryService {

    /** The dao. */
    @Autowired
    InsuranceCategoryDao dao;

    /** Gets the insurance category.
     *
     * @return the insurance category */
    public List<InsuranceCategory> getInsuranceCategory() {
        return dao.findAll();
    }

    /** Gets the insurance category by id.
     *
     * @param insuranceId
     *            the insurance id
     * @return the insurance category by id */
    // @Override
    public Optional<InsuranceCategory> getInsuranceCategoryById(int insuranceId) {

        return dao.findById(insuranceId);

    }

    /** Update insurance.
     *
     * @param updateinsurance
     *            the updateinsurance
     * @return the insurance category */
    // @Override
    public InsuranceCategory updateInsurance(InsuranceCategory updateinsurance) {

        return dao.save(updateinsurance);
    }

}
