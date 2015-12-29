package com.mvc.bean;

public class User {
	private Account account;// 账号
	private String userName; // 姓名
	private int userAge;
	private String userSex; // 性别
	/**
	 * @return the userAge
	 */
	public int getUserAge() {
		return userAge;
	}

	/**
	 * @param userAge the userAge to set
	 */
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}



	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userSex
	 */
	public String getUserSex() {
		return userSex;
	}

	/**
	 * @param userSex
	 *            the userSex to set
	 */
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @description java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String info = "\n姓名："+this.getUserName()+
				"\n性别："+this.getUserSex()+
				"\n年龄："+this.getUserAge()+
				"\n账号ID："+this.getAccount().getId()+
				"\n账号密码："+this.getAccount().getPassword()+
				"\n权限："+this.getAccount().getPower();
		return info;
	}

}
