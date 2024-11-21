package com.demo.wipro.reporisitry;

import com.demo.wipro.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Long->primary key
// employee table name
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
