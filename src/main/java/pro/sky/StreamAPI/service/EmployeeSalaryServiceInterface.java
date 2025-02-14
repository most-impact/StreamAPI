    package pro.sky.StreamAPI.service;

    import pro.sky.StreamAPI.Employee;

    import java.util.List;
    import java.util.Map;

    public interface EmployeeSalaryServiceInterface {
        Employee findMaxSalaryEmployeeByDepartment(int department);

        Employee findMinSalaryEmployeeByDepartment(int department);

        List<Employee> allEmployeesByDepartment(int department);

        Map<Integer, List<Employee>> allEmployeesDepartments();


    }