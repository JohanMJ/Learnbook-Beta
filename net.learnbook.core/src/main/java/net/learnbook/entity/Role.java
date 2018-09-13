package net.learnbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer iCodRol;
	
	@Column
	@NotNull(message="O campo nome não pode estar vazio.")
	private String sNamRol;

	public Role() {

	}

	public Role(Integer iCodRol, String sNamRol) {
		super();
		this.iCodRol = iCodRol;
		this.sNamRol = sNamRol;
	}

	public Integer getiCodRol() {
		return iCodRol;
	}

	public void setiCodRol(Integer iCodRol) {
		this.iCodRol = iCodRol;
	}

	public String getsNamRol() {
		return sNamRol;
	}

	public void setsNamRol(String sNamRol) {
		this.sNamRol = sNamRol;
	}

	@Override
	public String toString() {
		return "Role [iCodRol=" + iCodRol + ", sNamRol=" + sNamRol + "]";
	}

}