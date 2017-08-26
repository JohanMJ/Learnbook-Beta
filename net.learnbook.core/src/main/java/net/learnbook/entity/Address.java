package net.learnbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer iCodAdd;

	@Column
	@NotNull(message = "O campo cidade é obrigatório")
	@NotEmpty(message = "O campo cidade é obrigatório")
	private String sCitAdd;

	@Column
	@NotNull(message = "O campo estado é obrigatório")
	@NotEmpty(message = "O campo estado é obrigatório")
	private String sStaAdd;

	@Column
	@NotNull(message = "O campo país é obrigatório")
	@NotEmpty(message = "O campo país é obrigatório")
	private String sStrAdd;

	@Column
	@NotNull(message = "O campo bairro é obrigatório")
	@NotEmpty(message = "O campo bairro é obrigatório")
	private String sNeiAdd;

	@Column
	private String sComAdd;

	@Column(unique = true)
	@NotNull(message = "O campo CEP é obrigatório")
	@NotEmpty(message = "O campo CEP é obrigatório")
	private String sCepAdd;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_user_fk")
	private User user;

	public Address() {
		super();
	}

	public Address(Integer iCodAdd, String sCitAdd, String sStaAdd, String sStrAdd, String sNeiAdd, String sComAdd,
			String sCepAdd, User user) {
		super();
		this.iCodAdd = iCodAdd;
		this.sCitAdd = sCitAdd;
		this.sStaAdd = sStaAdd;
		this.sStrAdd = sStrAdd;
		this.sNeiAdd = sNeiAdd;
		this.sComAdd = sComAdd;
		this.sCepAdd = sCepAdd;
		this.user = user;
	}

	public Integer getiCodAdd() {
		return iCodAdd;
	}

	public void setiCodAdd(Integer iCodAdd) {
		this.iCodAdd = iCodAdd;
	}

	public String getsCitAdd() {
		return sCitAdd;
	}

	public void setsCitAdd(String sCitAdd) {
		this.sCitAdd = sCitAdd;
	}

	public String getsStaAdd() {
		return sStaAdd;
	}

	public void setsStaAdd(String sStaAdd) {
		this.sStaAdd = sStaAdd;
	}

	public String getsStrAdd() {
		return sStrAdd;
	}

	public void setsStrAdd(String sStrAdd) {
		this.sStrAdd = sStrAdd;
	}

	public String getsNeiAdd() {
		return sNeiAdd;
	}

	public void setsNeiAdd(String sNeiAdd) {
		this.sNeiAdd = sNeiAdd;
	}

	public String getsComAdd() {
		return sComAdd;
	}

	public void setsComAdd(String sComAdd) {
		this.sComAdd = sComAdd;
	}

	public String getsCepAdd() {
		return sCepAdd;
	}

	public void setsCepAdd(String sCepAdd) {
		this.sCepAdd = sCepAdd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [iCodAdd=" + iCodAdd + ", sCitAdd=" + sCitAdd + ", sStaAdd=" + sStaAdd + ", sStrAdd=" + sStrAdd
				+ ", sNeiAdd=" + sNeiAdd + ", sComAdd=" + sComAdd + ", sCepAdd=" + sCepAdd + ", user=" + user + "]";
	}

}