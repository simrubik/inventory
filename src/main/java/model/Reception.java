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
@Table(name = "reception_object")
public class Reception {

	@Id
	@Column(name = "reception_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receptionSeq")
	@SequenceGenerator(name = "receptionSeq", sequenceName = "receptionIdSeq", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "reception_date")
	private Date receptionDate;

	@Column(name = "type_object")
	private String type;

	private String number;
	

	private Integer quantity;

	public Reception() {
	}

	public Reception(Date receptionDate, String type, String number, Integer quantity) {
		this.receptionDate = receptionDate;
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

	public Date getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(Date receptionDate) {
		this.receptionDate = receptionDate;
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
