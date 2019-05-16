package alex.enterprise.employeerestservice.repo;

import alex.enterprise.employeerestservice.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
