package pro.sky.StreamAPI.service;

import org.springframework.stereotype.Service;
import pro.sky.StreamAPI.Employee;
import pro.sky.StreamAPI.exceptions.ExistingEmployeeException;
import pro.sky.StreamAPI.exceptions.EmployeeNotFoundException;
import pro.sky.StreamAPI.exceptions.EmployeeFullStorageException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final Map<String, Employee> EmployeeMap = new HashMap<>();

    private static final int MAX_EMPLOYEES = 10;

    @Override
    public Employee addEmployee(Employee employee) {
        if (EmployeeMap.size() >= MAX_EMPLOYEES) {
            throw new EmployeeFullStorageException("Employee storage is full.");
        }

        if (EmployeeMap.containsKey(employee.getFullName())) {
            throw new ExistingEmployeeException("Employee already exists.");
        }
        EmployeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String name, String lastname) {
        Employee employee = findEmployee(name, lastname);
        EmployeeMap.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String name, String lastName) {
        String fullName = name + " " + lastName;
        if (EmployeeMap.containsKey(fullName)) {
            return EmployeeMap.get(fullName);
        }

        throw new EmployeeNotFoundException("Employee not found: " + fullName);
    }

    public Map<String, Employee> getEmployeeMap() {
        return EmployeeMap;
    }
}