package com.study.domain;

public class Employee {

    private String username;
    private String password;
    private int deptid;

    private Department department;

    public Employee() {
    }

    public Employee(String username, String password, int deptid) {
        this.username = username;
        this.password = password;
        this.deptid = deptid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
