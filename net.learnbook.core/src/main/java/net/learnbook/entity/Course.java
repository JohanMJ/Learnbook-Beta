package net.learnbook.entity;

import java.util.Date;

public class Course {
	private Integer iCodCou;
	private String sNamCou;
	private String sDesCou;
	private Date dDatCou;
	private Date dExpTimCou;
	private float fPriCoud;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Integer iCodCou, String sNamCou, String sDesCou, Date dDatCou, Date dExpTimCou, float fPriCoud) {
		super();
		this.iCodCou = iCodCou;
		this.sNamCou = sNamCou;
		this.sDesCou = sDesCou;
		this.dDatCou = dDatCou;
		this.dExpTimCou = dExpTimCou;
		this.fPriCoud = fPriCoud;
	}

	public Integer getiCodCou() {
		return iCodCou;
	}

	public void setiCodCou(Integer iCodCou) {
		this.iCodCou = iCodCou;
	}

	public String getsNamCou() {
		return sNamCou;
	}

	public void setsNamCou(String sNamCou) {
		this.sNamCou = sNamCou;
	}

	public String getsDesCou() {
		return sDesCou;
	}

	public void setsDesCou(String sDesCou) {
		this.sDesCou = sDesCou;
	}

	public Date getdDatCou() {
		return dDatCou;
	}

	public void setdDatCou(Date dDatCou) {
		this.dDatCou = dDatCou;
	}

	public Date getdExpTimCou() {
		return dExpTimCou;
	}

	public void setdExpTimCou(Date dExpTimCou) {
		this.dExpTimCou = dExpTimCou;
	}

	public float getfPriCoud() {
		return fPriCoud;
	}

	public void setfPriCoud(float fPriCoud) {
		this.fPriCoud = fPriCoud;
	}

	@Override
	public String toString() {
		return "Course [iCodCou=" + iCodCou + ", sNamCou=" + sNamCou + ", sDesCou=" + sDesCou + ", dDatCou=" + dDatCou
				+ ", dExpTimCou=" + dExpTimCou + ", fPriCoud=" + fPriCoud + "]";
	}

}
