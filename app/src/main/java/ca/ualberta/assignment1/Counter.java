/*
 * project: @app_name
 * class: @file_name
 * Author: Alex Rouault
 * Date: Oct 2, 2017
 *
 * Copyright (c) Alex Rouault, CMPUT301, University of Alberta - All Rights
 * Reserved. You may use, distribute, or modify this code under terms and
 * conditions of the Code of Students Behavior at University of Alberta
 */

package ca.ualberta.assignment1;

/**
 * Class Counter:
 *
 * Stores information about each counter including name, initial value,
 * current value, and comment
 */

public class Counter {
    private String name;
    private Integer initialValue;
    private Integer currentValue;
    private String comment;

    /*
     * Counter generators.
     * name and initialValue parameters are required. If currentValue is not
     * specified, it gets automatically set to initialValue. If comment is
     * not specified, it gets automatically set to the empty string.
     */

    public Counter(String name, Integer initialValue) {
        this.name = name;
        this.initialValue = initialValue;
        this.currentValue = initialValue;
        comment = "";
    }

    public Counter(String name, Integer initialValue, Integer currentValue) {
        this.name = name;
        this.initialValue = initialValue;
        this.currentValue = currentValue;
    }

    public Counter(String name, Integer initialValue, String comment) {
        this.name = name;
        this.initialValue = initialValue;
        this.comment = comment;
    }

    public Counter(String name, Integer initialValue, Integer currentValue,
                   String comment) {
        this.name = name;
        this.initialValue = initialValue;
        this.currentValue = currentValue;
        this.comment = comment;
    }

    /*
     * Getters and Setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    /*
     * Converts Counter to string
     */

    @Override
    public String toString() {
        return "Counter [name=" + name + ", initialValue=" + initialValue
                .toString() + ", currentValue=" + currentValue + ", comment="
                + comment +  "]";
    }
}
