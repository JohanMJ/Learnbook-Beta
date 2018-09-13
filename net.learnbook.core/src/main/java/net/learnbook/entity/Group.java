package net.learnbook.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "package")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer iCodGru;

	@Column
	@NotNull(message = "O campo nome não pode estar vazio.")
	private String sNamGru;

	@Column
	@NotNull(message = "O campo nome não pode estar vazio.")
	private float fPriGru;

	@OneToMany(mappedBy = "group")
	private Set<Course> courses;

	public Group() {
		super();
	}

	public Group(Integer iCodGru, String sNamGru, float fPriGru, Set<Course> courses) {
		super();
		this.iCodGru = iCodGru;
		this.sNamGru = sNamGru;
		this.fPriGru = fPriGru;
		this.courses = courses;
	}

	public Integer getiCodGru() {
		return iCodGru;
	}

	public void setiCodGru(Integer iCodGru) {
		this.iCodGru = iCodGru;
	}

	public String getsNamGru() {
		return sNamGru;
	}

	public void setsNamGru(String sNamGru) {
		this.sNamGru = sNamGru;
	}

	public float getfPriGru() {
		return fPriGru;
	}

	public void setfPriGru(float fPriGru) {
		this.fPriGru = fPriGru;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Group [iCodGru=" + iCodGru + ", sNamGru=" + sNamGru + ", fPriGru=" + fPriGru + ", courses=" + courses
				+ "]";
	}

}
