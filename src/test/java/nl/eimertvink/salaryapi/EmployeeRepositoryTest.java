package nl.eimertvink.salaryapi;

import nl.eimertvink.configuration.PersistenceJPAConfig;
import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryTest {

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    PersistenceJPAConfig persistenceJPAConfig;

    @Test(timeout = 200)
//    @Ignore
    public void queryByMaxInternalSalaryTest() {
        employeeRepository.queryByMaxInternalSalary();
    }

    @Test
    public void saveTest() {
        Employee e = new Employee();
        e.setName("Carl Black");
        e.setPosition("Officer");
        e.setDepartment("Police");
        e.setSalary(80000f);
        employeeRepository.save(e);
    }
}
