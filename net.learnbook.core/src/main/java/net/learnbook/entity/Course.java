package net.learnbook.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "COURSE")
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

	@Column
	@NotNull(message = "O campo hora não pode ficar vazio.")
	private float fHorCou;

	@Column
	@NotNull(message = "O campo dificuldade não pode ficar vazio.")
	private String sDifCou;

	@Column
	@NotNull(message = "O campo status não pode ficar vazio.")
	private String sStaCou;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_category_fk", nullable = false)
	private Category category;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private Set<Activity> activiy;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private Set<Certification> certification;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private Set<Slip> slip;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("users")
	@JoinTable(name = "COURSE_USER", joinColumns = @JoinColumn(name = "iCodUser"), inverseJoinColumns = @JoinColumn(name = "iCodCou"))
	private Set<User> users;

	public Course() {

	}

	public Course(Integer iCodCou, String sNamCou, String sDesCou, Date dDatCou, Date dExpTimCou, float fPriCou,
			float fHorCou, String sDifCou, String sStaCou, Category category, Set<Activity> activiy,
			Set<Certification> certification, Set<Slip> slip, Set<User> users) {
		super();
		this.iCodCou = iCodCou;
		this.sNamCou = sNamCou;
		this.sDesCou = sDesCou;
		this.dDatCou = dDatCou;
		this.dExpTimCou = dExpTimCou;
		this.fPriCou = fPriCou;
		this.fHorCou = fHorCou;
		this.sDifCou = sDifCou;
		this.sStaCou = sStaCou;
		this.category = category;
		this.activiy = activiy;
		this.certification = certification;
		this.slip = slip;
		this.users = users;
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

	public float getfHorCou() {
		return fHorCou;
	}

	public void setfHorCou(float fHorCou) {
		this.fHorCou = fHorCou;
	}

	public String getsDifCou() {
		return sDifCou;
	}

	public void setsDifCou(String sDifCou) {
		this.sDifCou = sDifCou;
	}

	public String getsStaCou() {
		return sStaCou;
	}

	public void setsStaCou(String sStaCou) {
		this.sStaCou = sStaCou;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Course [iCodCou=" + iCodCou + ", sNamCou=" + sNamCou + ", sDesCou=" + sDesCou + ", dDatCou=" + dDatCou
				+ ", dExpTimCou=" + dExpTimCou + ", fPriCou=" + fPriCou + ", fHorCou=" + fHorCou + ", sDifCou="
				+ sDifCou + ", sStaCou=" + sStaCou + ", category=" + category + ", activiy=" + activiy
				+ ", certification=" + certification + ", slip=" + slip + ", users=" + users + "]";
	}

}
