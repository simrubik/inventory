package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "returning_object")
public class Returning {

	@Id
	@Column(name = "returning_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReturningSeq")
	@SequenceGenerator(name = "ReturningSeq", sequenceName = "returningIdSeq", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "returning_date")
	private Date returningDate;

	@Column(name = "type_object")
	private String type;

	private String number;
	private Integer quantity;

	public Returning() {
	}

	public Returning(Date returningDate, String type, String number, Integer quantity) {
		this.returningDate = returningDate;
		this.type = type;
		this.number = number;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(Date returningDate) {
		this.returningDate = returningDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
