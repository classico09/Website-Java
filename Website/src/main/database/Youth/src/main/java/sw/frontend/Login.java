package sw.frontend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import sw.entity.Account;
import sw.repository.AccountRepository;
import sw.ultis.ScannerUltis;

@WebServlet("/loginpage")
public class Login extends HttpServlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountRepository accountRepository = new AccountRepository();
		//accountRepository.checkLogin(mail, pass);// truyền email với pass vào

	}

}
