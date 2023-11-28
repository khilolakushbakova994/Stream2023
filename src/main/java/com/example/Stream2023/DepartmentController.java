package com.example.Stream2023;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/departments")


public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {this.departmentService = departmentService;}

    @GetMapping ("/max-salary")
    public List<Employee> returnMaxSalary
            (@RequestParam int department){
        return departmentService.returnMaxSalary(department);
    }
    @GetMapping ("/min-salary")
    public List<Employee> returnMinSalary
            (@RequestParam int department){
        return departmentService.returnMinSalary(department);
    }
    @GetMapping ("/all")
    public List<Employee> returnEmployeeByDepartment (@RequestParam int department){
        return departmentService.returnEmployeeByDepartment(department);
    }
    @GetMapping ("/all")
    public Map<Integer, List <Employee>> returnAll (@RequestParam int department){
        return departmentService.returnAllEmployee ();
    }





}
