package com.insurance.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/** The Class BasePlan. */
// Spring jpa jars.
@Entity
@Table(name = "Base_plan")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class BasePlan implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The base plan id. */
    @Id
    @Column(name = "baseplanId")
    private int baseplanId;

    /** The minimum sum assured. */
    @Column(name = "minSumAssured")
    private int minSumAssured;

    /** The max sum assured. */
    @Column(name = "maxSumAssured")
    private int maxSumAssured;

    /** The max age. */
    @Column(name = "maxAge")
    private int maxAge;

    /** The min age. */
    @Column(name = "minAge")
    private int minAge;

    /** The max dependents. */
    @Column(name = "maxDependents")
    private int maxDependents;

    /** The description. */
    @Column(name = "description")
    private String description;

    /** The max years. */
    @Column(name = "maxYears")
    private int maxYears;

    /** The insurance. */
    @ManyToOne
    @JoinColumn(name = "insuranceId")
    private InsuranceCategory insurance;

    /** Gets the insurance.
     *
     * @return the insurance */
    public InsuranceCategory getInsurance() {
        return insurance;
    }

    /** Sets the insurance.
     *
     * @param insurance
     *            the new insurance */
    public void setInsurance(InsuranceCategory insurance) {
        this.insurance = insurance;
    }

    /** Gets the base plan id.
     *
     * @return the base plan id */
    public int getbaseplanId() {
        return baseplanId;
    }

    /** Sets the base plan id.
     *
     * @param baseplanId
     *            the new base plan id */
    public void setbaseplanId(int baseplanId) {
        this.baseplanId = baseplanId;
    }

    /** Gets the max age.
     *
     * @return the max age */
    public int getmaxAge() {
        return maxAge;
    }

    /** Sets the max age.
     *
     * @param maxAge
     *            the new max age */
    public void setmaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    /** Gets the min age.
     *
     * @return the min age */
    public int getminAge() {
        return minAge;
    }

    /** Sets the min age.
     *
     * @param minAge
     *            the new min age */
    public void setminAge(int minAge) {
        this.minAge = minAge;
    }

    /** Gets the max dependents.
     *
     * @return the max dependents */
    public int getmaxDependents() {
        return maxDependents;
    }

    /** Sets the max dependents.
     *
     * @param maxDependents
     *            the new max dependents */
    public void setmaxDependents(int maxDependents) {
        this.maxDependents = maxDependents;
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

    /** Gets the max years.
     *
     * @return the max years */
    public int getMaxYears() {
        return maxYears;
    }

    /** Sets the max years.
     *
     * @param maxYears
     *            the new max years */
    public void setMaxYears(int maxYears) {
        this.maxYears = maxYears;

    }

    /** Gets the minimum sum assured.
     *
     * @return the minimum sum assured */
    public int getMinSumAssured() {
        return minSumAssured;
    }

    /** Sets the min sum assured.
     *
     * @param minSumAssured
     *            the new min sum assured */
    public void setMinSumAssured(int minSumAssured) {
        this.minSumAssured = minSumAssured;
    }

    /** Gets the max sum assured.
     *
     * @return the max sum assured */
    public int getMaxSumAssured() {
        return maxSumAssured;
    }

    /** Sets the max sum assured.
     *
     * @param maxSumAssured
     *            the new max sum assured */
    public void setMaxSumAssured(int maxSumAssured) {
        this.maxSumAssured = maxSumAssured;
    }

    /** To string.
     *
     * @return the string */
    @Override
    public String toString() {
        return "BasePlan [baseplanId=" + baseplanId + ", minSumAssured=" + minSumAssured + ", maxSumAssured=" + maxSumAssured + ", maxAge=" + maxAge
                + ", minAge=" + minAge + ", maxDependents=" + maxDependents + ", description=" + description + ", maxYears=" + maxYears
                + ", insurance=" + insurance + "]";
    }

}
