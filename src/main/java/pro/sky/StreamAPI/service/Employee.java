package pro.sky.StreamAPI.service;

import java.util.Objects;

public class Employee {
    private static int id = 1;

    private String fullName;
    private int department;
    private int salary;

    public Employee(String name, int department, int salary) {
        id = id++;
        this.fullName = name;
        setDepartment(department);
        this.salary = salary;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Employee.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Employee otherAuthor = (Employee) obj;

        return Objects.equals(fullName, otherAuthor.fullName) &&
                Objects.equals(department, otherAuthor.department) &&
                Objects.equals(salary, otherAuthor.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}