package com.insurance.app.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.insurance.app.model.Workflow;

/**
 * The Interface WorkflowDao.
 */
@Repository
public interface WorkflowDao extends JpaRepository<Workflow, Integer> {
    
    
    /**
     * Find by application.
     *
     * @param applicationId the application id
     * @return the list
     */
    @Query(value= "select * from workflow where application_id = :applicationId",nativeQuery = true )
    List<Workflow> findByApplication(@Param("applicationId") int applicationId);

   
}

