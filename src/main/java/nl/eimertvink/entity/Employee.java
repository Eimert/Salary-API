package nl.eimertvink.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "salaries")
@Validated
public class Employee {

    // uppercase Id: serialized. lowercase: not serialized
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Getter
    private Integer Id;
    @Size(min = 3)
    @Getter @Setter
    private String name;
    @NotNull @Getter @Setter
    private String position;
    @NotNull @Getter @Setter
    private String department;
    @Min(0) @Getter @Setter
    private Float salary;
    @Getter @Setter @Email
    private String email;
    @JsonIgnore // don't serialize in output
    @Getter @Setter @ApiModelProperty(hidden = true) // swagger don't show
    private String password;
    @Min(0) @Max(1)
    @Getter @Setter
    private Integer enabled = 0;
    @Getter @Setter
    private LocalDateTime created;
    @Getter @Setter
    private LocalDateTime modified;

    @Override
    public String toString() {
        return String.format("%s %s", name, position);
    }

}
