package net.learnbook.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iCodCou;

	@Column
	@NotNull(message = "O campo nome não pode ficar vazio.")
	private String sNamCou;

	@Column
	@NotNull(message = "O campo descrição não pode ficar vazio.")
	private String sDesCou;

	@Column
	@NotNull(message = "O campo data de início não pode ficar vazio.")
	private Date dDatCou;

	@Column
	@NotNull(message = "O campo data de expiração não pode ficar vazio.")
	private Date dExpTimCou;

	@Column
	@NotNull(message = "O campo preço não pode ficar vazio.")
	private float fPriCou;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private Set<Activity> activiy;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private Set<Certification> certification;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private Set<Slip> slip;

	public Course() {
		super();
	}

	public Course(Integer iCodCou, String sNamCou, String sDesCou, Date dDatCou, Date dExpTimCou, float fPriCou,
			Set<Activity> activiy, Set<Certification> certification, Set<Slip> slip) {
		super();
		this.iCodCou = iCodCou;
		this.sNamCou = sNamCou;
		this.sDesCou = sDesCou;
		this.dDatCou = dDatCou;
		this.dExpTimCou = dExpTimCou;
		this.fPriCou = fPriCou;
		this.activiy = activiy;
		this.certification = certification;
		this.slip = slip;
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

	public float getfPriCou() {
		return fPriCou;
	}

	public void setfPriCou(float fPriCou) {
		this.fPriCou = fPriCou;
	}

	public Set<Activity> getActiviy() {
		return activiy;
	}

	public void setActiviy(Set<Activity> activiy) {
		this.activiy = activiy;
	}

	public Set<Certification> getCertification() {
		return certification;
	}

	public void setCertification(Set<Certification> certification) {
		this.certification = certification;
	}

	public Set<Slip> getSlip() {
		return slip;
	}

	public void setSlip(Set<Slip> slip) {
		this.slip = slip;
	}

	@Override
	public String toString() {
		return "Course [iCodCou=" + iCodCou + ", sNamCou=" + sNamCou + ", sDesCou=" + sDesCou + ", dDatCou=" + dDatCou
				+ ", dExpTimCou=" + dExpTimCou + ", fPriCou=" + fPriCou + ", activiy=" + activiy + ", certification="
				+ certification + ", slip=" + slip + "]";
	}

}
