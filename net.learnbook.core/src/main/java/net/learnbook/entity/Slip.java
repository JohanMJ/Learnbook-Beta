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
@Table(name="slip")
public class Slip {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iCodSli;
	
	@Column
	@NotNull(message="O campo número da requisição não pode estar vazio.")
	private Integer iReqNumSli;
	
	@Column
	@NotNull(message="O campo observação não pode estar vazio.")
	private String sObsSli;
	
	@Column
	@NotNull(message="O campo número do boleto não pode estar vazio.")
	private float fNumSli;
	
	@Column
	@NotNull(message="O campo data não pode estar vazio.")
	private Date dDatSli;
	
	@Column
	@NotNull(message="O campo data de expiração não pode estar vazio.")
	private Date dExpDatSli;
	
	@ManyToOne
	@JoinColumn(name="slip_beneficiary_fk", nullable=false)
	private Beneficiary beneficiary;
	
	@ManyToOne
	@JoinColumn(name="slip_user_fk", nullable=false)
	private User user;

	@ManyToOne
	@JoinColumn(name="slip_course_fk", nullable=false)
	private Course course;

	public Slip() {
		super();
	}

	public Slip(Integer iCodSli, String sObsSli, Integer iReqNumSli, float fNumSli, Date dDatSli, Date dExpDatSli,
			Beneficiary beneficiary, User user, Course course) {
		super();
		this.iCodSli = iCodSli;
		this.sObsSli = sObsSli;
		this.iReqNumSli = iReqNumSli;
		this.fNumSli = fNumSli;
		this.dDatSli = dDatSli;
		this.dExpDatSli = dExpDatSli;
		this.beneficiary = beneficiary;
		this.user = user;
		this.course = course;
	}

	public Integer getiCodSli() {
		return iCodSli;
	}

	public void setiCodSli(Integer iCodSli) {
		this.iCodSli = iCodSli;
	}

	public String getsObsSli() {
		return sObsSli;
	}

	public void setsObsSli(String sObsSli) {
		this.sObsSli = sObsSli;
	}

	public Integer getiReqNumSli() {
		return iReqNumSli;
	}

	public void setiReqNumSli(Integer iReqNumSli) {
		this.iReqNumSli = iReqNumSli;
	}

	public float getfNumSli() {
		return fNumSli;
	}

	public void setfNumSli(float fNumSli) {
		this.fNumSli = fNumSli;
	}

	public Date getdDatSli() {
		return dDatSli;
	}

	public void setdDatSli(Date dDatSli) {
		this.dDatSli = dDatSli;
	}

	public Date getdExpDatSli() {
		return dExpDatSli;
	}

	public void setdExpDatSli(Date dExpDatSli) {
		this.dExpDatSli = dExpDatSli;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Slip [iCodSli=" + iCodSli + ", sObsSli=" + sObsSli + ", iReqNumSli=" + iReqNumSli + ", fNumSli="
				+ fNumSli + ", dDatSli=" + dDatSli + ", dExpDatSli=" + dExpDatSli + ", beneficiary=" + beneficiary
				+ ", user=" + user + ", course=" + course + "]";
	}

}
