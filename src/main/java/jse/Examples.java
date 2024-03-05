package jse;

public class Examples {

	/**
	 * Phương thức kiểm tra n có phải là số nguyên tố <br>
	 * <i>Cập nhật ngày 12/02/23<i>
	 * 
	 * @author DinhQuy
	 * @param n - Giá trị cần kiểm tra
	 * @return - Kết quả trả về đúng hay sai
	 */
	public static boolean isPrime(int n) {
		// Kiểm tra n có phải nguyên tố không

		boolean flag = true;
		if (n < 2) {
			flag = false;
		} else {
			for (int v = 2; v <= (int) (Math.sqrt(n)); v++) {
				if (n % v == 0) {
					flag = false;
					break;
				}
			}
		}

		return flag;

	}
	/**
	 * Phương thức tìm UCLN của 2 số nguyên dương <br>
	 * <i> Cập nhập ngày 12/02/23
	 * @author DinhQuy
	 * @param a - Số thứ nhất
	 * @param b - Số thứ hai
	 * @return - Kết quả là giá trị nguyên hoặc -1(Không tồn tại UCLN)
	 */
	public static int getUCLN(int a, int b) {
		int ucln = -1;
		if (a * b != 0) {
			while (a != b) {
				if (a > b) {
					a = a - b;
				} else {
					b = b - a;
				}
			}
			ucln = a; // hoặc ucln = b đều được
		}

		return ucln;
	}

	/**
	 * Phương thức tìm UCLN của 2 số nguyên dương <br>
	 * <i> Cập nhập ngày 12/02/23
	 * @author DinhQuy
	 * @param a - Số thứ nhất
	 * @param b - Số thứ hai
	 * @param c - Số thứ ba
	 * @return - Kết quả là giá trị nguyên hoặc -1(Không tồn tại UCLN)
	 */
	public static int getUCLN(int a, int b, int c) {
		
		return Examples.getUCLN(Examples.getUCLN(a, b), c);
	}
	public static void main(String[] args) {

		// Sinh ngẫu nhiên giá trị n
		int n = (int) (Math.random() * 100);
		int m = (int) (Math.random() * 100);
		// In thông tin
		System.out.println("UCLN của n = " + n + " và m = " + m + " là: " + Examples.getUCLN(n, m));

		// Khởi tạo đối tượng thuộc lớp Examples

		// Examples e = new Examples();

		// boolean flag = e.isPrime(n);

		// Thông báo kết quả
		//if (Examples.isPrime(n)) {
		//	System.out.println("Là nguyên tố");
		//} else {
		//	System.out.println("Không nguyên tố");
		//}
	}
}
