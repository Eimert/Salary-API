package nl.eimertvink.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
@Validated
public class Salaries extends AbstractEntity {

    @Size(min = 3) @Getter @Setter
    private String name;
    @NotNull @Getter @Setter
    @Column(name = "jobtitles")
    private String jobTitles;
    @NotNull @Getter @Setter
    private String department;
    @Getter @Setter
    @Column(name = "fullorparttime")
    private String fullOrPartTime;
    @Getter @Setter
    @Column(name = "salaryorhourly")
    private String salaryOrHourly;
    @Getter @Setter
    @Column(name = "typicalhours")
    private String typicalHours;
    @Getter @Setter
    @Column(name = "annualsalary")
    private Double annualSalary;
    @Getter @Setter
    @Column(name = "hourlyrate")
    private Double hourlyRate;

}
