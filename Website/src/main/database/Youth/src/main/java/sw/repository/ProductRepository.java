package sw.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sw.entity.Product;
import sw.ultis.HibernateUtils;

public class ProductRepository {
	private static final String String = null;
	private HibernateUtils hibernateUtils;

	public ProductRepository() {
		super();
		hibernateUtils = HibernateUtils.getInstance();
	}

// 3. Product-Insert ==> OK

	public Product insertProduct(Product product) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(product);

			session.getTransaction().commit();

			System.out.println(product.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();
		}
		return product;
	}

// 4. Product-Select All > OK

	public List<Product> ShowAllProduct() {
		Session session = null;
		List<Product> products = new ArrayList<Product>();
		try {
			session = hibernateUtils.openSession();
			@SuppressWarnings("unchecked")
			Query<Product> query = session.createQuery("FROM Product ORDER BY ProductID");
			products = query.list();

			for (Product product2 : products) {
				System.out.println(product2.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();
		}
		return products;

	}

// 5. Product-Delete by ID ==> OK

	public int deleteProductByID(int intInput) {
		Session session = null;
		int checkDeleteProduct = 0;
		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			String hql = "DELETE FROM Product WHERE ProductID = :idParameter";
			Query query = session.createQuery(hql);

			query.setParameter("idParameter", intInput);
			checkDeleteProduct = query.executeUpdate();
			if (checkDeleteProduct == 1) {
				System.out.println("Delete success Product by id = " + intInput);
			} else {
				System.out.println("Can not find cart by id = " + intInput);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();
		}
		return intInput;
	}
}
