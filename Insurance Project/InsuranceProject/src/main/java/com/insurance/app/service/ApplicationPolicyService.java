package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import com.insurance.app.model.ApplicationPolicy;

/** The Interface ApplicationPolicyService. */
public interface ApplicationPolicyService {

    /** Gets the application by id.
     *
     * @param applicationId
     *            the application id
     * @return the application by id */
    Optional<ApplicationPolicy> getApplicationById(int applicationId);

    /** Gets the application by status.
     *
     * @param status
     *            the status
     * @return the application by status */
    List<ApplicationPolicy> getApplicationByStatus(String status);

    /** Gets the application by user id.
     *
     * @param userId
     *            the user id
     * @return the application by user id */
    List<ApplicationPolicy> getApplicationByUserId(int userId);

    /** Gets the applications.
     *
     * @return the applications */
    List<ApplicationPolicy> getApplications();

    /** Adds the new application.
     *
     * @param addapplication
     *            the add application
     * @return the application policy */
    ApplicationPolicy addNewApplication(ApplicationPolicy addapplication);

    /** Update application.
     *
     * @param updateapplication
     *            the update application
     * @return the application policy */
    ApplicationPolicy updateApplication(ApplicationPolicy updateapplication);

    /** Delete application by id.
     *
     * @param applicationId
     *            the application id */
    void deleteApplicationById(int applicationId);

}
