package nl.eimertvink.handler;

import nl.eimertvink.model.Employee;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Employee.class)
public class EmployeeEventHandler {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @HandleBeforeCreate
    public void handleBeforeCreate(Employee m) {
        // validate name
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        if (m.getName().length() < 3)
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            throw new IllegalArgumentException("Name must be at least 4 characters");
//        if (m.getPosition().equals(null))
//            throw new IllegalArgumentException("Position can't be null.");
//        if (m.getDepartment().equals(null))
//            throw new IllegalArgumentException("Department can't be null.");
//        if (m.getSalary().equals(null) || m.getSalary() < 0)
//            throw new IllegalArgumentException("Salary can't be lower than 0.");
//        return new ResponseEntity<Employee>(HttpStatus.OK);

    }
}
