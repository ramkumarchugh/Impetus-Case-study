package com.insurance.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * The Class Dependent.
 */
// Spring jpa jars.
@Entity
@Table(name = "Dependent")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Dependent implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The dependent id. */
    @Id
    @Column(name = "dependentId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dependentId;

    /** The dependent name. */
    @Column(name = "dependentName")
    private String dependentName;

    /** The age. */
    @Column(name = "age")
    private String age;

    /**
     * Gets the age.
     *
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets the age.
     *
     * @param age the new age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /** The city. */
    @Column(name = "city")
    private String city;

    /** The state. */
    @Column(name = "state")
    private String state;

    /** The address. */
    @Column(name = "address")
    private String address;

    /** The relation. */
    @Column(name = "relation")
    private String relation;

    /** The user. */
    @ManyToOne // (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Gets the user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the dependent id.
     *
     * @return the dependent id
     */
    public int getdependentId() {
        return dependentId;
    }

    /**
     * Sets the dependent id.
     *
     * @param dependentId the new dependent id
     */
    public void setdependentId(int dependentId) {
        this.dependentId = dependentId;
    }

    /**
     * Gets the dependent name.
     *
     * @return the dependent name
     */
    public String getdependentName() {
        return dependentName;
    }

    /**
     * Sets the dependent name.
     *
     * @param dependentName the new dependent name
     */
    public void setdependentName(String dependentName) {
        this.dependentName = dependentName;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the relation.
     *
     * @return the relation
     */
    public String getRelation() {
        return relation;
    }

    /**
     * Sets the relation.
     *
     * @param relation the new relation
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Dependent [dependentId=" + dependentId + ", dependentName=" + dependentName + ", age=" + age + ", city=" + city + ", state=" + state
                + ", address=" + address + ", relation=" + relation + ", user=" + user + "]";
    }

}


