package com.example.Stream2023;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee searchEmployee(String firstName, String lastName) ;
    List<Employee> showAllEmployeeList();
}
