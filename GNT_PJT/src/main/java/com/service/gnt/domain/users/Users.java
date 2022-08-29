package com.service.gnt.domain.users;

import java.sql.Date;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.event.Quiz;

public class Users {
	
	private int userId;
	private Account account;
	private String userName;
	private String userEngName;
	private String userEmail;
	private String userPassword;
	private Date birthday;
	private String address;
	private String userPhone;
	private int totalDonation;
	private Quiz quiz;
	private char isQuizParticipate; // BOOLEAN
	
	public Users() {}

	public Users(int userId, String userName, String userEmail, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public Users(int userId, Account account, String userName, String userEngName, String userEmail,
			String userPassword, Date birthday, String address, String userPhone, int totalDonation, Quiz quiz,
			char isQuizParticipate) {
		super();
		this.userId = userId;
		this.account = account;
		this.userName = userName;
		this.userEngName = userEngName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.birthday = birthday;
		this.address = address;
		this.userPhone = userPhone;
		this.totalDonation = totalDonation;
		this.quiz = quiz;
		this.isQuizParticipate = isQuizParticipate;
	}
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalDonation() {
		return totalDonation;
	}

	public void setTotalDonation(int totalDonation) {
		this.totalDonation = totalDonation;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public char getIsQuizParticipate() {
		return isQuizParticipate;
	}

	public void setIsQuizParticipate(char isQuizParticipate) {
		this.isQuizParticipate = isQuizParticipate;
	}
	public String getUserEngName() {
		return userEngName;
	}

	public void setUserEngName(String userEngName) {
		this.userEngName = userEngName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", account=" + account + ", userName=" + userName + ", userEngName="
				+ userEngName + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", birthday=" + birthday
				+ ", address=" + address + ", totalDonation=" + totalDonation + ", quiz=" + quiz
				+ ", isQuizParticipate=" + isQuizParticipate + "]";
	}
}
