package com.demo.wipro.controller;

import com.demo.wipro.model.Employee;
import com.demo.wipro.reporisitry.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/table")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @RequestMapping("/emp")
    private List<Employee> getAllEmployees() {
    return  employeeRepository.findAll();
    }
    // for get the data
    @GetMapping("/emp/{id}")
    private  Employee getEmployeeById(@PathVariable Long id) {
      return  employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }
    // for set the data
    @PostMapping("/emp")
    private  Employee addEmployee( @RequestBody Employee employee) {
    return  employeeRepository.save(employee);
    }

    // update the data
    @PutMapping("/emp/{id}")
  public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){

          try{
              Employee existEmployee=getEmployeeById(id);
              return  new ResponseEntity<Employee>(employee, HttpStatus.OK);
          }
          catch (NoSuchElementException e){
              return new ResponseEntity<Employee>(employee,HttpStatus.NOT_FOUND);
          }
    }


//     delete the data from employee table
//    @DeleteMapping("/emp/{id}")
//    private void deleteEmployee(@PathVariable Long id) {
//        employeeRepository.deleteById(id);
//    }
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){

        try{
            this. employeeRepository.deleteById(Long.parseLong(String.valueOf(id)));
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
