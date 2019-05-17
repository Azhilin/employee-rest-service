package alex.enterprise.employeerestservice.service;

import alex.enterprise.employeerestservice.entity.Employee;
import alex.enterprise.employeerestservice.exception.CustomRuntimeException;
import alex.enterprise.employeerestservice.repo.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAll() {
        return (List<Employee>) employeeDao.findAll();
    }

    public Employee getById(Integer id) {
        return employeeDao.findById(id).orElseThrow(() -> new CustomRuntimeException(String.format("Employee was not found with particular id: %s", id)));
    }

    public Employee add(Employee employee) {
        if (isNull(employee)) {
            throw new CustomRuntimeException("Employee cannot be null");
        }

        employeeDao.save(employee);
        Integer id = employee.getId();
        Optional<Employee> employeeOptional = employeeDao.findById(id);
        return employeeOptional.orElseThrow(() ->
                new CustomRuntimeException(String.format("Stored employee was not found with particular id: %s", id)));
    }

    public void addList(List<Employee> employees) {
        employees.forEach(employee -> employeeDao.save(employee));
    }
}
