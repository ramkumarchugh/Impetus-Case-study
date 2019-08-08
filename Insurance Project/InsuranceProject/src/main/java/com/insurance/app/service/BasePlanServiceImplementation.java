package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.app.dao.BasePlanDao;
import com.insurance.app.model.BasePlan;

/** The Class BasePlanServiceImplementation. */
@Service
public class BasePlanServiceImplementation implements BasePlanService {

    /** The dao. */
    @Autowired
    BasePlanDao dao;

    /** Gets the base plan by id.
     *
     * @param baseplanId
     *            the base plan id
     * @return the base plan by id */
    public Optional<BasePlan> getBasePlanById(int baseplanId) {
        return dao.findById(baseplanId);
    }

    /** Gets the base plans.
     *
     * @return the base plans */
    public List<BasePlan> getBasePlans() {
        return dao.findAll();
    }

}
