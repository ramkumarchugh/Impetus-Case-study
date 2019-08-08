package com.insurance.app.model;

import java.io.Serializable;
import java.sql.Date;

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

/** The Class User. */
// Spring jpa jars.
@Entity
@Table(name = "User")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The user id. */
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    /** The name. */
    @Column(name = "name")
    private String name;

    /** The email. */
    @Column(name = "email")
    private String email;

    /** The password. */
    @Column(name = "password")
    private String password;

    /** The city. */
    @Column(name = "city")
    private String city;

    /** The state. */
    @Column(name = "state")
    private String state;

    /** The address. */
    @Column(name = "address")
    private String address;

    /** The dob. */
    @Column(name = "dob")
    private Date dob;

    /** The mob no. */
    @Column(name = "mobNo")
    private String mobNo;

    /** The role. */
    @ManyToOne // (cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role role;

    /** Gets the role.
     *
     * @return the role */
    public Role getRole() {
        return role;
    }

    /** Sets the role.
     *
     * @param role
     *            the new role */
    public void setRole(Role role) {
        this.role = role;
    }

    /** Gets the user id.
     *
     * @return the user id */
    public int getuserId() {
        return userId;
    }

    /** Sets the user id.
     *
     * @param userId
     *            the new user id */
    public void setuserId(int userId) {
        this.userId = userId;
    }

    /** Gets the name.
     *
     * @return the name */
    public String getName() {
        return name;
    }

    /** Sets the name.
     *
     * @param name
     *            the new name */
    public void setName(String name) {
        this.name = name;
    }

    /** Gets the email.
     *
     * @return the email */
    public String getEmail() {
        return email;
    }

    /** Sets the email.
     *
     * @param email
     *            the new email */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Gets the password.
     *
     * @return the password */
    public String getPassword() {
        return password;
    }

    /** Sets the password.
     *
     * @param password
     *            the new password */
    public void setPassword(String password) {
        this.password = password;
    }

    /** Gets the city.
     *
     * @return the city */
    public String getCity() {
        return city;
    }

    /** Sets the city.
     *
     * @param city
     *            the new city */
    public void setCity(String city) {
        this.city = city;
    }

    /** Gets the state.
     *
     * @return the state */
    public String getState() {
        return state;
    }

    /** Sets the state.
     *
     * @param state
     *            the new state */
    public void setState(String state) {
        this.state = state;
    }

    /** Gets the address.
     *
     * @return the address */
    public String getAddress() {
        return address;
    }

    /** Sets the address.
     *
     * @param address
     *            the new address */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Gets the date of birth.
     *
     * @return the date of birth */
    public Date getDob() {
        return dob;
    }

    /** Sets the date of birth.
     *
     * @param dob
     *            the new date of birth */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /** Gets the mob no.
     *
     * @return the mob no */
    public String getmobNo() {
        return mobNo;
    }

    /** Sets the mob no.
     *
     * @param mobNo
     *            the new mob no */
    public void setmobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    /** To string.
     *
     * @return the string */
    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", city=" + city + ", state=" + state + ", address=" + address
                + ", dob=" + dob + ", mobNo=" + mobNo + ", role=" + role + "]";
    }

	public User(int userId, String name, String email, String password, String city, String state, String address,
			Date dob, String mobNo, Role role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.state = state;
		this.address = address;
		this.dob = dob;
		this.mobNo = mobNo;
		this.role = role;
	}
    
    public User() {}

}
