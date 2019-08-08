package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import com.insurance.app.model.BasePlan;

/** The Interface BasePlanService. */
public interface BasePlanService {

    /** Gets the base plan by id.
     *
     * @param baseplanId
     *            the base plan id
     * @return the base plan by id */
    Optional<BasePlan> getBasePlanById(int baseplanId);

    /** Gets the base plans.
     *
     * @return the base plans */
    List<BasePlan> getBasePlans();

}
