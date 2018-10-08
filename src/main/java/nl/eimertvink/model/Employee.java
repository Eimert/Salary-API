package nl.eimertvink.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
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
    private Integer id;
    @Size(min = 3)
    @Getter
    @Setter
    private String name;
    @NotNull
    @Getter
    @Setter
    private String position;
    @NotNull
    @Getter
    @Setter
    private String department;
    @Min(0)
    @Getter
    @Setter
    private Float salary;
    //    @NotNull
    @Size(min = 3)
    @Getter
    @Setter
    private String email;
    //    @NotNull
    @JsonIgnore
    @Getter
    @Setter
    private String password;
    @NotNull
    @Min(0)
    @Max(1)
    @Getter
    @Setter
    private Integer enabled;

    @Override
    public String toString() {
        return String.format("%s %s", name, position);
    }
}
