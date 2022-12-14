package sw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart", catalog = "YouthDataHibernate")
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CartID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Name", length = 100, nullable = false, unique = true)
	private String name;

	@Column(name = "Price")
	private double price;

	@Column(name = "Image", length = 500)
	private String image;

	@Column(name = "Detail", length = 500)
	private String detail;

	@Column(name = "AccountID")
	private int accountID;

//	@OneToOne
//	@JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
//	private Account account;

//	@OneToMany(mappedBy = "cart")
//	private List<Product> products;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String name, double price, String image, String detail, int accountID) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.detail = detail;
		this.accountID = accountID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", detail=" + detail
				+ ", accountID=" + accountID + "]";
	}

}