package nl.eimertvink.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {

    private String firstname;
    private String lastname;
    private String position;
    private String department;
    private Float salary;

    public Employee() {
        super();
    }

    public Employee(String firstname, String lastname, String position, String department, Float salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String full_name, String position, String department, Float salary) {
        // split SURNAME, FIRSTNAME in two parts. Remove leading whitespace after ,
        this.firstname = full_name.split(",")[1].replaceAll("^\\s+", "");
        this.lastname = full_name.split(",")[0];
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
