package com.insurance.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/** The Class InsuranceCategory. */
// Spring jpa jars.
@Entity
@Table(name = "Insurance_category")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class InsuranceCategory implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The insurance id. */
    @Id
    @Column(name = "insuranceId")
    private int insuranceId;

    /** The insurance type. */
    @Column(name = "insuranceType")
    private String insuranceType;

    /** The description. */
    @Column(name = "description")
    private String description;

    /** Gets the insurance id.
     *
     * @return the insurance id */
    public int getinsuranceId() {
        return insuranceId;
    }

    /** Sets the insurance id.
     *
     * @param insuranceId
     *            the new insurance id */
    public void setinsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    /** Gets the insurance type.
     *
     * @return the insurance type */
    public String getinsuranceType() {
        return insuranceType;
    }

    /** Sets the insurance type.
     *
     * @param insuranceType
     *            the new insurance type */
    public void setinsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    /** Gets the description.
     *
     * @return the description */
    public String getDescription() {
        return description;
    }

    /** Sets the description.
     *
     * @param description
     *            the new description */
    public void setDescription(String description) {
        this.description = description;
    }

    /** To string.
     *
     * @return the string */
    @Override
    public String toString() {
        return "InsuranceCategory [insuranceId=" + insuranceId + ", insuranceType=" + insuranceType + ", description=" + description + "]";
    }

}
