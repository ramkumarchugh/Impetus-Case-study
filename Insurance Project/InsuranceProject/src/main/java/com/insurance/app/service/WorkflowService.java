package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import com.insurance.app.model.Workflow;

/** The Interface WorkflowService. */
public interface WorkflowService {

    /** Gets the workflow.
     *
     * @return the workflow */
    List<Workflow> getWorkflow();

    /** Gets the workflow by application id.
     *
     * @param applicationId
     *            the application id
     * @return the workflow by application id */
    List<Workflow> getWorkflowByApplicationId(int applicationId);

    /** Gets the workflow by id.
     *
     * @param workflowId
     *            the workflow id
     * @return the workflow by id */
    Optional<Workflow> getWorkflowById(int workflowId);

    /** Adds the workflow.
     *
     * @param addworkflow
     *            the add workflow
     * @return the workflow */
    Workflow addWorkflow(Workflow addworkflow);

    /** Update workflow.
     *
     * @param updateworkflow
     *            the update workflow
     * @return the workflow */
    Workflow updateWorkflow(Workflow updateworkflow);

}
