package pro.sky.StreamAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.StreamAPI.Employee;
import pro.sky.StreamAPI.service.EmployeeSalaryService;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeSalaryController {

    private final EmployeeSalaryService employeeSalaryService;

    public EmployeeSalaryController(EmployeeSalaryService EmployeeSalaryService){
        this.employeeSalaryService = EmployeeSalaryService;
    }

    @GetMapping(path = "/departments/max-salary")
    public String findMaxSalaryEmployeeByDepartment(@RequestParam("departmentId") int department){
        Employee employee = employeeSalaryService.findMaxSalaryEmployeeByDepartment(department);
        return employee.getLastName() + " " + employee.getFirstName() + " " + employee.getSalary();
    }

    @GetMapping(path = "/departments/min-salary")
    public String findMinSalaryEmployeeByDepartment(@RequestParam("departmentId") int department){
        Employee employee = employeeSalaryService.findMinSalaryEmployeeByDepartment(department);
        return employee.getLastName() + " " + employee.getFirstName() + " " + employee.getSalary();
    }

    @GetMapping(path = "/departments/all")
    public List<Employee> allEmployeesByDepartment(@RequestParam("departmentId") int department){
        return employeeSalaryService.allEmployeesByDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getTopEmployeesByDepartment(){
        return employeeSalaryService.allEmployeesDepartments();
    }
}