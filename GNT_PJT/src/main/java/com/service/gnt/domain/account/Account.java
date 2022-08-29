package com.service.gnt.domain.account;

import com.service.gnt.domain.card.Card;

public class Account {
	
	private String accId;
	private Card card;
	private int accPassword;
	private String createTime;
	private String accAmount;
	private String mileage;
	
	
	public Account() {}


	public Account(String accId, Card card, int accPassword, String createTime, String accAmount, String mileage) {
		super();
		this.accId = accId;
		this.card = card;
		this.accPassword = accPassword;
		this.createTime = createTime;
		this.accAmount = accAmount;
		this.mileage = mileage;
	}


	public String getAccId() {
		return accId;
	}


	public void setAccId(String accId) {
		this.accId = accId;
	}


	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
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


	public String getAccAmount() {
		return accAmount;
	}


	public void setAccAmount(String accAmount) {
		this.accAmount = accAmount;
	}


	public String getMileage() {
		return mileage;
	}


	public void setMileage(String mileage) {
		this.mileage = mileage;
	}


	@Override
	public String toString() {
		return "Account [accId=" + accId + ", card=" + card + ", accPassword=" + accPassword + ", createTime="
				+ createTime + ", accAmount=" + accAmount + ", mileage=" + mileage + "]";
	}
	
	

	
}
