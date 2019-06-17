package lk.sandun.controller;

import lk.sandun.model.Address;
import lk.sandun.model.Employee;
import lk.sandun.repository.EmployeeRepository;
import lk.sandun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pirasanth on 6/4/2019.
 */

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST,value = "/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/get")
    public List<Employee> getAllEmployees(){
        return employeeService.fetchAllEmployee();
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/updateUser/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id , @RequestBody Employee employee){
        Employee tempEmployee=new Employee();
        tempEmployee.setId(id);
        Employee updatedemployee=employeeService.fetchEmployee(tempEmployee);
        if (!employeeService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        updatedemployee.setName(employee.getName());
        updatedemployee.setAge(employee.getAge());

        Address add = updatedemployee.getAddress();
        if(add!=null && employee.getAddress()!=null){
            add.setCity(employee.getAddress().getCity());
            add.setState(employee.getAddress().getState());
        }

       /* Address address = new Address();
        address.setCity("");
        address.setState("");
        //address = addressService.save(address);

        updatedemployee.setAddress(address);*/

        return ResponseEntity.ok(employeeService.saveEmployee(updatedemployee));
    }


    @RequestMapping(method = RequestMethod.DELETE,value = "deleteUser/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!employeeService.findById(id).isPresent()) {
             ResponseEntity.badRequest().build();
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

}
