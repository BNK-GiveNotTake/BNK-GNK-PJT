package com.service.gnt.domain.account;

public class MileageHistory {

	private int mileagePk;
	private Account account;
	private String createTime; // date
	private int mileageAmount;
	
	public MileageHistory() {}

	public MileageHistory(int mileagePk, Account account, String createTime, int mileageAmount) {
		super();
		this.mileagePk = mileagePk;
		this.account = account;
		this.createTime = createTime;
		this.mileageAmount = mileageAmount;
	}

	public int getMileagePk() {
		return mileagePk;
	}

	public void setMileagePk(int mileagePk) {
		this.mileagePk = mileagePk;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getMileageAmount() {
		return mileageAmount;
	}

	public void setMileageAmount(int mileageAmount) {
		this.mileageAmount = mileageAmount;
	}

	@Override
	public String toString() {
		return "MileageHistory [mileagePk=" + mileagePk + ", account=" + account + ", createTime=" + createTime
				+ ", mileageAmount=" + mileageAmount + "]";
	}
	
	
	
}
