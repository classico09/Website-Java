package sw.repository;

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

			return product;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

// 4. Product-Select All > OK

	public List<Product> ShowAllProduct() {
		Session session = null;
		Product product = new Product();
		try {
			session = hibernateUtils.openSession();
			@SuppressWarnings("unchecked")
			Query<Product> query = session.createQuery("FROM Product ORDER BY ProductID");
			List<Product> products = query.list();

			for (Product product2 : products) {
				System.out.println(product2.toString());
			}

			return products;

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

// 5. Product-Delete by ID ==> OK

	public Product deleteProductByID(Product product1) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			String hql = "DELETE FROM Product WHERE ProductID = :idParameter";
			Query query = session.createQuery(hql);

			query.setParameter("idParameter", product1);
			int affectedRows = query.executeUpdate();

			System.out.println(product1.toString());

			return product1;

		} finally {
			if (session != null) {
				session.close();

			}

		}
	}
}
