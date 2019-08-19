package com.insurance.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.app.model.User;

/**
 * The Interface InsuranceDao.
 */
@Repository
public interface InsuranceDao extends JpaRepository<User, Integer> {
    
    /**
     * Find by role.
     *
     * @param roleId the role id
     * @return the list
     */
    @Query(value= "select * from user where role_id = :roleId",nativeQuery = true )
    List<User> findByRole(@Param("roleId") int roleId);

    
    /**
     * Find by email.
     *
     * @param email the email
     * @return the user
     */
    //@Query(value= "select * from user where email = :email",nativeQuery = true )
    User findByEmail(@Param("roleId") String email);
}
