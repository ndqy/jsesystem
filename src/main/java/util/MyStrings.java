package util;

import java.util.*;

public class MyStrings {

	/**
	 * Phương thức dùng để đếm 1 ký tự có trong chuỗi<br>
	 * <i>Cập nhập ngày 19/03/23<i>
	 * 
	 * @param str          - Chuỗi truyền vào
	 * @param ch           - Ký tự cần đếm
	 * @param isIgnoreCase - Biến kiểm tra xem có bỏ qua kiểu chữ không
	 * @return số lượng 1 ký tự có trong chuỗi
	 */
	public static int countChar(String str, char ch, boolean isIgnoreCase) {
		int count = 0;

		if (isIgnoreCase) {
			str = str.toLowerCase();
			ch = Character.toLowerCase(ch);
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

	public static String formatString(String str, formatAllow fa) {
		// Khai báo danh sách ký tự đặc biệt
		char[] chs = { '~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}', '[', ']', '\\', '|', ';',
				':', '\'', '"', '<', '>', ';', ':' };
		// Ký tự đặc biệt '\''<dấu'> và '\\' <dấu \>

		// Loại bỏ ký tự đặc biệt trong chuỗi
		for (char ch : chs) {
			str = str.replace(ch, ' ');

		}
		// Loại bỏ dấu cách
		str = str.trim();
		while (str.indexOf("  ") != -1) {
			str = str.replace("  ", " ");
		}
		str.replace(" , ", ", ");
		str.replace(" . ", ". ");

		// xử lý theo các tên riêng / Câu căn bản /...
		switch (fa) {

		case NAME:

		case FULLNAME:
			String[] words = str.split(" ");
			String tmp = "";
			for (String w : words) {
				w = w.toLowerCase();
				tmp += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
			}
			str = tmp.trim();
			break;
		case SENTENCE:
			str = Character.toUpperCase(str.charAt(0)) + str.substring(1);

		default:
		}

		return str;
	}

	public static int countWords(String str) {
		// Chuẩn hóa
		str = MyStrings.formatString(str, formatAllow.DEFAULT);
		return MyStrings.countChar(str, ' ', false) + 1;
	}

	public static HashMap<String, Integer> statisticWords(String str, String ch_split) {
		HashMap<String, Integer> tmp = new HashMap<>();

		String[] tmp_words = str.split(ch_split);
		for (String w : tmp_words) {
			if (!w.equalsIgnoreCase("")) {
				w = w.trim();
				if (tmp.containsKey(w)) {
					tmp.replace(w, tmp.get(w) + 1);
				} else {
					tmp.put(w, 1);
				}
			}

		}
		return tmp;
	}

	public static void printStatistic(HashMap<String, Integer> sta) {
		
		TreeMap<String, Integer> tmp = new TreeMap<>(sta);
		
		//Viết bằng java 5
		for (Map.Entry<String, Integer> e : tmp.entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		//Viết bằng java 8
	}

	public static void main(String[] args) {
		String str = "@abc@@abc@@def@@mnb@def@@@@mnb@@@@mnb@@@@";

		// Đếm ký tự
		// int count = MyStrings.countChar(str, 'e', true);
		// System.out.println("Có " + count + " ký tự e");

		// Chuẩn hóa ký tự
		// System.out.println(MyStrings.formatString(str, formatAllow.FULLNAME));

		// Đếm từ
		// System.out.println("Chuỗi có " + MyStrings.countWords(str) + " từ");

		MyStrings.printStatistic(MyStrings.statisticWords(str, "@"));
	}
}

enum formatAllow {
	NAME, FULLNAME, SENTENCE, DEFAULT,
}