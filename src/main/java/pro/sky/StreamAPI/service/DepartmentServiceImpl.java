package pro.sky.StreamAPI.service;

import org.springframework.stereotype.Service;
import pro.sky.StreamAPI.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public double getSalarySumByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public double getMaxSalaryByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .max()
                .orElseThrow(() -> new RuntimeException("No employees in department " + departmentId));
    }

    @Override
    public double getMinSalaryByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .min()
                .orElseThrow(() -> new RuntimeException("No employees in department " + departmentId));
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}