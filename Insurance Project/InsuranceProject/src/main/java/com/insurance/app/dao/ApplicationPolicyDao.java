package com.insurance.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.app.model.ApplicationPolicy;

/**
 * The Interface ApplicationPolicyDao.
 */
@Repository
public interface ApplicationPolicyDao extends JpaRepository<ApplicationPolicy,Integer>
{

    /**
     * Find by user.
     *
     * @param userId the user id
     * @return the list
     */
    @Query(value= "select * from application_policy where user_id = :userId",nativeQuery = true )
    List<ApplicationPolicy> findByUser(@Param("userId") int userId);
    
    /**
     * Find by status.
     *
     * @param status the status
     * @return the list
     */
    @Query(value= "select * from application_policy where status = :status",nativeQuery = true )
    List<ApplicationPolicy> findByStatus(@Param("status") String status);
    
    
}
