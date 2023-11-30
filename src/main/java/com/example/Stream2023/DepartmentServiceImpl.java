package com.example.Stream2023;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;


    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> returnMaxSalary(int department) {
        List<Employee> employeeList = employeeService.showAllEmployeeList();
        List<Employee> maxSalary = employeeList
                .stream()
                .max(Comparator.comparing(Employee::getSalary)).stream().toList();

        return maxSalary;
    }

    @Override
    public List<Employee>  returnMinSalary (int department) {
        List<Employee> employeeList = employeeService.showAllEmployeeList();
        Optional<Employee> minSalary= employeeList
                .stream()
                .min(Comparator.comparing(Employee::getSalary));
        return null;
    }

    @Override
    public List<Employee> returnEmployeeByDepartment(int departmentId) {
        List<Employee> employeeList = employeeService.showAllEmployeeList();
        List<Employee> byDepartment = employeeList
                .stream()
                .filter(employee -> employee.getDepartmentId()==departmentId)
                .collect(Collectors.toList());
        return null;
    }

    @Override
    public Map<Integer, List<Employee>>  returnAllEmployee() {
        return employeeService.showAllEmployeeList()
                .stream().collect(Collectors.groupingBy(Employee::getDepartmentId));

    }
}
