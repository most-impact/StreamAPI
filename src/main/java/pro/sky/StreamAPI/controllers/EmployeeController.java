package pro.sky.StreamAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import pro.sky.StreamAPI.Employee;
import pro.sky.StreamAPI.service.EmployeeService;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String name, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        // Ваш код для обработки запроса
        Employee employee = new Employee(name, lastName, salary, department);
        return employeeService.addEmployee(employee);

    }

    @GetMapping(path = "/find")
    public Employee getId(@RequestParam("firstName") String name, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        // Ваш код для обработки запроса
        return employeeService.findEmployee(name, lastName);
    }


    @GetMapping(path = "/del")
    public Employee delete(@RequestParam("firstName") String name, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(name, lastName);
    }


    @GetMapping
    public Employee hello() {
        Employee employee = new Employee("john", "parker", 10000, 1);
        return employee;
    }
}