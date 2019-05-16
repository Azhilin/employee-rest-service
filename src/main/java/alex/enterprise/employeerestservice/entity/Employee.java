package alex.enterprise.employeerestservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String passportNumber;
    private String education;
}
