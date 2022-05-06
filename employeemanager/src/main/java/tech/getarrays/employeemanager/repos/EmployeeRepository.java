package tech.getarrays.employeemanager.repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
