package org.keith.camelsandboxapp.model;

public class Employee {
    private String emp_no;
    private String first_name;
    private String last_name;
    private String birth_date;
    private String gender;
    private String hire_date;


    public String getEmpNo() {
        return emp_no;
    }

    public void setEmpNo(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmpFirstName() {
        return first_name;
    }

    public void setEmpFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setEmpLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmpLastName() {
        return last_name;
    }

    public void setEmpDob(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmpDob() {
        return birth_date;
    }

    public void setEmpGender(String gender) {
        this.gender = gender;
    }

    public String getEmpGender() {
        return gender;
    }

    public void setEmpHireDate(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getEmpHireDate() {
        return hire_date;
    }


    @Override
    public String toString() {
        return "Employee [empNo=" + emp_no + ", emp=" + last_name + "]";
    }
}
