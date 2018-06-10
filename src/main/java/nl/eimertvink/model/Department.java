package nl.eimertvink.model;

import javax.persistence.*;

@Entity
@Table(name = "salaries")
//@NamedNativeQuery(name = "Department",
//                query = "select distinct(department) from salaries;",
//                resultClass = Department.class)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // emp id!
    private Integer id;
    private String department;
    private Float salary;

    public Float getSalary() {
        return salary;
    }

//    public void setSalary(Float salary) {
//        this.salary = salary;
//    }

    public String getDepartment() {
        return department;
    }

//    public void setDepartment(String department) {
//        this.department = department;
//    }

    @Override
    public String toString() {
        return "name=" + getDepartment();
    }
}
