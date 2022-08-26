package com.service.gnt.domain.account;

import java.sql.Date;


public class AccountTrans {
	
	private String senderAccId;
	private String accAmount;
	private String receiverAccId;
	private Date createTime;
	
	
	public AccountTrans() {}


	public AccountTrans(String senderAccId, String accAmount, String receiverAccId, Date createTime) {
		super();
		this.senderAccId = senderAccId;
		this.accAmount = accAmount;
		this.receiverAccId = receiverAccId;
		this.createTime = createTime;
	}


	public String getSenderAccId() {
		return senderAccId;
	}


	public void setSenderAccId(String senderAccId) {
		this.senderAccId = senderAccId;
	}


	public String getAccAmount() {
		return accAmount;
	}


	public void setAccAmount(String accAmount) {
		this.accAmount = accAmount;
	}


	public String getReceiverAccId() {
		return receiverAccId;
	}


	public void setReceiverAccId(String receiverAccId) {
		this.receiverAccId = receiverAccId;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Override
	public String toString() {
		return "AccountTrans [senderAccId=" + senderAccId + ", accAmount=" + accAmount + ", receiverAccId="
				+ receiverAccId + ", createTime=" + createTime + "]";
	}

}
