package pro.sky.SteramAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.StreamAPI.Employee;
import pro.sky.StreamAPI.service.EmployeeService;
import pro.sky.StreamAPI.service.EmployeeServiceImpl;


import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    void setUp(){
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void addEmployees_success(){
        Employee employee = new Employee("Ivan", "Ivanov", 25000, 1);
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.findEmployee(1));
    }

    @Test
    void addEmployees_alreadyExists() {
        Employee employee = new Employee("Sergey", "Sergeev", 15000, 2);
        employeeService.addEmployee(employee);
        assertThrows(RuntimeException.class, () -> employeeService.addEmployee(employee));
    }

    @Test
    void removeEmployee_success() {
        Employee employee = new Employee("Petr", "Petrov", 40000, 1);
        employeeService.addEmployee(employee);
        employeeService.removeEmployee(3);
        assertThrows(RuntimeException.class, () -> employeeService.removeEmployee(1));
    }


    @Test
    void removeEmployee_notFound(){
        assertThrows(RuntimeException.class, () -> employeeService.removeEmployee(150));
    }

    @Test
    void findEmployee_success(){
        Employee employee = new Employee("Filip", "Filipov", 100000, 2);
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.findEmployee(4));
    }

    @Test
    void findEmployee_notFound(){
        assertThrows(RuntimeException.class, () -> employeeService.findEmployee(150));
    }

    @Test
    void getAllEmployees_empty(){
        assertTrue(employeeService.getAllEmployees().isEmpty());
    }
}