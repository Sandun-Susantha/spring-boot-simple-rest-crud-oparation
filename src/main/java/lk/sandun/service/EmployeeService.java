package lk.sandun.service;

import lk.sandun.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pirasanth on 6/4/2019.
 */
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> fetchAllEmployee();
    Optional<Employee> findById(Integer id);
    Employee fetchEmployee(Employee employee);
    void deleteEmployee(Integer id);
}
