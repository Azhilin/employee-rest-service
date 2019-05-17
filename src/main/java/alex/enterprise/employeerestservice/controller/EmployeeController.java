package alex.enterprise.employeerestservice.controller;

import alex.enterprise.employeerestservice.entity.Employee;
import alex.enterprise.employeerestservice.exception.CustomRuntimeException;
import alex.enterprise.employeerestservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    @PutMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        if (isNull(employee)) {
            throw new CustomRuntimeException("Employee cannot be null");
        }

        return employeeService.add(employee);
    }

    @PutMapping("/addlist")
    public List<Employee> addList(@RequestBody List<Employee> employees) {
        if (employees.isEmpty()) {
            throw new CustomRuntimeException("No employees to add!");
        }

        employeeService.addList(employees);
        return employeeService.getAll();
    }
}
