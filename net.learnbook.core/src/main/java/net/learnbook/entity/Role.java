package net.learnbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer iCodRol;
	@Column
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