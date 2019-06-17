package lk.sandun.service;

import lk.sandun.model.Employee;
import lk.sandun.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pirasanth on 6/4/2019.
 */

@Service
public class EmployeeServiceImplements implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> fetchAllEmployee(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Integer id){
        Optional<Employee> optionalUser = employeeRepository.findById(id);
        if (optionalUser.isPresent()){
            return employeeRepository.findById(id);
        }else {
            return null;
        }

    }

    @Override
    public Employee fetchEmployee(Employee employee) {
        Optional<Employee> optional= employeeRepository.findById(employee.getId());
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }

    @Override
    public void deleteEmployee(Integer id){
         employeeRepository.deleteById(id);
    }
}
