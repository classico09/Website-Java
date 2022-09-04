package sw.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sw.entity.Product;
import sw.ultis.HibernateUtils;
import sw.ultis.ScannerUltis;

public class ProductRepository {
	private static final String String = null;
	private HibernateUtils hibernateUtils;

	public ProductRepository() {
		super();
		hibernateUtils = HibernateUtils.getInstance();
	}

// 3. Product-Insert ==> OK

	public Product insertProduct() {
		Session session = null;
		Product product = new Product();
		System.out.println("Product Name");
		product.setName(ScannerUltis.inuputString());

		System.out.println("Price");
		product.setPrice(ScannerUltis.InuputDouble());

		System.out.println("Image");
		product.setImage(ScannerUltis.inuputString());

		System.out.println("Detail");
		product.setDetail(ScannerUltis.inuputString());

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

// 4. Product-Select All > chưa chạy được 

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

// 5. Product-Delete by ID > bỏ tham số truyền vào ntn?

	public Product deleteProductByID(int intInput) {
		Session session = null;

		System.out.println("Nhập vào ID Product cần xóa");
		int idFind = ScannerUltis.InuputIntPositive();

		session.beginTransaction();
		try {
			Product product = session.load(Product.class, idFind);

			session.delete(product);
			session.getTransaction().commit();

			return product;
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

}
