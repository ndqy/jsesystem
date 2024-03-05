package util;

import java.util.*;
import objects.*;

public class MyArrays {

	/**
	 * Phương thức dùng để sinh ngẫu nhiên mảng 1 chiều <br>
	 * <i>Cập nhật 22/2/23<i>
	 * 
	 * @author thanh
	 * @param n - Số phần tử của mảng
	 * @return Mảng 1 chiều gồm n phẩn tử
	 */
	public static int[] generateArray(int n) {
		int[] arrInt = new int[n];
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = (int) (Math.random() * 100);
		}

		return arrInt;
	}

	/**
	 * Phương thức dùng để sinh ngẫu nhiên mảng 2 chiều <br>
	 * <i>Cập nhật 22/2/23<i>
	 * 
	 * @author thanh
	 * @param rows - Số dòng
	 * @param cols - Số cột
	 * @return Mảng 2 chiều
	 */
	public static int[][] generateArray(int rows, int cols) {
		int[][] arrInt = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			arrInt[i] = MyArrays.generateArray(cols);
		}
		return arrInt;
	}

	public static Person[] generatePerson(int n) {
		Person[] list = new Person[n];

		// Danh sách tên
		String[] firstNames = { "Văn Linh", "Mai Lan", " Minh Châu", "Bá Long", "Tuấn Đạt", "Công Vĩnh", "Nhất Tâm",
				"Oanh", "Mai Linh", "Văn Dũng", "Duy Vũ", "Cẩm Tú", "Như Tú", "Đức Tiến", "Hồng Ánh", "Xuân Thảo",
				"Ngọc Ánh", "Quang Huy", "Thanh Thảo", "Ngọc Lan", "Mai Anh", "Tiến Anh", "Minh Anh", "Anh Đào",
				"Anh Thư" };
		// Danh sách họ
		String[] lastNames = { "Nguyễn", "Hà", "Nghiêm", "Hoàng", "Lê", "Trần", "Lương", "Ma", "Vương", "Phạm", "Ngô",
				"Huỳnh", "Lò", "Hồ", "Quách", };

		// Sinh mảng
		int index;
		for (int i = 0; i < n; i++) {
			// Cấp phát địa chỉ trong bộ nhớ cho phẩn tử mảng
			list[i] = new Person();

			// Ngẫu nhiên chỉ số để lấy ra tên trong firstName
			index = (int) (Math.random() * firstNames.length);
			list[i].setFirstName(firstNames[index]);

			// Ngẫu nhiên họ
			index = (int) (Math.random() * lastNames.length);
			list[i].setLastName(lastNames[index]);

			// Ngẫu nhiên tuổi
			index = 18 + (int) (Math.random() * 5);
			list[i].setAge((byte) index);
		}
		return list;
	}

	/**
	 * Phương thức dùng để sắp xếp mảng 1 chiều <br>
	 * <i>Cập nhật 22/2/23<i>
	 * 
	 * @author thanh
	 * @param arrInt - Mảng 1 chiều cần sắp xếp
	 * @param isINC  - Biến sắp xếp theo chiều tăng hay chiều giảm
	 * @return Mảng sau khi đã được sắp xếp
	 */
	public static int[] sortedArray(int[] arrInt, boolean isINC) {
		byte ori = (byte) (isINC ? 1 : -1);

		// Thực hiện sắp xếp
		for (int i = 0; i < arrInt.length; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				if (arrInt[i] * ori > arrInt[j]) {
					int tmp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = tmp;
				}
			}
		}
		return arrInt;
	}

	public static Integer[] sortedArrayV2(int[] arrInt, boolean isINC) {
		Integer[] data = new Integer[arrInt.length];
		Arrays.setAll(data, i -> arrInt[i]);
		if (isINC) {
			Arrays.sort(data);
		} else {
			Arrays.sort(data, Collections.reverseOrder());
		}
		return data;
	}

	public static Integer[] sortedArrayV2(Integer[] arrInt, boolean isINC) {

		if (isINC) {
			Arrays.sort(arrInt);
		} else {
			Arrays.sort(arrInt, Collections.reverseOrder());
		}
		return arrInt;
	}

	public static int[][] sortedArray(int[][] arrInt, boolean isINC) {
		int rows = arrInt.length;
		int cols = arrInt[0].length;

		Integer[] tmp = new Integer[rows * cols];

		// Sao chép giá trị

		int r = 0, c = 0;
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arrInt[r][c++];

			if (c == cols) {
				r++;
				c = 0;

			}
		}
		tmp = MyArrays.sortedArrayV2(tmp, true);

		// Chuyển về mảng 2 chiều
		r = 0;
		c = 0;
		for (int i = 0; i < tmp.length; i++) {
			arrInt[r][c++] = tmp[i];
			if (c == cols) {
				r++;
				c = 0;
			}
		}
		return arrInt;
	}

	public static void sortedPerson(Person[] list) {
		Person tmp;
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (list[i].getFirstName().compareToIgnoreCase(list[j].getFirstName()) > 0) {
					tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
		}
	}

	/**
	 * Phương thức dùng để tìm kiếm tên người<br>
	 * <i>Cập nhật 22/02/23<i>
	 * 
	 * @param list - Danh sách cần tìm kiếm
	 * @param name - Tên cần tìm kiếm
	 * @return
	 */
	public static Person[] searchPerson(Person[] list, String name) {
		// Khai báo mảng kết quả
		Person[] results = null;

		// Đếm số kết quả
		int count = 0;
		for (Person p : list) {
			if (p.getFirstName().contains(name)) {
				count++;
			}
		}

		// Khởi tạo mảng kết quả
		results = new Person[count];

		// Ghi nhận từng kết quả
		count = 0;
		for (Person p : list) {
			if (p.getFirstName().contains(name)) {
				results[count++] = p;
			}
		}
		return results;
	}

	public static ArrayList<Person> searchPersonV2(Person[] list, String name) {
		// Mảng kết quả
		ArrayList<Person> results = new ArrayList<>();

		// Ghi nhận kết quả
		for (Person p : list) {
			if (p.getFirstName().contains(name)) {
				results.add(p);
			}
		}
		return results;
	}

	public static ArrayList<Person> sortByAge(Person[] list, boolean isINC) {
		// Chuyển mảng đối tượng sang tập hợp
		ArrayList<Person> tmp = new ArrayList<>();

		// Sao chép phần tử
		Collections.addAll(tmp, list);

		// Thực hiện sắp xếp
		if (isINC) {
			Collections.sort(tmp);
		} else {
			Collections.sort(tmp, Collections.reverseOrder());
			// Collections.reverseOrder() dùng để đảo ngược thứ tự
		}

		return tmp;
	}

	public static ArrayList<Person> sortByName(Person[] list, boolean isINC) {
		// Chuyển mảng đối tượng sang tập hợp
		ArrayList<Person> tmp = new ArrayList<>();

		// Sao chép phần tử
		Collections.addAll(tmp, list);

		// Xác định điều kiện sắp xếp
		sortedByName s = new sortedByName();
		// Thực hiện sắp xếp
		if (isINC) {
			Collections.sort(tmp, new sortedByName());
		} else {
			Collections.sort(tmp, s.reversed());
			// Collections.reverseOrder() dùng để đảo ngược thứ tự
		}

		return tmp;
	}

	/**
	 * Phương thức dùng để in mảng 1 chiều <br>
	 * <i>Cập nhật 22/2/23<i>
	 * 
	 * @author thanh
	 * @param arrInt - Mảng cần được in
	 */
	public static void printArray(int[] arrInt) {
		// Cách 1 - C/C++
		// for (int i = 0; i < arrInt.length; i++) {
		// System.out.println(arrInt[i] + " ");
		// }

		// Cách 2 - JDK5
		// or (int value : arrInt) {
		// System.out.print(value + " ");
		// }

		// Cách 3 - Sử dụng Arrays <Chuyển đổi mảng nguyên thủy sang mảng đối tượng>
		Integer[] data = new Integer[arrInt.length];
		Arrays.setAll(data, i -> arrInt[i]);

		System.out.print(Arrays.toString(data));
		// System.out.print(Arrays.toString(arrInt));
		System.out.println();
	}

	/**
	 * Phương thức dùng để in mảng 2 chiều <br>
	 * <i>Cập nhật 22/2/23<i>
	 * 
	 * @author thanh
	 * @param arrInt - Mảng cần được in
	 */
	public static void printArray(int[][] arrInt) {
		// Cách 1 - Gọi phương thức 1 in chiều ở trên
		for (int[] row : arrInt) {
			MyArrays.printArray(row);
		}

		// Cách 2 - Sử dụng Arrays
		// System.out.print(Arrays.deepToString(arrInt));
	}

	/**
	 * Phương dùng để in ra danh sách tên
	 * 
	 * @param list - Danh sách tên
	 */
	public static void printPerson(Person[] list) {
		for (Person p : list) {
			System.out.println(p);
		}
	}

	public static void printPerson(ArrayList<Person> list) {
		// Cách 1
		// for (Person p : list) {
		// System.out.println(p);
		// }

		// Cách 4 - Sử dụng biểu thức Lambda trong JAVA 8 - CÁCH HIỆN ĐẠI
		list.forEach(item -> System.out.println(item));
	}

	public static void main(String[] args) {
		// Mảng 1 chiều
		// int[] arrInt = MyArrays.generateArray(20);
		// MyArrays.printArray(arrInt);

		// Sắp xếp
		// MyArrays.sortedArray(arrInt, true);

		// Mảng 2 chiều
		// int[][] arrInt = MyArrays.generateArray(5, 3);
		// MyArrays.printArray(arrInt);

		//Person[] list = MyArrays.generatePerson(10);

		//MyArrays.printPerson(list);

		//System.out.println("___________________________________________");

		// Tìm kiếm cách 1
		// Person[] results = MyArrays.searchPerson(list, "Anh");
		// MyArrays.printPerson(results);

		// Tìm kiếm cách 2
//		ArrayList<Person> results = MyArrays.searchPersonV2(list,"Anh");
//		MyArrays.printPerson(results);

		// Sắp xếp theo tuổi
		// ArrayList<Person> results = MyArrays.sortByAge(list,true);
		// MyArrays.printPerson(results);

		// Sắp xếp theo tên
		//ArrayList<Person> results = MyArrays.sortByName(list, true);
		//MyArrays.printPerson(results);
		
		// Mảng 2 chiều
		int[][] arrInt = MyArrays.generateArray(5, 10);
		MyArrays.printArray(arrInt);
		System.out.println("____________________________________");
		
		int[][] results = MyArrays.sortedArray(arrInt, true);
		MyArrays.printArray(results);
	}
}

// Comparator là bộ so sánh
// Comparable là có khả năng so sánh
class sortedByName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		String name1 = o1.getFirstName().trim();
		String name2 = o2.getFirstName().trim();

		// Chỉ lấy ra tên sau cùng- 1 từ

		// lastIndexOf là tìm đến ký tự sau cùng
		int at = name1.lastIndexOf(" ");
		if (at != -1) {
			name1 = name1.substring(at + 1);
		}
		at = name2.lastIndexOf(' ');
		if (at != -1) {
			name2 = name2.substring(at + 1);
		}

		// compareToIgnoreCase so sánh bỏ qua kiểu chữ thường - hoa
		return name1.compareToIgnoreCase(name2);
	}

}