package com.iamvickyav.springboot.SpringBootRestWithH2;

import com.iamvickyav.springboot.SpringBootRestWithH2.model.Employee;
import com.iamvickyav.springboot.SpringBootRestWithH2.service.EmployeeService;
import com.mytest.property.UserProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path="/test")
    String test(@RequestParam Integer id){
        return  "woo...working";
    }
    
    
    // Select, Insert, Delete, Update Operations for an Employee

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    Employee getEmployee(@RequestParam Integer id){
        return  employeeService.findOne(id);
    }
    
    @RequestMapping(value = "/employeeName", method = RequestMethod.GET)
    Employee getEmployeeByName(@RequestParam String nm){
    	Employee emp =new Employee();
    	emp.setId(1);
    	emp.setName("dhoni");
        return  emp;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    String addEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.save(employee);
        return "SUCCESS";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    Map deleteEmployee(@RequestParam Integer id){
        employeeService.delete(id);

        Map<String, String> status = new HashMap<>();
        status.put("Status", "Success");
        return status;
    }

    // Select, Insert, Delete for List of Employees

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    String addAllEmployees(@RequestBody List<Employee> employeeList){
        employeeService.save(employeeList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.DELETE)
    String addAllEmployees(){
    	UserProperty up =new UserProperty();
        employeeService.deleteAll();
        return "SUCCESS";
    }
}
