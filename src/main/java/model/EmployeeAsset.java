package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee_asset")
public class EmployeeAsset {

	@Id
	@Column(name = "employee_asset_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeAssetSeq")
	@SequenceGenerator(name = "EmployeeAssetSeq", sequenceName = "employeeAssetIdSeq", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "asset_id")
	private Asset asset;

	@Column(name = "use_time")
	private String useTime;

	private String pu;
	private String um;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="reception_id")
	private Reception reception;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="returning_id")
	private Returning returning;

	public EmployeeAsset() {
	}

	public EmployeeAsset(Employee employee, Asset asset, String useTime, String pu, String um) {
		this.employee = employee;
		this.asset = asset;
		this.useTime = useTime;
		this.pu = pu;
		this.um = um;
	}

	public EmployeeAsset(Employee employee, Asset asset, String useTime, String pu, String um, Reception reception, Returning returning) {
		this.employee = employee;
		this.asset = asset;
		this.useTime = useTime;
		this.pu = pu;
		this.um = um;
		this.reception = reception;
		this.returning = returning;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getPu() {
		return pu;
	}

	public void setPu(String pu) {
		this.pu = pu;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public Reception getReception() {
		return reception;
	}

	public void setReception(Reception reception) {
		this.reception = reception;
	}

	public Returning getReturning() {
		return returning;
	}

	public void setReturning(Returning returning) {
		this.returning = returning;
	}

}
