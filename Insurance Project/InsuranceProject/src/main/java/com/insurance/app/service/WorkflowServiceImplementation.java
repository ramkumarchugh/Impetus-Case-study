package com.insurance.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.app.dao.WorkflowDao;
import com.insurance.app.model.ApplicationPolicy;
import com.insurance.app.model.Workflow;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkflowServiceImplementation.
 */
@Service
public class WorkflowServiceImplementation implements WorkflowService{

    /** The dao. */
    @Autowired
    WorkflowDao dao;
    
    /**
     * Gets the workflow.
     *
     * @return the workflow
     */
    @Override
    public List<Workflow> getWorkflow() {
        
        return dao.findAll();
    }

    /**
     * Gets the workflow by application id.
     *
     * @param applicationId the application id
     * @return the workflow by application id
     */
    public List<Workflow> getWorkflowByApplicationId(int applicationId) {
        
        return dao.findByApplication(applicationId);
     }
    
    
    /**
     * Gets the workflow by id.
     *
     * @param workflowId the workflow id
     * @return the workflow by id
     */
    @Override
    public Optional<Workflow> getWorkflowById(int workflowId) {
        return dao.findById(workflowId);
    }

    /**
     * Adds the workflow.
     *
     * @param addworkflow the add workflow
     * @return the workflow
     */
    @Override
    public Workflow addWorkflow(Workflow addworkflow) {
        return dao.save(addworkflow);
    }
  
    
    
    /**
     * Update workflow.
     *
     * @param updateworkflow the update workflow
     * @return the workflow
     */
    @Override
    public Workflow updateWorkflow(Workflow updateworkflow) {        

       
     return dao.save(updateworkflow);    
    }

    
    
    
   


    
}

