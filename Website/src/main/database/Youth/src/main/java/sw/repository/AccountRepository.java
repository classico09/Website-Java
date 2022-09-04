package sw.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sw.entity.Account;
import sw.ultis.HibernateUtils;

public class AccountRepository {
	private static final String String = null;
	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		super();
		hibernateUtils = HibernateUtils.getInstance();
	}

// 1. Account-Đăng ký{createAccount} ==> OK

	public Account createAccount(Account account) {
		Session session = null;

		// String nameInput = fullname;
		// String mailInput = mail;
		// String passInput = pass;

		// Account account = new Account(mailInput, fullname, pass);
//		System.out.println("Email");
		// account.setEmail();
//
//		System.out.println("FullName");
		// account.setFullName(nameInput);
//
//		System.out.println("Password");
		// account.setPassword(passInput);

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(account);
			// session.save(mailInput);
			// session.save(passInput);

			session.getTransaction().commit();
			System.out.println("Create thành công");

			return account;

		} finally {
			if (session != null) {

				session.close();

			}
		}

	}

// 2. Account-Đăng nhập{check login} ==> OK

	public Account checkLogin(String mail, String pass) {
		Session session = null;
// tại sao lấy hk dc.  truyền tham số vào lại bị lỗi (fix cứng dữ liệu sao hk dc. truyền bị sai? hay hk hibernate chịu kiểu truyền ntn?)
		// String mailInput = "linh1@gmail.com";
		// String passInput = "A123456";

//	public Account checkLogin(String email, String pass) {
		String mailInput = mail;
		String passInput = pass;

		// System.out.println("Email");
		// String mailInput = ScannerUltis.inputEmail();

		// System.out.println("Password");
		// String passInput = ScannerUltis.inputPassword();

		try {
			session = hibernateUtils.openSession();
			String hqlSelect = "FROM Account WHERE email= :emailParan AND password= :passParan";

			Query<Account> querrySelect = session.createQuery(hqlSelect);
			System.out.println("chay toi day");
			System.out.println(querrySelect);
			querrySelect.setParameter("emailParan", mailInput);
			querrySelect.setParameter("passParan", passInput);
			System.out.println(querrySelect);

			Account account = querrySelect.uniqueResult();

			System.out.println("login thành công");
			return account;

		} finally {
			session.close();
		}
	}

}
