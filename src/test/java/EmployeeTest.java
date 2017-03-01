import com.phonebook.model.Employee;
import com.phonebook.service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dispatcher-servlet.xml", "classpath:appconfig-root.xml"})

@Transactional
public class EmployeeTest {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    public void queryAllUsers() {
        List<Employee> employees = employeeServiceImpl.findAllEmployee();
        Assert.assertNotNull(employees);
    }
}
