package sw.frontend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import sw.entity.Account;
import sw.repository.AccountRepository;
import sw.ultis.ScannerUltis;


@WebServlet("/register")
public class Register extends HttpServlet {

	private void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		PrintWriter pw = res.getWriter();
		
		res.setContentType("text/html");
		
		String email = req.getParameter("email");
		String name = req.getParameter("full_name");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		
		Accout acc = new Account();
		acc.setEmail(email); 
		acc.setFullName(name); 
		acc.setPassword(password); 
		acc.setMobile(mobile); 
		
		AccountRepository accRepo = new AccountRepository();
		accRepo.createAccount(acc);
	}
	private void doPost(HttpServletRequest req, HttpServletResponse res) {
		doGet(req, res);

	}
	

