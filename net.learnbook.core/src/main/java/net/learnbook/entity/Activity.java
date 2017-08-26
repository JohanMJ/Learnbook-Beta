package net.learnbook.entity;

import java.util.Date;

public class Activity {

	private Integer iCodAct;
	private String sNamAct;
	private String sDesAct;
	private Date dDatAct;
	private Date dExpTime;

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activity(Integer iCodAct, String sNamAct, String sDesAct, Date dDatAct, Date dExpTime) {
		super();
		this.iCodAct = iCodAct;
		this.sNamAct = sNamAct;
		this.sDesAct = sDesAct;
		this.dDatAct = dDatAct;
		this.dExpTime = dExpTime;
	}

	public Integer getiCodAct() {
		return iCodAct;
	}

	public void setiCodAct(Integer iCodAct) {
		this.iCodAct = iCodAct;
	}

	public String getsNamAct() {
		return sNamAct;
	}

	public void setsNamAct(String sNamAct) {
		this.sNamAct = sNamAct;
	}

	public String getsDesAct() {
		return sDesAct;
	}

	public void setsDesAct(String sDesAct) {
		this.sDesAct = sDesAct;
	}

	public Date getdDatAct() {
		return dDatAct;
	}

	public void setdDatAct(Date dDatAct) {
		this.dDatAct = dDatAct;
	}

	public Date getdExpTime() {
		return dExpTime;
	}

	public void setdExpTime(Date dExpTime) {
		this.dExpTime = dExpTime;
	}

	@Override
	public String toString() {
		return "Activity [iCodAct=" + iCodAct + ", sNamAct=" + sNamAct + ", sDesAct=" + sDesAct + ", dDatAct=" + dDatAct
				+ ", dExpTime=" + dExpTime + "]";
	}

}
