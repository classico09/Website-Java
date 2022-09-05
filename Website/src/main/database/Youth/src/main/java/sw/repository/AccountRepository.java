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

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(account);

			session.getTransaction().commit();
			System.out.println("Create thành công");

		} catch (Exception e) {
			if (session != null) {

				session.close();
			}
		}
		return account;
	}

// 2. Account-Đăng nhập{check login} ==> OK

	public Account checkLogin(String mail, String pass) {
		Session session = null;

		String mailInput = mail;
		String passInput = pass;

		try {
			session = hibernateUtils.openSession();
			String hqlSelect = "FROM Account WHERE email= :emailParan AND password= :passParan";

			Query<Account> querrySelect = session.createQuery(hqlSelect);

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
