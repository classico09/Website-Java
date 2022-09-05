package sw.repository;

import java.util.ArrayList;
import java.util.List;

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

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();
		}
		return cart;
	}

// 7. Cart-Select by Account ID   ==> OK
	public List<Cart> getCartByAccountID(int accountId) {
		Session session = null;
		List<Cart> carts = new ArrayList<Cart>();

		try {

			// get session
			session = hibernateUtils.openSession();

			String hql = "FROM Cart WHERE AccountID = :idParameter";
			Query<Cart> query = session.createQuery(hql, Cart.class);

			query.setParameter("idParameter", accountId);

			carts = query.list();
			for (Cart cart : carts) {

				System.out.println(cart.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();
		}
		return carts;
	}

// 8. Cart-Delete by ID ==> OK
	public int deleteCartByID(int idDelete) {
		Session session = null;

		int checkDeleteCart = 0;
		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			String hql = "DELETE FROM Cart WHERE CartID = :idParameter";
			Query query = session.createQuery(hql);

			query.setParameter("idParameter", idDelete);
			checkDeleteCart = query.executeUpdate();

			if (checkDeleteCart == 1) {
				System.out.println("Delete success cart by id = " + idDelete);
			} else {
				System.out.println("Can not find cart by id = " + idDelete);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();
		}
		return checkDeleteCart;

	}
}
