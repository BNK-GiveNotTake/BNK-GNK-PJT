package com.service.gnt.domain.users;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.event.Quiz;

public class Users {
	
	private int userId;
	private Account account;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String address;
	private int totalDonation;
	private Quiz quiz;
	private char isQuizParticipate; // BOOLEAN
	
	public Users() {}

	public Users(int userId, Account account, String userName, String userEmail, String userPassword, String address,
			int totalDonation, Quiz quiz, char isQuizParticipate) {
		super();
		this.userId = userId;
		this.account = account;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.address = address;
		this.totalDonation = totalDonation;
		this.quiz = quiz;
		this.isQuizParticipate = isQuizParticipate;
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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", account=" + account + ", userName=" + userName + ", userEmail="
				+ userEmail + ", userPassword=" + userPassword + ", address=" + address + ", totalDonation="
				+ totalDonation + ", quiz=" + quiz + ", isQuizParticipate=" + isQuizParticipate + "]";
	}
	
	

}
