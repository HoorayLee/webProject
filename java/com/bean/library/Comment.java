package com.bean.library;

import java.sql.Timestamp;

public class Comment {
	private int iFileID;
	private String sComment;
	private Timestamp CommentTime;
	
	public Timestamp getCommentTime() {
		return CommentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		CommentTime = commentTime;
	}
	public int getiFileID() {
		return iFileID;
	}
	public void setiFileID(int iFileID) {
		this.iFileID = iFileID;
	}
	public String getsComment() {
		return sComment;
	}
	public void setsComment(String sComment) {
		this.sComment = sComment;
	}

}
