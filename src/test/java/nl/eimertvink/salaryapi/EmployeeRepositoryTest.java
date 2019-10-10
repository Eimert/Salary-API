package nl.eimertvink.salaryapi;

import nl.eimertvink.entity.Employee;
import nl.eimertvink.repository.EmployeeRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    @Ignore
    public void findByFilter() {
        // TODO Eimert
    }

    @Test
    @Ignore
    public void saveTest() {
        // TODO Eimert
        Employee e = new Employee();
//        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(e));
    }

}
