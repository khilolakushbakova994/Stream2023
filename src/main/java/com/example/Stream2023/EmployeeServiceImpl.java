package com.example.Stream2023;

import org.springframework.stereotype.Service;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;


@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (!checkName(firstName, lastName) ){
            throw new InvalidTextException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (!checkName(firstName, lastName) ){
            throw new InvalidTextException();}
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        if (!checkName(firstName, lastName) ){
            throw new InvalidTextException();}
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
    }

    @Override
    public List<Employee> showAllEmployeeList() {

        return Collections.unmodifiableList(employees.values().stream().toList());
    }

    private boolean checkName(String firstName, String lastName) {
       return  isAlpha(firstName) && isAlpha(lastName);

    }

}






