package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.app.dao.DependentDao;
import com.insurance.app.model.Dependent;
import com.insurance.app.model.User;

/** The Class DependentServiceImplementation. */
@Service
public class DependentServiceImplementation implements DependentService {

    /** The dao. */
    @Autowired
    DependentDao dao;

    /** Gets the dependent by id.
     *
     * @param dependentId
     *            the dependent id
     * @return the dependent by id */
    public Optional<Dependent> getDependentById(int dependentId) {
        return dao.findById(dependentId);
    }

    /** Gets the dependents.
     *
     * @return the dependents */
    public List<Dependent> getDependents() {

        return dao.findAll();
    }

    /** Adds the new dependent.
     *
     * @param adddependent
     *            the add dependent
     * @return the dependent */
    public Dependent addNewDependent(Dependent adddependent) {

        User user = new User();
        user.getuserId();
        adddependent.setUser(user);

        return dao.save(adddependent);
    }

    /** Update dependent.
     *
     * @param updatedependent
     *            the update dependent
     * @return the dependent */
    public Dependent updateDependent(Dependent updatedependent) {
        return dao.save(updatedependent);
    }

    /** Delete dependent by id.
     *
     * @param dependentId
     *            the dependent id */
    public void deleteDependentById(int dependentId) {
        dao.deleteById(dependentId);
    }

}
