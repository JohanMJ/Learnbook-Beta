package net.learnbook.entity;

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
@Table(name = "acitvity")
public class Activity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iCodAct;

	@Column(nullable = false)
	@NotNull(message = "O campo nome não pode ficar vazio")
	private String sNamAct;

	@Column(nullable = false)
	@NotNull(message = "O campo descrição não pode ficar vazio")
	private String sDesAct;

	@Column
	private String sCodVidAct;

	@Column
	private String sPatPDFAct;

	@ManyToOne
	@JoinColumn(name = "activity_course_fk")
	private Course course;

	public Activity() {
		super();
	}

	public Activity(Integer iCodAct, String sNamAct, String sDesAct, String sCodVidAct, String sPatPDFAct,
			Course course) {
		super();
		this.iCodAct = iCodAct;
		this.sNamAct = sNamAct;
		this.sDesAct = sDesAct;
		this.sCodVidAct = sCodVidAct;
		this.sPatPDFAct = sPatPDFAct;
		this.course = course;
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

	public String getsCodVidAct() {
		return sCodVidAct;
	}

	public void setsCodVidAct(String sCodVidAct) {
		this.sCodVidAct = sCodVidAct;
	}

	public String getsPatPDFAct() {
		return sPatPDFAct;
	}

	public void setsPatPDFAct(String sPatPDFAct) {
		this.sPatPDFAct = sPatPDFAct;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Activity [iCodAct=" + iCodAct + ", sNamAct=" + sNamAct + ", sDesAct=" + sDesAct + ", sCodVidAct="
				+ sCodVidAct + ", sPatPDFAct=" + sPatPDFAct + ", course=" + course + "]";
	}

}
