package com.insurance.app.model;

import java.io.Serializable;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

// TODO: Auto-generated Javadoc
/** The Class Workflow. */
// Spring jpa jars.
@Entity
@Table(name = "Workflow")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate

public class Workflow implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 595657886534872460L;

    /** The workflow id. */
    @Id
    @Column(name = "workflowId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int workflowId;

    /** The application. */
    @ManyToOne // (cascade = CascadeType.ALL)
    @JoinColumn(name = "applicationId")
    private ApplicationPolicy application;

    /** Gets the application.
     *
     * @return the application */
    public ApplicationPolicy getApplication() {
        return application;
    }

    /** Sets the application.
     *
     * @param application
     *            the new application */
    public void setApplication(ApplicationPolicy application) {
        this.application = application;
    }

    /** The assigned to. */
    @Column(name = "assignedTo")
    private String assignedTo;

    /** The comment. */
    @Column(name = "comment")
    private String comment;

    /** The creation time. */
    @Column(name = "creationTime")
    @CreationTimestamp
    private LocalDateTime creationTime;

    /** The updated time. */
    @Column(name = "updationTime")
    @UpdateTimestamp
    private LocalDateTime updationTime;

    /** The status. */
    @Column(name = "status")
    private String status;

    /** Gets the status.
     *
     * @return the status */
    public String getStatus() {
        return status;
    }

    /** Sets the status.
     *
     * @param status
     *            the new status */
    public void setStatus(String status) {
        this.status = status;
    }

    /** Gets the workflow id.
     *
     * @return the workflow id */
    public int getworkflowId() {
        return workflowId;
    }

    /** Sets the workflow id.
     *
     * @param workflowId
     *            the new workflow id */
    public void setworkflowId(int workflowId) {
        this.workflowId = workflowId;
    }

    /** Gets the assigned to.
     *
     * @return the assigned to */
    public String getassignedTo() {
        return assignedTo;
    }

    /** Sets the assigned to.
     *
     * @param assignedTo
     *            the new assigned to */
    public void setassignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    /** Gets the comment.
     *
     * @return the comment */
    public String getComment() {
        return comment;
    }

    /** Sets the comment.
     *
     * @param comment
     *            the new comment */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /** Gets the creation time.
     *
     * @return the creation time */
    public LocalDateTime getcreationTime() {
        return creationTime;
    }

    /** Sets the creation time.
     *
     * @param creationTime
     *            the new creation time */
    public void setcreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    /** Gets the updated time.
     *
     * @return the updated time */
    public LocalDateTime getupdationTime() {
        return updationTime;
    }

    /** Sets the updated time.
     *
     * @param updationTime
     *            the new updated time */
    public void setupdationTime(LocalDateTime updationTime) {
        this.updationTime = updationTime;
    }
//
//    @Override
//    public String toString() {
//        return "Workflow [workflowId=" + workflowId + ", application=" + application + ", assignedTo=" + assignedTo + ", comment=" + comment
//                + ", creationTime=" + creationTime + ", updationTime=" + updationTime + ", status=" + status + "]";
//    }

}
