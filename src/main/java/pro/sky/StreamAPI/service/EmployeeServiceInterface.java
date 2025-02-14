package pro.sky.StreamAPI.service;

import pro.sky.StreamAPI.Employee;

public interface EmployeeServiceInterface {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(String name, String lastname);

    Employee findEmployee(String name, String lastName);
}
