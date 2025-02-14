package pro.sky.StreamAPI.controller;

import pro.sky.StreamAPI.service.Employee;


public class Main {
    public static void getEmployeeArray(Employee[] employeeArray) {
        for (Employee employee : employeeArray) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static int getSumSalary(Employee[] employeeArray) {
        int totalSum = 0;
        for (Employee employee : employeeArray) {
            totalSum += employee.getSalary();
        }
        return totalSum;
    }

    public static Employee getMinimalSalary(Employee[] employeeArray) {
        Employee flagEmployee = null;
        int minimalSalary = getSumSalary(employeeArray) + 1;
        for (Employee employee : employeeArray) {
            if (employee.getSalary() < minimalSalary) {
                flagEmployee = employee;
                minimalSalary = employee.getSalary();
            }
        }
        return flagEmployee;
    }

    public static Employee getMaximalSalary(Employee[] employeeArray) {
        Employee flagEmployee = null;
        int maximalSalary = -1;
        for (Employee employee : employeeArray) {
            if (employee.getSalary() > maximalSalary) {
                flagEmployee = employee;
                maximalSalary = employee.getSalary();
            }
        }
        return flagEmployee;
    }

    public static double getAverageSalary(Employee[] employeeArray) {
        return (double) getSumSalary(employeeArray) / employeeArray.length;
    }

    public static void getEmployeeFullNames(Employee[] employeeArray) {
        for (Employee employee : employeeArray) {
            System.out.println(employee.getFullName());
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[10]; // Хранилище для записей о сотрудниках

        // Добавляем сотрудников в массив с фамилией и инициалами
        employees[0] = new Employee("Иванов И.И.", 1, 50000);
        employees[1] = new Employee("Петров П.П.", 2, 60000);
        employees[2] = new Employee("Смирнов С.С.", 3, 70000);
        employees[3] = new Employee("Сергеев С.С.", 4, 55000);
        employees[4] = new Employee("Маринина М.М.", 5, 75000);
        employees[5] = new Employee("Кузнецов К.К.", 1, 48000);
        employees[6] = new Employee("Попов П.П.", 2, 62000);
        employees[7] = new Employee("Сидоров С.С.", 3, 72000);
        employees[8] = new Employee("Федоров Ф.Ф.", 4, 53000);
        employees[9] = new Employee("Давыдов Д.Д.", 5, 80000);

        getEmployeeArray(employees);
        System.out.println(getSumSalary(employees));
        System.out.println(getMinimalSalary(employees));
        System.out.println(getMaximalSalary(employees));
        System.out.println(getAverageSalary(employees));
        getEmployeeFullNames(employees);

    }
}