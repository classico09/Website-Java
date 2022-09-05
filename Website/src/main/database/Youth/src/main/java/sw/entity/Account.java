package sw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account", catalog = "YouthDataHibernate")
public class Account implements Serializable {
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Email", length = 100, nullable = false, unique = true)
	private String email;

	@Column(name = "FullName", length = 100, nullable = false)
	private String fullName;

	@Column(name = "Password", length = 100)
	private String password;

	@Column(name = "Mobile", length = 11)
	private String mobile;

//	@OneToOne(mappedBy = "account")
//	private Cart cart;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String email, String fullName, String password) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", fullName=" + fullName + ", password=" + password
				+ ", mobile=" + mobile + "]";
	}

}
