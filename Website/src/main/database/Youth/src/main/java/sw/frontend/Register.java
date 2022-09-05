package sw.frontend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import sw.entity.Account;
import sw.repository.AccountRepository;
import sw.ultis.ScannerUltis;


@WebServlet("/registration")
public class Register extends HttpServlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountRepository accountRepository = new AccountRepository();
		
		String mailInput = "duy2@gmail.com";
		String passInput = "A1234567";
		String nameInput = "duy2";
		String mobileInput = "01011112222";
		Account account = new Account();

		account.setEmail(mailInput);
		account.setFullName(nameInput);
		account.setPassword(passInput);
		account.setMobile(mobileInput);

		accountRepository.createAccount(account);
	}

}
