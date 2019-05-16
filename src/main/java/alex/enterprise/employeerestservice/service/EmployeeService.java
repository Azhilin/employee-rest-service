package alex.enterprise.employeerestservice.service;

import alex.enterprise.employeerestservice.entity.Employee;
import alex.enterprise.employeerestservice.repo.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAll() {
        return (List<Employee>) employeeDao.findAll();
    }

    public Employee getById(Integer id) {
        return employeeDao.findById(id).get();
    }
}
