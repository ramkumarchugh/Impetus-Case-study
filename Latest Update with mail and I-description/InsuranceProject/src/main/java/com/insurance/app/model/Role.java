package com.insurance.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/** The Class Role. */
// Spring jpa jars.
@Entity
@Table(name = "Role")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Role implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The role id. */
    @Id
    @Column(name = "roleId")
    private int roleId;

    /** The role name. */
    @Column(name = "roleName")
    private String roleName;

    /** Gets the role id.
     *
     * @return the role id */
    public int getroleId() {
        return roleId;
    }

    /** Sets the role id.
     *
     * @param roleId
     *            the new role id */
    public void setroleId(int roleId) {
        this.roleId = roleId;
    }

    /** Gets the role name.
     *
     * @return the role name */
    public String getroleName() {
        return roleName;
    }

    /** Sets the role name.
     *
     * @param roleName
     *            the new role name */
    public void setroleName(String roleName) {
        this.roleName = roleName;
    }

    /** To string.
     *
     * @return the string */
    @Override
    public String toString() {
        return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
    }

}
