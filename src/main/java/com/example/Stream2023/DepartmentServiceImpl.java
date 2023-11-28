package com.example.Stream2023;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeServiceImpl employeeService;


    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee>  returnMaxSalary(  int salary) {
        List<Employee> employeeList = new ArrayList<>();
        Optional<Employee> maxSalary= employeeList
                .stream()
                .max(Comparator.comparing(Employee::getSalary));

        return null;
    }

    @Override
    public List<Employee>  returnMinSalary (int salary) {
        List<Employee> employeeList = new ArrayList<>();
        Optional<Employee> minSalary= employeeList
                .stream()
                .min(Comparator.comparing(Employee::getSalary));
        return null;
    }

    @Override
    public List<Employee> returnEmployeeByDepartment(int departmentId) {
        List<Employee> employeeList = new ArrayList<>();
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
