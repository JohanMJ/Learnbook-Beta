package net.learnbook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "certification")
public class Certification {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iCodCer;

	@Column
	@NotNull(message = "O campo nome não pode ser vazio.")
	private String sNamCer;

	@Column
	@NotNull(message = "O campo descrição não pode ser vazio.")
	private String sDesCer;

	@Column
	@NotNull(message = "O campo data não pode ser vazio.")
	private Date sDatCer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "certification_user_fk", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "certification_course_fk", nullable = false)
	private Course course;

	public Certification() {
		super();
	}

	public Certification(Integer iCodCer, String sNamCer, String sDesCer, Date sDatCer, User user, Course course) {
		super();
		this.iCodCer = iCodCer;
		this.sNamCer = sNamCer;
		this.sDesCer = sDesCer;
		this.sDatCer = sDatCer;
		this.user = user;
		this.course = course;
	}

	public Integer getiCodCer() {
		return iCodCer;
	}

	public void setiCodCer(Integer iCodCer) {
		this.iCodCer = iCodCer;
	}

	public String getsNamCer() {
		return sNamCer;
	}

	public void setsNamCer(String sNamCer) {
		this.sNamCer = sNamCer;
	}

	public String getsDesCer() {
		return sDesCer;
	}

	public void setsDesCer(String sDesCer) {
		this.sDesCer = sDesCer;
	}

	public Date getsDatCer() {
		return sDatCer;
	}

	public void setsDatCer(Date sDatCer) {
		this.sDatCer = sDatCer;
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
		return "Certification [iCodCer=" + iCodCer + ", sNamCer=" + sNamCer + ", sDesCer=" + sDesCer + ", sDatCer="
				+ sDatCer + ", user=" + user + ", course=" + course + "]";
	}

}
