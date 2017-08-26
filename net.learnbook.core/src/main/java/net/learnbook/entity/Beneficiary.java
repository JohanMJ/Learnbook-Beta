package net.learnbook.entity;

public class Beneficiary {

	private Integer iCodBen;
	private String sNamBen;
	private Integer iBanCodBen;
	private Integer iBanDigBen;
	private Integer iAgrNum;
	private Integer iBankWa;
	private String sCepBen;
	private String sBusRegBen;
	private Address address;

	public Beneficiary() {
	}

	public Beneficiary(Integer iCodBen, String sNamBen, Integer iBanCodBen, Integer iBanDigBen, Integer iAgrNum,
			Integer iBankWa, String sCepBen, String sBusRegBen, Address address) {
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

	@Override
	public String toString() {
		return "Beneficiary [iCodBen=" + iCodBen + ", sNamBen=" + sNamBen + ", iBanCodBen=" + iBanCodBen
				+ ", iBanDigBen=" + iBanDigBen + ", iAgrNum=" + iAgrNum + ", iBankWa=" + iBankWa + ", sCepBen="
				+ sCepBen + ", sBusRegBen=" + sBusRegBen + ", address=" + address + "]";
	}

}
