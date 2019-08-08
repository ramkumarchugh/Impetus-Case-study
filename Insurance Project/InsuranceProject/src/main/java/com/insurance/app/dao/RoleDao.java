 package com.insurance.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.app.model.Role;

/**
 * The Interface RoleDao.
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

}
