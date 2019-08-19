package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import com.insurance.app.model.Dependent;

/** The Interface DependentService. */
public interface DependentService {

    /** Gets the dependent by id.
     *
     * @param dependentId
     *            the dependent id
     * @return the dependent by id */
    Optional<Dependent> getDependentById(int dependentId);

    /** Gets the dependents.
     *
     * @return the dependents */
    List<Dependent> getDependents();

    /** Adds the new dependent.
     *
     * @param adddependent
     *            the adddependent
     * @return the dependent */
    Dependent addNewDependent(Dependent adddependent);

    /** Update dependent.
     *
     * @param updatedependent
     *            the updatedependent
     * @return the dependent */
    Dependent updateDependent(Dependent updatedependent);

    /** Delete dependent by id.
     *
     * @param dependentId
     *            the dependent id */
    void deleteDependentById(int dependentId);

}
