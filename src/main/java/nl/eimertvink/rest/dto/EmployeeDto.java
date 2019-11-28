package nl.eimertvink.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import nl.eimertvink.entity.Employee;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    @Getter @Setter
    private String name;
    @NotNull
    @Getter @Setter
    private String position;
    @NotNull @Getter @Setter
    private String department;
    @Min(0) @Getter @Setter
    private Float salary;
    @Getter @Setter
    private String email;
    @Min(0) @Max(1)
    @Getter @Setter
    private Boolean enabled;
    @Getter @Setter
    private LocalDateTime created;
    @Getter @Setter
    private LocalDateTime modified;

    protected EmployeeDto() {}

    public EmployeeDto(Employee employee) {
        this.name = employee.getName();
        this.position = employee.getPosition();
        this.department = employee.getDepartment();
        this.salary = employee.getSalary();
        this.email = employee.getEmail();
        this.enabled = Boolean.valueOf(employee.getEnabled().toString());
        this.created = employee.getCreated();
        this.modified = employee.getModified();
    }
}
