package com.po;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Ride {
    private Employee employee;
    private int maxRider;
    private int numOfCycles;

    public Ride() {
    }

    public Ride(Employee employee, int maxRider, int numOfCycles) {
        this.employee = employee;
        this.maxRider = maxRider;
        this.numOfCycles = numOfCycles;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

}
