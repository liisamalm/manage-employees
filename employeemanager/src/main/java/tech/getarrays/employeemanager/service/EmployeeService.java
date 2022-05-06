package tech.getarrays.employeemanager.service;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repos.EmployeeRepository;
/* import tech.getarrays.employeemanager.EmployeeResource;
import tech.getarrays.employeemanager.UserNotFoundException;


import tech.getarrays.employeemanager.EmployeeRepository; */
@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
/* Lisää työntekijä */
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

/* Listaa kaikki työntekijät */  
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    
/* muokkaa työntekijän tietoja, tallenna */
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

/* etsi työntekijä id:n perusteella */
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
            .orElseThrow(() -> new UserNotFoundException ("User by id " + id + " was not found"));
    }

/* poista työntekijä idn perusteella */
   
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
