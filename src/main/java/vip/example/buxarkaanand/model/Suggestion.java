package vip.example.buxarkaanand.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Suggestion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_generator")
	private long sId;
	private String name;
	private String email;
	private String suggestionText;
	public Suggestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Suggestion(long sId, String name, String email, String suggestionText) {
		super();
		this.sId = sId;
		this.name = name;
		this.email = email;
		this.suggestionText = suggestionText;
	}
	public long getsId() {
		return sId;
	}
	public void setsId(long sId) {
		this.sId = sId;
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
	public String getSuggestionText() {
		return suggestionText;
	}
	public void setSuggestionText(String suggestionText) {
		this.suggestionText = suggestionText;
	}
	@Override
	public String toString() {
		return "Suggestion [sId=" + sId + ", name=" + name + ", email=" + email + ", suggestionText=" + suggestionText
				+ "]";
	}
	
	
	
	
}
