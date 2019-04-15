package com.study.domain;

public class Department {

    private int id;
    private String deptname;

    public Department() {
    }

    public Department(int id, String deptname) {
        this.id = id;
        this.deptname = deptname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}
