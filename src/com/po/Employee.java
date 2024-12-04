package com.po;

public class Employee extends Person {
    private String position;
    private String salary;

    public Employee() {
    }

    public Employee(String name, String age, String sex, String position, String salary) {
        super(name, age, sex);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
