package pro.sky.StreamAPI.service;

import org.springframework.stereotype.Service;
import pro.sky.StreamAPI.Employee;
import pro.sky.StreamAPI.exceptions.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeSalaryService implements EmployeeSalaryServiceInterface {

    private final EmployeeService employeeService;

    public EmployeeSalaryService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEmployeeByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()
                        -> new EmployeeNotFoundException("No employees in department " + department));
    }

    @Override
    public Employee findMinSalaryEmployeeByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()
                        -> new EmployeeNotFoundException("No employees in department " + " " + department));
    }

    @Override
    public List<Employee> allEmployeesByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartments() {
        return employeeService.getEmployeeMap().values().stream().collect(groupingBy(Employee::getDepartment));
    }

}