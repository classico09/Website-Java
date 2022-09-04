package sw.ultis;

import java.util.Scanner;

public class ScannerUltis {

// dừng chương trình cho người dùng nhập liệu

	private static Scanner scanner = new Scanner(System.in);

	public static int InuputInt() {
		while (true) {

//Nhập vào 1 số nguyên
			try {
				return Integer.parseInt(scanner.next().trim());// .trim() ==> là cắt khoảng cách

			} catch (Exception e) {
				System.out.println("Nhập lại: ");

			}
		}

	}

//nhập số thực
	public static Double InuputDouble() {
		while (true) {

			try {
				return Double.parseDouble(scanner.next().trim());// .trim() ==> là cắt khoảng cách

			} catch (Exception e) {
				System.out.println("Nhập lại: ");

			}
		}

	}

//Nhập vào 1 số nguyên dương
	public static int InuputIntPositive() {
		while (true) {

			try {
				int result = Integer.parseInt(scanner.nextLine().trim());
				if (result >= 0) {
					return result;
				} else {
					System.err.println("Nhập lại: ");
				}
			} catch (Exception e) {
				System.out.println("Nhập lại: ");

			}
		}
	}
// Nhập chuỗi

	public static String inuputString() {
		while (true) {

			String string = scanner.next().trim();
			if (!string.isEmpty()) {
				return string;
			} else {
				System.err.println("Nhập lại: ");
			}

		}
	}

// Nhập email
	public static String inputEmail() {
		while (true) {
			String email = ScannerUltis.inuputString();
			if (email == null || !email.contains("@")) {
				System.out.print("Nhập lại: ");
			} else {
				return email;
			}
		}
	}

	public static String inputPassword() {
		while (true) {
			String password = ScannerUltis.inuputString();
			if (password.length() < 6 || password.length() > 12) {
				System.err.print("Nhập lại: ");
				continue;
			}

			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) { // isUpperCase > ký tự viết hoa
					return password;
				}
			}

			System.err.print("Nhập lại mật khẩu: ");
		}
	}

}