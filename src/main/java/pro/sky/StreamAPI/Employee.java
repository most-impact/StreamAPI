package pro.sky.StreamAPI;

import java.util.Objects;

public class Employee {
    private static int counter = 1;
    private final int id;
    private String firstName;
    private String lastName;
    private int department;
    private int salary;

    public Employee(String firstName, String lastName, int salary, int department) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
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

        return Objects.equals(firstName, otherAuthor.firstName) &&
                Objects.equals(lastName, otherAuthor.lastName) &&
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
                ", fullName='" + firstName + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}