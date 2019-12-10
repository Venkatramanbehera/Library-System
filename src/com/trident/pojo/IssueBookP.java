package com.trident.pojo;

import java.sql.Date;

public class IssueBookP {
	private String callNo;
	private String studentId;
	private String studentName;
	private String studentMobile;
	private String returnStatus;
	private Date issuedDate;
	public IssueBookP() {
		// TODO Auto-generated constructor stub
	}
	
	public IssueBookP(String callNo, String studentId, String studentName, String studentMobile) {
		super();
		this.callNo = callNo;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMobile = studentMobile;
	}

	public String getCallNo() {
		return callNo;
	}
	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	
}
