package hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import model.Employee;
import storage.EmployeeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springConfig/spring-config-test.xml")
//@TestPropertySource(locations = "classpath:springConfig/dbCredentials-hsql-test.properties")
//@Configuration
@Transactional
public class EmployeeDAOImplTest {

//	@Autowired
//    private Environment env;
	
	@Autowired
	private EmployeeDAO employeeDao;

	@Test
	public void testCreateEmployee() {
//		System.out.println(env.getProperty("jdbc.url"));
		
		List<Employee> list = new ArrayList<>();
		Employee emp = new Employee("Ana", "Borosu", "Programator", "Programator", new Date());
		Employee emp2 = new Employee("Adi", "Iriciuc", "Programator", "Programator", new Date());

		employeeDao.createEmployee(emp);
		employeeDao.createEmployee(emp2);

		list = employeeDao.getAll();
		Assert.assertEquals(2, list.size());
	}

}
