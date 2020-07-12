package nl.eimertvink.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
@Validated
public class Salaries extends AbstractEntity {

    @Size(min = 3) @Getter @Setter
    private String name;
    @NotNull @Getter @Setter
    private String position;
    @NotNull @Getter @Setter
    private String department;
    @Min(0) @Getter @Setter
    private Double salary;

}
