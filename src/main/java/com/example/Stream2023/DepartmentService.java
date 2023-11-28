package com.example.Stream2023;


import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public List<Employee>  returnMaxSalary (int department);
    public List<Employee>  returnMinSalary( int department);
    public List<Employee> returnEmployeeByDepartment (int department);
    public Map<Integer, List <Employee>> returnAllEmployee ();

}