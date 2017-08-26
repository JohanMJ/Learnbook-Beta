package net.learnbook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="acitvity")
public class Activity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iCodAct;
	
	@Column(nullable = false)
	@NotNull(message="O campo nome não pode ficar vazio")
	private String sNamAct;
	
	@Column(nullable = false)
	@NotNull(message="O campo descrição não pode ficar vazio")
	private String sDesAct;
	
	@Column(nullable = false)
	@NotNull(message="O campo data não pode ficar vazio")
	private Date dDatAct;
	
	@Column(nullable = false)
	@NotNull(message="O campo data de expiração não pode ficar vazio")
	private Date dExpTime;
	
	@ManyToOne
	@JoinColumn(name="activity_course_fk")
	private Course course;

	public Activity() {
		super();
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
