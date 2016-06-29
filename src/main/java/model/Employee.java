package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "employee_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSeq")
	@SequenceGenerator(name = "employeeSeq", sequenceName = "employeeIdSeq", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "first_name")
	@NotEmpty
	private String firstName;

	@Column(name = "second_name")
	@NotEmpty
	private String secondName;

	private String mark;
	private String function;

	@Column(name = "employment_date")
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date employmentDate;
	
	private Boolean active;

	public Employee() {
	}

	public Employee(String firstName, String secondName, String mark, String function, Date employmentDate) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.mark = mark;
		this.function = function;
		this.employmentDate = employmentDate;
		this.active = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
