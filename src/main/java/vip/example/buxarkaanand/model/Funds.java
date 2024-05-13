package vip.example.buxarkaanand.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Funds {
	@Id
	Long fundId;
	
	@Column(name = "fund_key")
	private String key;
	
	private double totalFunds;

	public Funds() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funds(long id, String key, double totalFunds) {
		super();
		fundId = id;
		this.key = key;
		this.totalFunds = totalFunds;
	}

	public long getId() {
		return fundId;
	}

	public void setId(long id) {
		fundId = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public double getTotalFunds() {
		return totalFunds;
	}

	public void setTotalFunds(double totalFunds) {
		this.totalFunds = totalFunds;
	}

	@Override
	public String toString() {
		return "funds [Id=" + fundId + ", key=" + key + ", totalFunds=" + totalFunds + "]";
	}
	
	
}
