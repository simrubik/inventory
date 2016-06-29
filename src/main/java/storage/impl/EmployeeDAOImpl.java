package storage.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import model.Employee;
import storage.EmployeeDAO;

@Repository("employeeDAOImpl")
public class EmployeeDAOImpl implements EmployeeDAO{

	@PersistenceContext
	private EntityManager em;
	
	public void createEmployee(Employee employee) {
		em.persist(employee);
		
	}

	public Employee getEmployeeById(Long id) {
		return em.createQuery("SELECT e FROM Employee e WHERE e.id=:id", Employee.class).setParameter("id", id).getSingleResult();
	}

	public List<Employee> getEmployeeByName(String name) {
		return em.createQuery(
				"SELECT e FROM Employee e WHERE lower(e.firstName) like :name or lower(e.secondName) like :name ORDER BY e.firstName, e.secondName",
				Employee.class).setParameter("name", '%' + name.toLowerCase() + '%').getResultList();
	}

	public List<Employee> getAll() {
		return em.createQuery("SELECT e FROM Employee e ORDER BY e.firstName, e.secondName", Employee.class).getResultList();
	}

	public void updateEmployee(Long oldEmployeeId, Employee newEmployee) {
		deleteEmployee(oldEmployeeId);
		em.merge(newEmployee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = em.find(Employee.class, employeeId);
		employee.setActive(true);
		
		em.merge(employee);
	}

}
