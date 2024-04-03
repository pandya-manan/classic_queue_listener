package com.receiver.consumer;

public class UserRegisteredPayLoad {
	
	public String fullName;
    public String emailAddress;
    public int confirmationCode;
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
	public int getConfirmationCode() {
		return confirmationCode;
	}
	public void setConfirmationCode(int confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
	public UserRegisteredPayLoad(String fullName, String emailAddress, int confirmationCode) {
		super();
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.confirmationCode = confirmationCode;
	}
	public UserRegisteredPayLoad() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
	

}
