package vip.example.buxarkaanand.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	private long userId;
	private String name;
	private String email;
	private String phoneNo;
	private double amount;
	private String address;
	private String panNo;
	private String transactionMessage;
	private Status status;
	private String ss;
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserData(long userId, String name, String email, String phoneNo, double amount, String address, String panNo,
			String transactionMessage, Status status,String ss) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.amount = amount;
		this.address = address;
		this.panNo = panNo;
		this.transactionMessage = transactionMessage;
		this.status = status;
		this.ss = ss;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getTransactionMessage() {
		return transactionMessage;
	}

	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", amount=" + amount + ", address=" + address + ", panNo=" + panNo + ", transactionMessage="
				+ transactionMessage + ", status=" + status + ", ss=" + ss + "]";
	}

	

	
	
	
}
