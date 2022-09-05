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
			System.out.println("Create success account!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();
		}
		return account;
	}

// 2. Account-Đăng nhập{check login} ==> OK

	public Account checkLogin(Account account2) {
		Session session = null;

		Account account = new Account();
		try {
			session = hibernateUtils.openSession();
			String hql = "FROM Account WHERE email= :emailParan AND password= :passParan";

			Query<Account> querrySelect = session.createQuery(hql);

			querrySelect.setParameter("emailParan", account2.getEmail());
			querrySelect.setParameter("passParan", account2.getPassword());

			account = querrySelect.uniqueResult(); // hung ket qua sau khi tim duoi db

			System.out.println("Login success, welcome " + account.getFullName());

		} catch (Exception e) {
			e.printStackTrace();

		}
		if (session != null) {
			session.close();
		}
		return account;
	}
}
