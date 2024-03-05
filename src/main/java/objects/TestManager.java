package objects;

public class TestManager {
	public static void main(String[] args) {
		Address addr = new Address("Bắc Ninh", "Yên Phong", "295");

		Person e = new Employee("Linh", "Nguyễn Văn", (byte) 20, addr, 12_000_000, "Kỹ sư");
		Person s = new Student("Quý", "Nghiêm Đình", (byte) 20, addr, 12_345, "Công nghệ thông tin");

		// -------------------------------------
		Manager sm = new StudentManager();
		Manager em = new EmployeeManager();

		System.out.println(sm.getDetails(s));
		System.out.println(em.getDetails(e));
	}
}
