package pro.sky.SteramAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pro.sky.StreamAPI.Employee;

import org.mockito.MockitoAnnotations;
import pro.sky.StreamAPI.service.DepartmentServiceImpl;
import pro.sky.StreamAPI.service.EmployeeService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployeesByDepartment_success() {
        List<Employee> employees = Arrays.asList(
                new Employee("Petr", "Petrov", 50000, 1),
                new Employee("Ivan", "Ivanov", 60000, 1),
                new Employee("Pavel", "Pavlov", 70000, 2)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        List<Employee> result = departmentService.getEmployeesByDepartment(1);
        assertEquals(2, result.size());
        assertEquals("Petr Petrov", result.get(0).getFullName());
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void getSalarySumByDepartment_success() {
        List<Employee> employees = Arrays.asList(
                new Employee("Roman", "Romanov", 50000, 1),
                new Employee("Vasiliy", "Vasiliev", 60000, 1)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        double sum = departmentService.getSalarySumByDepartment(1);
        assertEquals(110000, sum);
    }

    @Test
    void getMaxSalaryByDepartment_noEmployees() {
        when(employeeService.getAllEmployees()).thenReturn(List.of());
        assertThrows(RuntimeException.class, () -> departmentService.getMaxSalaryByDepartment(1));
    }

    @Test
    void getMinSalaryByDepartment_success() {
        List<Employee> employees = Arrays.asList(
                new Employee("Bogdan", "Bogdanov", 50000, 1),
                new Employee("Maxim", "Maximov", 60000, 1)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        double minSalary = departmentService.getMinSalaryByDepartment(1);
        assertEquals(50000, minSalary);
    }

    @Test
    void getEmployeesGroupedByDepartment_success() {
        List<Employee> employees = Arrays.asList(
                new Employee("Filip", "Filipov", 50000, 1),
                new Employee("Dmitriy", "Dmitriev", 60000, 2)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        Map<Integer, List<Employee>> result = departmentService.getEmployeesGroupedByDepartment();
        assertEquals(1, result.get(1).size());
        assertEquals(1, result.get(2).size());
    }
}