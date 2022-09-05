package sw.frontend;

import sw.entity.Account;
import sw.entity.Cart;
import sw.entity.Product;
import sw.repository.AccountRepository;
// import sw.repository.CardRepository;
import sw.repository.CartRepository;
import sw.repository.ProductRepository;
import sw.ultis.ScannerUltis;

public class Demo {

	public static void main(String[] args) {
		AccountRepository accountRepository = new AccountRepository();
		ProductRepository productRepository = new ProductRepository();
		CartRepository cartRepository = new CartRepository();

		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");

			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Account-Đăng ký{createAccount}"); // OK
			System.out.format(leftAlignFormat, "2. Account-Đăng nhập{check login}");// OK

			System.out.format(leftAlignFormat, "3. Product-Insert");// OK
			System.out.format(leftAlignFormat, "4. Product-Select All");// OK
			System.out.format(leftAlignFormat, "5. Product-Delete by ID");// OK

			System.out.format(leftAlignFormat, "6. Cart-Insert"); // OK
			System.out.format(leftAlignFormat, "7. Cart-Select by Account ID"); // OK
			System.out.format(leftAlignFormat, "8. Cart-Delete by ID"); // OK

			System.out.format(leftAlignFormat, "9. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.InuputIntPositive()) {
//	Account		
			case 1:
				// case 1 sẽ là hàm mà mn lấy dữ liệu từ html xuống

				String mailInput = "duy2@gmail.com";
				String passInput = "A1234567";
				String nameInput = "duy2";
				String mobileInput = "01011112222";

				Account account = new Account(mailInput, passInput, nameInput, mobileInput);

				accountRepository.createAccount(account);
				break;

			case 2:
				// case 2 sẽ là hàm mà mn lấy dữ liệu từ html xuống
				String mail = "Account1@gmail.com";
				String pass = "A123458";

				Account account2 = new Account(mail, pass);

				accountRepository.checkLogin(account2);

				break;
// Product
			case 3:
				String name = "Product3";
				double price = 120.000;
				String image = "image3";
				String detail = "detail3";

				Product product = new Product(name, price, image, detail);

				productRepository.insertProduct(product);
				break;

			case 4:
				productRepository.ShowAllProduct();
				break;

			case 5:
				int intInput = 3;
				productRepository.deleteProductByID(intInput);
				break;
// Cart
			case 6:
				String name1 = "Product7";
				double price1 = 120.000;
				String image1 = "image7";
				String detail1 = "detail";
				int accId = 1;

				Cart cart = new Cart(name1, price1, image1, detail1, accId);

				cartRepository.InsertCart(cart);
				break;

			case 7:
				int idAccount = 1;
				cartRepository.getCartByAccountID(idAccount);

				break;

			case 8:
				int idDelete = 1;

				cartRepository.deleteCartByID(idDelete);
				break;
			case 9:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}

		}
	}

}