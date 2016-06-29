package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import annotation.AssetSerie;

@Entity
@Table(name = "asset")
public class Asset {

	private String test;
	@Id
	@Column(name = "asset_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assetSeq")
	@SequenceGenerator(name = "assetSeq", sequenceName = "assetIdSeq", initialValue = 1, allocationSize = 1)
	private Long id;

	@NotEmpty
	private String name; // TODO enum for names
	
	@NotEmpty
	@AssetSerie
	private String serie;

	public Asset() {
	}

	public Asset(String name, String serie) {
		this.name = name;
		this.serie = serie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
}