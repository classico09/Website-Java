package sw.frontend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import sw.entity.Account;
import sw.entity.Cart;
import sw.entity.Product;
import sw.repository.AccountRepository;
// import sw.repository.CardRepository;
import sw.repository.CartRepository;
import sw.repository.ProductRepository;
import sw.ultis.ScannerUltis;

@WebServlet("/homepage")
public class Main extends HttpServlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductRepository productRepository = new ProductRepository();
		productRepository.ShowAllProduct();
	}

}
