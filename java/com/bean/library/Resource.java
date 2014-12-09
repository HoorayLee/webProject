package com.bean.library;

import java.io.Serializable;
import java.sql.Timestamp;

public class Resource implements Serializable{
	private int iFileID;
	private String sFileName;
	private String sAuthorID;
	private Timestamp dUploadTime;
	private int iDownloadNum;
	private long lSize;
	private int iPraise;
	private int iCriticize;
	private String sInstitute;
	private int iGrade;
	private String sCourseName;
	private String sDescription;
	public int getiFileID() {
		return iFileID;
	}
	public void setiFileID(int iFileID) {
		this.iFileID = iFileID;
	}
	public String getsFileName() {
		return sFileName;
	}
	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}
	public String getsAuthorID() {
		return sAuthorID;
	}
	public void setsAuthorID(String sAuthorID) {
		this.sAuthorID = sAuthorID;
	}
	public Timestamp getdUploadTime() {
		return dUploadTime;
	}
	public void setdUploadTime(Timestamp dUploadTime) {
		this.dUploadTime = dUploadTime;
	}
	public int getiDownloadNum() {
		return iDownloadNum;
	}
	public void setiDownloadNum(int iDownloadNum) {
		this.iDownloadNum = iDownloadNum;
	}
	public long getlSize() {
		return lSize;
	}
	public void setlSize(long lSize) {
		this.lSize = lSize;
	}
	public int getiPraise() {
		return iPraise;
	}
	public void setiPraise(int iPraise) {
		this.iPraise = iPraise;
	}
	public int getiCriticize() {
		return iCriticize;
	}
	public void setiCriticize(int iCriticize) {
		this.iCriticize = iCriticize;
	}
	public String getsInstitute() {
		return sInstitute;
	}
	public void setsInstitute(String sInstitute) {
		this.sInstitute = sInstitute;
	}
	public int getiGrade() {
		return iGrade;
	}
	public void setiGrade(int iGrade) {
		this.iGrade = iGrade;
	}
	public String getsCourseName() {
		return sCourseName;
	}
	public void setsCourseName(String sCourseName) {
		this.sCourseName = sCourseName;
	}
	public String getsDescription() {
		return sDescription;
	}
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
	
}


