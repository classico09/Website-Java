package sw.frontend;

import sw.entity.Account;
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
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Account-Đăng ký{createAccount}");
			System.out.format(leftAlignFormat, "2. Account-Đăng nhập{check login}");

			System.out.format(leftAlignFormat, "3. Product-Insert");// viết để đó
			System.out.format(leftAlignFormat, "4. Product-Select All");
			System.out.format(leftAlignFormat, "5. Product-Delete by ID");

			System.out.format(leftAlignFormat, "6. Cart-Insert");
			System.out.format(leftAlignFormat, "7. Cart-Select by Account ID");
			System.out.format(leftAlignFormat, "8. Cart-Delete by ID");

			System.out.format(leftAlignFormat, "9. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.InuputIntPositive()) {
//	Account		
			case 1:
				// case 1 sẽ là hàm mà mn lấy dữ liệu từ html xuống

				String mailInput = "duy@gmail.com";
				String passInput = "A1234567";
				String nameInput = "duy";
				Account account = new Account();

				account.setEmail(mailInput);
				account.setFullName(nameInput);
				account.setPassword(passInput);

				accountRepository.createAccount(account);
				break;

			case 2:
				// case 2 sẽ là hàm mà mn lấy dữ liệu từ html xuống
				String mail = "linh.dang@gmail.com";
				String ps = "A1234567";
				accountRepository.checkLogin(mail, ps);
				break;
// Product
			case 3:
				productRepository.insertProduct();
				break;

			case 4:
				productRepository.ShowAllProduct();
				break;
			case 5:
				int intInput = 1;
				productRepository.deleteProductByID(intInput);
				break;
// Cart
			case 6:
				cartRepository.InsertCart();
				break;
			case 7:
//				cartRepository.findCartByID();
				break;
			case 8:
				// int intInput = 1;
				// cartRepository.deleteCartByID(intInput);
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