package pro.sky.StreamAPI.service;

public class EmployeeBook {
    private String[] employeeArray = new String[2] ;

    public EmployeeBook(String[] employeeArray) {
        this.employeeArray = employeeArray;
    }

    public String[] getEmployeeArray() {
        return employeeArray;
    }

    public void setEmployeeArray(String[] employeeArray) {
        this.employeeArray = employeeArray;
    }


}