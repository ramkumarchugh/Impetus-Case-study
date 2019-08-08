package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.app.dao.ApplicationPolicyDao;
import com.insurance.app.dao.WorkflowDao;
import com.insurance.app.model.ApplicationPolicy;
import com.insurance.app.model.Workflow;

/** The Class ApplicationPolicyServiceImplementation. */
@Service
public class ApplicationPolicyServiceImplementation implements ApplicationPolicyService {

    /** The dao. */
    @Autowired
    ApplicationPolicyDao dao;

    /** The daao. */
    @Autowired
    WorkflowDao daao;

    /** Gets the applications.
     *
     * @return the applications */
    public List<ApplicationPolicy> getApplications() {
        return dao.findAll();
    }

    /** Gets the application by status.
     *
     * @param status
     *            the status
     * @return the application by status */
    @Override
    public List<ApplicationPolicy> getApplicationByStatus(String status) {

        return dao.findByStatus(status);
    }

    /** Gets the application by user id.
     *
     * @param userId
     *            the user id
     * @return the application by user id */
    public List<ApplicationPolicy> getApplicationByUserId(int userId) {

        return dao.findByUser(userId);
    }

    /** Gets the application by id.
     *
     * @param applicationId
     *            the application id
     * @return the application by id */
    public Optional<ApplicationPolicy> getApplicationById(int applicationId) {
        return dao.findById(applicationId);
    }

    /** Adds the new application.
     *
     * @param addapplication
     *            the add application
     * @return the application policy */
    public ApplicationPolicy addNewApplication(ApplicationPolicy addapplication) {
        addapplication.setStatus("Application Submitted");

        Workflow workflow = new Workflow();
        workflow.setStatus(addapplication.getStatus());
        workflow.setComment("Application will be reviewed shortly");
        workflow.setassignedTo("System");
        workflow.setApplication(addapplication);
        
 
//        System.out.println(workflow.getStatus());
        dao.save(addapplication);
        daao.save(workflow);
        return dao.save(addapplication);
    }

    /** Update application.
     *
     * @param updateapplication
     *            the updateapplication
     * @return the application policy */
    public ApplicationPolicy updateApplication(ApplicationPolicy updateapplication) {
        dao.save(updateapplication);
        Workflow workflow = new Workflow();
        workflow.setStatus(updateapplication.getStatus());
        workflow.setComment("Final Result ");
        workflow.setassignedTo("User");
        workflow.setApplication(updateapplication);
        
        daao.save(workflow);
        return dao.save(updateapplication);
    }

    /** Delete application by id.
     *
     * @param applicationId
     *            the application id */
    public void deleteApplicationById(int applicationId) {
        dao.deleteById(applicationId);

    }

}
