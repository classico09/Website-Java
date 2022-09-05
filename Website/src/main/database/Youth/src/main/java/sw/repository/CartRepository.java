package sw.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sw.entity.Cart;
import sw.ultis.HibernateUtils;

public class CartRepository {
	private static final String String = null;
	private HibernateUtils hibernateUtils;

	public CartRepository() {
		super();
		hibernateUtils = HibernateUtils.getInstance();
	}

// 6. Cart-Insert ==> OK

	public Cart InsertCart(Cart cart) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(cart);

			session.getTransaction().commit();
			System.out.println(cart.toString());

			return cart;

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

// 7. Cart-Select by Account ID   ==> làm lại, phải trả về list
	public Cart getCartByAccountID(Cart cart1) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			String hql = "FROM Cart WHERE AccountID = :idParameter";
			Query<Cart> query = session.createQuery(hql, Cart.class);

			query.setParameter("idParameter", cart1);

			Cart cart11 = query.uniqueResult();
			System.out.println(cart11.toString());

			return cart11;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

// 8. Cart-Delete by ID ==> OK
	public Cart deleteCartByID(Cart cart2) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			String hql = "DELETE FROM Cart WHERE CartID = :idParameter";
			Query query = session.createQuery(hql);

			query.setParameter("idParameter", cart2);
			int affectedRows = query.executeUpdate();

			System.out.println(cart2.toString());

			return cart2;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
