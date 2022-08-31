package com.service.gnt.domain.account;

public class Account {
	
	private String accId;
	//private Card card;
	private String cardId;
	private int accPassword;
	private String createTime;
	private int accAmount;
	private int mileage;
	private char isMileage;
	
	
	public Account() {}
	
	

	public Account(String accId, int accPassword) {
		super();
		this.accId = accId;
		this.accPassword = accPassword;
	}

	public Account(String accId, String cardId, int accPassword, String createTime, int accAmount, int mileage) {
		super();
		this.accId = accId;
		this.cardId = cardId;
		this.accPassword = accPassword;
		this.createTime = createTime;
		this.accAmount = accAmount;
		this.mileage = mileage;
	}


	public Account(String accId, String cardId, int accPassword, String createTime, int accAmount, int mileage,
			char isMileage) {
		super();
		this.accId = accId;
		this.cardId = cardId;
		this.accPassword = accPassword;
		this.createTime = createTime;
		this.accAmount = accAmount;
		this.mileage = mileage;
		this.isMileage = isMileage;
	}



	public char getIsMileage() {
		return isMileage;
	}



	public void setIsMileage(char isMileage) {
		this.isMileage = isMileage;
	}



	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public String getAccId() {
		return accId;
	}


	public void setAccId(String accId) {
		this.accId = accId;
	}


	public int getAccPassword() {
		return accPassword;
	}


	public void setAccPassword(int accPassword) {
		this.accPassword = accPassword;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public int getAccAmount() {
		return accAmount;
	}


	public void setAccAmount(int accAmount) {
		this.accAmount = accAmount;
	}


	public int getMileage() {
		return mileage;
	}


	public void setMileage(int mileage) {
		this.mileage = mileage;
	}



	@Override
	public String toString() {
		return "Account [accId=" + accId + ", cardId=" + cardId + ", accPassword=" + accPassword + ", createTime="
				+ createTime + ", accAmount=" + accAmount + ", mileage=" + mileage + ", isMileage=" + isMileage + "]";
	}
}
