package com.bean.library;

public class User {
	private String sUserID;
	private String sNickName;
	private int iCredit;
	private int iFileNumber;
	private int iStatus;
	private int iUserType;
	
	public String getsUserID() {
		return sUserID;
	}
	public void setsUserID(String iUserID) {
		this.sUserID = iUserID;
	}
	public String getsNickName() {
		return sNickName;
	}
	public void setsNickName(String sNickName) {
		this.sNickName = sNickName;
	}
	public int getiCredit() {
		return iCredit;
	}
	public void setiCredit(int iCredit) {
		this.iCredit = iCredit;
	}
	public int getiFileNumber() {
		return iFileNumber;
	}
	public void setiFileNumber(int iFileNumber) {
		this.iFileNumber = iFileNumber;
	}
	public int getiStatus() {
		return iStatus;
	}
	public void setiStatus(int iStatus) {
		this.iStatus = iStatus;
	}
	public int getiUserType() {
		return iUserType;
	}
	public void setiUserType(int iUserType) {
		this.iUserType = iUserType;
	}
	
		
	}


