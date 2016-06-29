package dto;

import org.hibernate.validator.constraints.NotEmpty;

public class Inventory {
	
	@NotEmpty
	private String assetName;
	
	@NotEmpty
	private String assetSerie;
	
	@NotEmpty
	private String useTime;
	private String pu;
	private String um;
	private String receptionDate;
	private String receptionType;
	private String receptionNumber;
	private String receptionQuantity;
	private String returningDate;
	private String returningType;
	private String returningnNumber;
	private String returningQuantity;
	
	public Inventory() {
	}

	public Inventory(String assetName, String assetSerie, String useTime, String pu, String um, String receptionDate,
			String receptionType, String receptionNumber, String receptionQuantity, String returningDate,
			String returningType, String returningnNumber, String returningQuantity) {
		this.assetName = assetName;
		this.assetSerie = assetSerie;
		this.useTime = useTime;
		this.pu = pu;
		this.um = um;
		this.receptionDate = receptionDate;
		this.receptionType = receptionType;
		this.receptionNumber = receptionNumber;
		this.receptionQuantity = receptionQuantity;
		this.returningDate = returningDate;
		this.returningType = returningType;
		this.returningnNumber = returningnNumber;
		this.returningQuantity = returningQuantity;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetSerie() {
		return assetSerie;
	}

	public void setAssetSerie(String assetSerie) {
		this.assetSerie = assetSerie;
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

	public String getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(String receptionDate) {
		this.receptionDate = receptionDate;
	}

	public String getReceptionType() {
		return receptionType;
	}

	public void setReceptionType(String receptionType) {
		this.receptionType = receptionType;
	}

	public String getReceptionNumber() {
		return receptionNumber;
	}

	public void setReceptionNumber(String receptionNumber) {
		this.receptionNumber = receptionNumber;
	}

	public String getReceptionQuantity() {
		return receptionQuantity;
	}

	public void setReceptionQuantity(String receptionQuantity) {
		this.receptionQuantity = receptionQuantity;
	}

	public String getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}

	public String getReturningType() {
		return returningType;
	}

	public void setReturningType(String returningType) {
		this.returningType = returningType;
	}

	public String getReturningnNumber() {
		return returningnNumber;
	}

	public void setReturningnNumber(String returningnNumber) {
		this.returningnNumber = returningnNumber;
	}

	public String getReturningQuantity() {
		return returningQuantity;
	}

	public void setReturningQuantity(String returningQuantity) {
		this.returningQuantity = returningQuantity;
	}

	
	
}
