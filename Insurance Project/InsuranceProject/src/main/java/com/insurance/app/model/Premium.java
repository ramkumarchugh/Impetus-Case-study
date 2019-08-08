package com.insurance.app.model;

/** The Class Premium. */
public class Premium {

    /** The sum assured. */
    int sumAssured;

    /** The age. */
    int age;

    /** The no of years. */
    int noOfYears;

    /** The no of dependents. */
    int noOfDependents;

    /** Gets the sum assured.
     *
     * @return the sum assured */
    public int getSumAssured() {
        return sumAssured;
    }

    /** Sets the sum assured.
     *
     * @param sumAssured
     *            the new sum assured */
    public void setSumAssured(int sumAssured) {
        this.sumAssured = sumAssured;
    }

    /** Gets the age.
     *
     * @return the age */
    public int getAge() {
        return age;
    }

    /** Sets the age.
     *
     * @param age
     *            the new age */
    public void setAge(int age) {
        this.age = age;
    }

    /** Gets the no of years.
     *
     * @return the no of years */
    public int getNoOfYears() {
        return noOfYears;
    }

    /** Sets the no of years.
     *
     * @param noOfYears
     *            the new no of years */
    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    /** Gets the no of dependents.
     *
     * @return the no of dependents */
    public int getNoOfDependents() {
        return noOfDependents;
    }

    /** Sets the no of dependents.
     *
     * @param noOfDependents
     *            the new no of dependents */
    public void setNoOfDependents(int noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    /** To string.
     *
     * @return the string */
    @Override
    public String toString() {
        return "Premium [sumAssured=" + sumAssured + ", age=" + age + ", noOfYears=" + noOfYears + ", noOfDependents=" + noOfDependents + "]";
    }

}
