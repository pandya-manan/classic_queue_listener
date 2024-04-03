package com.receiver.consumer.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRegisteredFromClassic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="user_id_generator")
	private Integer serialId;
	
	@Column(name="FULL_NAME",length=255)
	private String fullName;
	
	@Column(name="EMAIL_ADDRESS",length=255)
	private String emailAddress;
	
	@Column(name="CONFIRMATION_CODE")
	private Integer confirmationCode;

	public Integer getSerialId() {
		return serialId;
	}

	public void setSerialId(Integer serialId) {
		this.serialId = serialId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(Integer confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public UserRegisteredFromClassic(Integer serialId, String fullName, String emailAddress, Integer confirmationCode) {
		super();
		this.serialId = serialId;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.confirmationCode = confirmationCode;
	}

	public UserRegisteredFromClassic() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserRegisteredToDb [serialId=" + serialId + ", fullName=" + fullName + ", emailAddress=" + emailAddress
				+ ", confirmationCode=" + confirmationCode + "]";
	}
	
	
	
	
	
	

}
