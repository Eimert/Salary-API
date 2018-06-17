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
        if(!(m.getName().length() > 3))
            throw new IllegalArgumentException("Name must be at least 4 characters");

        if((m.getSalary().equals(null)))
            throw new IllegalArgumentException("Salary can't be null.");

    }
}
