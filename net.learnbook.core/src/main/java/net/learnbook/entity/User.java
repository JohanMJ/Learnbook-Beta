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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer iCodUser;

	@Column(nullable = false, length = 55)
	@NotNull(message = "O campo nome não pode ficar vazio")
	private String sNamUser;
	
	@Column(nullable = false, length = 55)
	@NotNull(message = "O campo tipo não pode ficar vazio")
	private String type;

	@Column(unique = true)
	@NotNull(message = "O campo e-mail não pode ficar vazio")
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "O campo e-mail deve conter um endereço válido")
	private String sLogUser;

	@Column(nullable = false, length = 255)
	@NotNull(message = "O campo nome não pode ficar vazio")
	@Size(min = 6, message = "Senha deve conter no mínimo 6 caracteres")
	private String sPasUser;

	@DateTimeFormat
	@Column
	private Date dBirUser;

	@Column(nullable = false)
	@NotNull(message = "Permissão deve ser selecionada")
	private boolean bStaUser;

	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
	@Valid
	private Address address;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private Set<Certification> certification;
	
	@Column
	private Integer companyId;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private Set<Group> group;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private Set<Slip> slip;

	@Column
	private Integer groupId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "iCodUser"), inverseJoinColumns = @JoinColumn(name = "iCodRol"))
	private Set<Role> roles;
	
/*	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "iCodUser"), inverseJoinColumns = @JoinColumn(name = "iCodCou"))
	private Set<Course> courses;*/

	public User() {
		super();
	}

	public User(Integer iCodUser, String sNamUser, String sLogUser, String sPasUser, Date dBirUser, boolean bStaUser,
			Address address, Set<Role> roles) {
		super();
		this.iCodUser = iCodUser;
		this.sNamUser = sNamUser;
		this.sLogUser = sLogUser;
		this.sPasUser = sPasUser;
		this.dBirUser = dBirUser;
		this.bStaUser = bStaUser;
		this.address = address;
		this.roles = roles;
	}

	public Integer getiCodUser() {
		return iCodUser;
	}

	public void setiCodUser(Integer iCodUser) {
		this.iCodUser = iCodUser;
	}
	

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getsNamUser() {
		return sNamUser;
	}

	public void setsNamUser(String sNamUser) {
		this.sNamUser = sNamUser;
	}

	public String getsLogUser() {
		return sLogUser;
	}

	public void setsLogUser(String sLogUser) {
		this.sLogUser = sLogUser;
	}

	public String getsPasUser() {
		return sPasUser;
	}

	public void setsPasUser(String sPasUser) {
		this.sPasUser = sPasUser;
	}

	public Date getdBirUser() {
		return dBirUser;
	}

	public void setdBirUser(Date dBirUser) {
		this.dBirUser = dBirUser;
	}

	public boolean isbStaUser() {
		return bStaUser;
	}

	public void setbStaUser(boolean bStaUser) {
		this.bStaUser = bStaUser;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "User [iCodUser=" + iCodUser + ", sNamUser=" + sNamUser + ", sLogUser=" + sLogUser + ", sPasUser="
				+ sPasUser + ", dBirUser=" + dBirUser + ", bStaUser=" + bStaUser + ", address=" + address + ", roles="
				+ roles + "]";
	}

}
