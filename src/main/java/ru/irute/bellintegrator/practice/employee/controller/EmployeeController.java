package ru.irute.bellintegrator.practice.employee.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.irute.bellintegrator.practice.employee.dto.EmployeeDto;
import ru.irute.bellintegrator.practice.employee.servise.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping(value = "/list")
    public List<EmployeeDto> getUserList(@RequestBody EmployeeDto employeeDto) {
        return employeeService.list(employeeDto);
    }


    @GetMapping(value = "/{id}")
    public EmployeeDto getUserById(@PathVariable Long id) {
        return employeeService.getEmployeeToId(id);
    }


    @PostMapping(value = "/save")
    public void saveUser(@RequestBody EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
    }
}
