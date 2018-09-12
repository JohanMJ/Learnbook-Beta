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
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer iCodCat;

	@Column
	@NotNull(message = "O campo nome não pode estar vazio.")
	private String sNamCat;
	
	@OneToMany(mappedBy="category")
	private Set<Course> course;

	public Category() {
		super();
	}

	public Category(Integer iCodCat, String sNamCat) {
		super();
		this.iCodCat = iCodCat;
		this.sNamCat = sNamCat;
	}

	public Integer getiCodCat() {
		return iCodCat;
	}

	public void setiCodCat(Integer iCodCat) {
		this.iCodCat = iCodCat;
	}

	public String getsNamCat() {
		return sNamCat;
	}

	public void setsNamCat(String sNamCat) {
		this.sNamCat = sNamCat;
	}

	@Override
	public String toString() {
		return "Category [iCodCat=" + iCodCat + ", sNamCat=" + sNamCat + "]";
	}

}
