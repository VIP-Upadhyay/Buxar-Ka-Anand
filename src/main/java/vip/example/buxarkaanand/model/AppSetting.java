package vip.example.buxarkaanand.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_setting")
public class AppSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @Column(name = "app_id")
    private Long appId;

    @Column(name = "app_key")
    private String key;

    @Column(name = "upi_id")
    private String upiId;

    @Column(name = "address")
    private String address;

    @Column(name = "facebook_link")
    private String facebookLink;

    @Column(name = "twitter_link")
    private String twitterLink;

    @Column(name = "instagram_link")
    private String instagramLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "email")
    private String email;
    
    
    

    public AppSetting() {
		super();
		// TODO Auto-generated constructor stub
	}

    
	public AppSetting(Long appId, String key, String upiId, String address, String facebookLink, String twitterLink,
			String instagramLink, String linkedinLink, String phoneNo, String email) {
		super();
		this.appId = appId;
		this.key = key;
		this.upiId = upiId;
		this.address = address;
		this.facebookLink = facebookLink;
		this.twitterLink = twitterLink;
		this.instagramLink = instagramLink;
		this.linkedinLink = linkedinLink;
		this.phoneNo = phoneNo;
		this.email = email;
	}


	// Getters and setters
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	@Override
	public String toString() {
		return "AppSetting [appId=" + appId + ", key=" + key + ", upiId=" + upiId + ", address=" + address
				+ ", facebookLink=" + facebookLink + ", twitterLink=" + twitterLink + ", instagramLink=" + instagramLink
				+ ", linkedinLink=" + linkedinLink + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
    
    
}

