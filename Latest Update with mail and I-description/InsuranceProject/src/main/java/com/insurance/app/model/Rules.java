package com.insurance.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * The Class Rules.
 */
// Spring jpa jars.
@Entity
@Table(name = "Rules")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Rules implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The rule id. */
    @Id
    @Column(name = "ruleId")
    private int ruleId;

    /** The description. */
    @Column(name = "description")
    private String description;

    /**
     * Gets the rule id.
     *
     * @return the rule id
     */
    public int getruleId() {
        return ruleId;
    }

    /**
     * Sets the rule id.
     *
     * @param ruleId the new rule id
     */
    public void setruleId(int ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Rules [ruleId=" + ruleId + ", description=" + description + "]";
    }

}

