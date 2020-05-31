package nl.eimertvink.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "salaries")
@Validated
public class Employee {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Getter
    @JsonProperty("Id")
    private Integer id;
    @Size(min = 3)
    @Getter @Setter
    private String name;
    @NotNull @Getter @Setter
    private String position;
    @NotNull @Getter @Setter
    private String department;
    @Min(0) @Getter @Setter
    private Double salary;

}
