package util;

import java.util.Scanner;

public class test {

	private int MaSV;
	private String HoTen;
	private float DLT;
	private float DTH;

	public test() {
		MaSV = 0;
		HoTen = "NULL";
		DLT = 0;
		DTH = 0;
	}

	public test(int MaSV, String HoTen, float DLT, float DTH) {
		this.MaSV = MaSV;
		this.HoTen = HoTen;
		this.DLT = DLT;
		this.DTH = DTH;
	}

	public int getMaSV() {
		return MaSV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public float getDLT() {
		return DLT;
	}

	public float getDTH() {
		return DTH;
	}

	public void setMaSV(int MaSV) {
		this.MaSV = MaSV;
	}

	public void setHoTen(String HoTen) {
		this.HoTen = HoTen;
	}

	public void setDLT(float DLT) {
		this.DLT = DLT;
	}

	public void setDTH(float DTH) {
		this.DTH = DTH;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã sinh viên: ");
		MaSV = sc.nextInt();
		sc.nextLine();// đọc ký tự Enter còn lại trong bộ đệm đầu vào
		System.out.print("Nhập họ tên sinh viên: ");
		HoTen = sc.nextLine();
		System.out.print("Nhập điểm lý thuyết: ");
		DLT = sc.nextFloat();
		System.out.print("Nhập điểm thực hành: ");
		DTH = sc.nextFloat();
	}

	public String KetQua() {
		if ((float) (DLT + DTH) / 2 >= 5) {
			return "Đậu";
		} else {
			return "Rớt";
		}
	}

	public static void SapXep(test[] a) {
		test tmp;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i].getHoTen().compareToIgnoreCase(a[j].getHoTen()) > 0) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;

				}
				if (a[i].getHoTen().compareToIgnoreCase(a[j].getHoTen()) == 0) {
					if (a[i].getDLT() > a[j].getDLT()) {
						tmp = a[i];
						a[i] = a[j];
						a[j] = tmp;
					}

				}
			}
		}
	}

	public static void MaxMin(test[] a) {
		test max = new test();
		max = a[0];
		test min = new test();
		min = a[0];
		for (int i = 0; i < a.length - 1; i++) {
			if((float)(max.getDLT() + max.getDTH())/2 < ((float)a[i].getDLT() + a[i].getDTH())/2) {
				max = a[i];
			}
				
			if((float)(min.getDLT() + min.getDTH())/2 > ((float)a[i].getDLT() + a[i].getDTH())/2) {
				min = a[i];
			}
				
		}
		System.out.println("Sinh viên điểm TB cao nhất: ");
		max.inDuLieu();
		System.out.println("Sinh viên điểm TB thấp nhất: ");
		min.inDuLieu();
	}

	public String toString() {
		return String.format("%-10d%-20s%-10f%-10f%-10f", MaSV, HoTen, DLT, DTH, (float) (DLT + DTH) / 2);
	}

	public void inTieuDe() {
		System.out.printf("%-10s%-20s%-10s%-10s%-10s\n", "Mã SV", "Họ Tên", "Điểm LT", "Điểm TH", "Điểm TB");

	}

	public void inDuLieu() {
		System.out.println(toString());
	}

	public static void main(String[] args) {
		test[] a = new test[3];
		a[0] = new test();

		a[0].nhap();

		a[1] = new test(2, "Linh", 10, 10);

		a[2] = new test();
		a[2].setMaSV(3);
		a[2].setHoTen("Bình");
		a[2].setDLT(9);
		a[2].setDTH(8);

		a[1].inTieuDe();
		for (int i = 0; i < a.length; i++) {
			a[i].inDuLieu();
		}
		System.out.println("___________________________________");
		a[1].inTieuDe();
		test.SapXep(a);
		for (int i = 0; i < a.length; i++) {
			a[i].inDuLieu();
		}
		test.MaxMin(a);
	}
}
