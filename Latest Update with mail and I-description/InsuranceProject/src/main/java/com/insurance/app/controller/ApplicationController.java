package com.insurance.app.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.app.model.ApplicationPolicy;

import com.insurance.app.model.Workflow;
import com.insurance.app.service.ApplicationPolicyService;

import com.insurance.app.service.WorkflowService;

/** The Class ApplicationController. */
@RestController
@RequestMapping(value = "application")
// @CrossOrigin(origins="http://172.29.57.66:8080")
@CrossOrigin(origins = "http://localhost:4200")

public class ApplicationController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(ApplicationController.class);

    /** The service. */
    @Autowired
    ApplicationPolicyService service;

    /** Gets the applications.
     *
     * @return the applications */
    @GetMapping
    public List<ApplicationPolicy> getApplications() {
        LOGGER.info(this.getClass().getSimpleName() + " - Get all applications service is invoked.");
        return service.getApplications();
    }

    // get application by application Id

    /** Gets the application by id.
     *
     * @param applicationId
     *            the application id
     * @return the application by id
     * @throws Exception
     *             the exception */
    @GetMapping(value = "/{applicationId}")
    public ApplicationPolicy getApplicationById(@PathVariable int applicationId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Get application details by id is invoked.");

        Optional<ApplicationPolicy> application = service.getApplicationById(applicationId);
        if (!application.isPresent())
            throw new Exception("Could not find application with id- " + applicationId);

        return application.get();
    }

    // get application by user Id :- For user purpose

    /** Gets the application by user id.
     *
     * @param userId
     *            the user id
     * @return the application by user id
     * @throws Exception
     *             the exception */
    @GetMapping(value = "/user/{userId}")

    public List<ApplicationPolicy> getApplicationByUserId(@PathVariable int userId) throws Exception

    {
        LOGGER.info(this.getClass().getSimpleName() + " - Get application by user id is invoked ");
        List<ApplicationPolicy> applicationList = service.getApplicationByUserId(userId);

        return applicationList;
    }

    /** Gets the application by status.
     *
     * @param status
     *            the status
     * @return the application by status
     * @throws Exception
     *             the exception */
    // get application by status
    @GetMapping(value = "status/{status}")

    public List<ApplicationPolicy> getApplicationByStatus(@PathVariable String status) throws Exception

    {
        LOGGER.info(this.getClass().getSimpleName() + " - Get application by status is invoked ");
        List<ApplicationPolicy> applicationList = service.getApplicationByStatus(status);

        return applicationList;
    }

    /** Creates the application.
     *
     * @param addapplication
     *            the add application
     * @return the application policy */
    @PostMapping
    public ApplicationPolicy createApplication(@RequestBody ApplicationPolicy addapplication) {

        LOGGER.info(this.getClass().getSimpleName() + " - Create new application method is invoked.");

        return service.addNewApplication(addapplication);
    }

    /** Update application.
     *
     * @param updateapplication
     *            the update application
     * @param applicationId
     *            the application id
     * @return the application policy
     * @throws Exception
     *             the exception */
    @PutMapping(value = "/update/{applicationId}")

    public ApplicationPolicy updateApplication(@RequestBody ApplicationPolicy updateapplication, @PathVariable int applicationId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Update application details by id is invoked.");

        updateapplication.setapplicationId(applicationId);
        return service.updateApplication(updateapplication);
    }

    /** Delete application by id.
     *
     * @param applicationId
     *            the application id
     * @throws Exception
     *             the exception */
    @DeleteMapping(value = "/delete/{applicationId}")

    public void deleteApplicationById(@PathVariable int applicationId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Delete application by id is invoked.");

        Optional<ApplicationPolicy> application = service.getApplicationById(applicationId);
        if (!application.isPresent())
            throw new Exception("Could not find application with id- " + applicationId);

        service.deleteApplicationById(applicationId);
    }

    /** The ser. */
    @Autowired
    WorkflowService ser;

    /** Gets the all workflow.
     *
     * @return the all workflow */
    @GetMapping(value = "/workflow")
    public List<Workflow> getWorkflows() {
        LOGGER.info(this.getClass().getSimpleName() + " - Get all workflows service is invoked.");
        return ser.getWorkflow();
    }

    /** Gets the workflow by id.
     *
     * @param workflowId
     *            the workflow id
     * @return the workflow by id
     * @throws Exception
     *             the exception */
    @GetMapping(value = "/workflow/{workflowId}")
    public Workflow getWorkflowById(@PathVariable int workflowId) throws Exception {
        LOGGER.info(this.getClass().getSimpleName() + " - Get workflow details by id is invoked.");

        Optional<Workflow> workflow = ser.getWorkflowById(workflowId);
        if (!workflow.isPresent())
            throw new Exception("Could not find workflow with id- " + workflowId);

        return workflow.get();
    }

    /** Gets the workflow by application id.
     *
     * @param applicationId
     *            the application id
     * @return the workflow by application id
     * @throws Exception
     *             the exception */
    @GetMapping(value = "/workflow/applicationId/{applicationId}")

    public List<Workflow> getWorkflowByApplicationId(@PathVariable int applicationId) throws Exception

    {
        LOGGER.info(this.getClass().getSimpleName() + " - Get workflow by application id is invoked ");
        List<Workflow> workflowList = ser.getWorkflowByApplicationId(applicationId);

        return workflowList;
    }

    /** Adds the workflow.
     *
     * @param addworkflow
     *            the add workflow
     * @return the workflow */
    @PostMapping(value = "/addworkflow")
    public Workflow addWorkflow(@RequestBody Workflow addworkflow) {
        LOGGER.info(this.getClass().getSimpleName() + " - Create new workflow method is invoked.");

        return ser.addWorkflow(addworkflow);
    }

    /** Update workflow.
     *
     * @param updateworkflow
     *            the update workflow
     * @param workflowId
     *            the workflow id
     * @return the workflow
     * @throws Exception
     *             the exception */
    @PutMapping(value = "/workflow/update/{workflowId}")

    public Workflow updateWorkflow(@RequestBody Workflow updateworkflow, @PathVariable int workflowId) throws Exception {
        LOGGER.info("Application Controller" + updateworkflow.toString());
        return ser.updateWorkflow(updateworkflow);
    }

    

}
