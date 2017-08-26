package net.learnbook.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "beneficary")
public class Beneficiary {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iCodBen;

	@Column
	@NotNull(message = "O campo nome não pode ser vazio.")
	private String sNamBen;
	@Column
	@NotNull(message = "O campo código do banco não pode ser vazio.")
	private Integer iBanCodBen;
	@Column
	@NotNull(message = "O campo digito bancário não pode ser vazio.")
	private Integer iBanDigBen;
	@Column
	@NotNull(message = "O campo número da agência não pode ser vazio.")
	private Integer iAgrNum;
	@Column
	@NotNull(message = "O campo carteira do banco não pode ser vazio.")
	private Integer iBankWa;
	@Column
	@NotNull(message = "O campo CEP não pode ser vazio.")
	private String sCepBen;
	@Column
	@NotNull(message = "O campo número de registro não pode ser vazio.")
	private String sBusRegBen;

	@OneToOne(mappedBy ="beneficiary", fetch = FetchType.EAGER)
	@Valid
	private Address address;

	@OneToMany(mappedBy="beneficiary")
	private Set<Slip> slip;

	public Beneficiary() {
		super();
	}

	public Beneficiary(Integer iCodBen, String sNamBen, Integer iBanCodBen, Integer iBanDigBen, Integer iAgrNum,
			Integer iBankWa, String sCepBen, String sBusRegBen, Address address, Set<Slip> slip) {
		super();
		this.iCodBen = iCodBen;
		this.sNamBen = sNamBen;
		this.iBanCodBen = iBanCodBen;
		this.iBanDigBen = iBanDigBen;
		this.iAgrNum = iAgrNum;
		this.iBankWa = iBankWa;
		this.sCepBen = sCepBen;
		this.sBusRegBen = sBusRegBen;
		this.address = address;
		this.slip = slip;
	}

	public Integer getiCodBen() {
		return iCodBen;
	}

	public void setiCodBen(Integer iCodBen) {
		this.iCodBen = iCodBen;
	}

	public String getsNamBen() {
		return sNamBen;
	}

	public void setsNamBen(String sNamBen) {
		this.sNamBen = sNamBen;
	}

	public Integer getiBanCodBen() {
		return iBanCodBen;
	}

	public void setiBanCodBen(Integer iBanCodBen) {
		this.iBanCodBen = iBanCodBen;
	}

	public Integer getiBanDigBen() {
		return iBanDigBen;
	}

	public void setiBanDigBen(Integer iBanDigBen) {
		this.iBanDigBen = iBanDigBen;
	}

	public Integer getiAgrNum() {
		return iAgrNum;
	}

	public void setiAgrNum(Integer iAgrNum) {
		this.iAgrNum = iAgrNum;
	}

	public Integer getiBankWa() {
		return iBankWa;
	}

	public void setiBankWa(Integer iBankWa) {
		this.iBankWa = iBankWa;
	}

	public String getsCepBen() {
		return sCepBen;
	}

	public void setsCepBen(String sCepBen) {
		this.sCepBen = sCepBen;
	}

	public String getsBusRegBen() {
		return sBusRegBen;
	}

	public void setsBusRegBen(String sBusRegBen) {
		this.sBusRegBen = sBusRegBen;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Slip> getSlip() {
		return slip;
	}

	public void setSlip(Set<Slip> slip) {
		this.slip = slip;
	}

	@Override
	public String toString() {
		return "Beneficiary [iCodBen=" + iCodBen + ", sNamBen=" + sNamBen + ", iBanCodBen=" + iBanCodBen
				+ ", iBanDigBen=" + iBanDigBen + ", iAgrNum=" + iAgrNum + ", iBankWa=" + iBankWa + ", sCepBen="
				+ sCepBen + ", sBusRegBen=" + sBusRegBen + ", address=" + address + ", slip=" + slip + "]";
	}

}
