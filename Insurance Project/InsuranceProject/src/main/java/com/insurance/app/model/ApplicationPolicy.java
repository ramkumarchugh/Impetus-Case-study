package com.insurance.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationPolicy.
 */
// Spring jpa jars.
@Entity
@Table(name = "Application_policy")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class ApplicationPolicy implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The application id. */
    @Id
    @Column(name = "applicationId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int applicationId;

    /** The user. */
    @ManyToOne // (cascade = CascadeType.ALL)
    // @JsonManagedReference
    @JoinColumn(name = "userId")
    private User user;

    /** The status. */
    @Column(name = "status")
    private String status;

    

    /** The salary. */
    @Column(name = "salary")
    private int salary;

    /** The sum assured. */
    @Column(name = "sumAssured")
    private int sumAssured;

    /** The age. */
    @Column(name = "age")
    private int age;

    /** The no of years. */
    @Column(name = "noOfYears")
    private int noOfYears;

    /** The no of dependents. */
    @Column(name = "noOfDependents")
    private int noOfDependents;

    /** The premium. */
    @Column(name = "premium")
    private int premium;

    /**
     * Gets the user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    
    /** The workflow. */
//    @ManyToOne
//    @JoinColumn(name="workflowId")
//    private Workflow workflow;
//    
//    
//   
//    /**
//     * Gets the workflow.
//     *
//     * @return the workflow
//     */
//    public Workflow getWorkflow() {
//        return workflow;
//    }
//
//    /**
//     * Sets the workflow.
//     *
//     * @param workflow the new workflow
//     */
//    public void setWorkflow(Workflow workflow) {
//        this.workflow = workflow;
//    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the salary.
     *
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Sets the salary.
     *
     * @param salary the new salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Gets the sum assured.
     *
     * @return the sum assured
     */
    public int getSumAssured() {
        return sumAssured;
    }

    /**
     * Sets the sum assured.
     *
     * @param sumAssured the new sum assured
     */
    public void setSumAssured(int sumAssured) {
        this.sumAssured = sumAssured;
    }

    /**
     * Gets the age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the no of years.
     *
     * @return the no of years
     */
    public int getNoOfYears() {
        return noOfYears;
    }

    /**
     * Sets the no of years.
     *
     * @param noOfYears the new no of years
     */
    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    /**
     * Gets the no of dependents.
     *
     * @return the no of dependents
     */
    public int getNoOfDependents() {
        return noOfDependents;
    }

    /**
     * Sets the no of dependents.
     *
     * @param noOfDependents the new no of dependents
     */
    public void setNoOfDependents(int noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    /**
     * Gets the premium.
     *
     * @return the premium
     */
    public int getPremium() {
        return premium;
    }

    /**
     * Sets the premium.
     *
     * @param premium the new premium
     */
    public void setPremium(int premium) {
        this.premium = premium;
    }


    /**
     * Gets the application id.
     *
     * @return the application id
     */
    public int getapplicationId() {
        return applicationId;
    }

    /**
     * Sets the application id.
     *
     * @param applicationId the new application id
     */
    public void setapplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApplicationPolicy [applicationId=" + applicationId + ", user=" + user + ", status=" + status + ", salary=" + salary + ", sumAssured="
                + sumAssured + ", age=" + age + ", noOfYears=" + noOfYears + ", noOfDependents=" + noOfDependents + ", premium=" + premium + "]";
    }

}



