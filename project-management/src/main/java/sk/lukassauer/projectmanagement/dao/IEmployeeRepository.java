package sk.lukassauer.projectmanagement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sk.lukassauer.projectmanagement.dto.EmployeeProject;
import sk.lukassauer.projectmanagement.entities.Employee;

import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " +
            "FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
            "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC ")
    List<EmployeeProject> employeeProjects();
}
