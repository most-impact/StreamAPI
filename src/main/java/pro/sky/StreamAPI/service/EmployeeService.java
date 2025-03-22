package pro.sky.StreamAPI.service;

import pro.sky.StreamAPI.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void removeEmployee(int id);
    Employee findEmployee(int id);
    List<Employee> getAllEmployees();
}