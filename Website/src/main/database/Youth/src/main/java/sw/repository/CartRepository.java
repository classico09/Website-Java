package sw.repository;

import org.hibernate.Session;

import sw.entity.Account;
import sw.entity.Cart;
import sw.ultis.HibernateUtils;
import sw.ultis.ScannerUltis;

public class CartRepository {
	private static final String String = null;
	private HibernateUtils hibernateUtils;

	public CartRepository() {
		super();
		hibernateUtils = HibernateUtils.getInstance();
	}
// 6. Cart-Insert

	public void InsertCart() {
		Session session = null;
		Cart cart = new Cart();

		System.out.println("Name");
		cart.setName(ScannerUltis.inuputString());

		System.out.println("Image");
		cart.setImage(ScannerUltis.inuputString());

		System.out.println("Detail");
		cart.setDetail(ScannerUltis.inuputString());

		System.out.println("AccountID");
		cart.setAccount(new Account());

		System.out.println("ProductID");
//		cart.setProduct(new Product());

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(cart);

			session.getTransaction().commit();
			System.out.println(cart.toString());
			// return cart;

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

// 7. Cart-Select by Account ID

// 8. Cart-Delete by ID
	public void deleteCartByID(int intInput) {

	}
}
