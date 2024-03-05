package objects;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address addr = new Address("Bắc Ninh", "Yên Phong", "295");
		
		Person e = new Employee("Linh", "Nguyễn Văn", (byte) 20, addr, 12_000_000, "Kỹ sư");
		Person s = new Student("Quý", "Nghiêm Đình", (byte) 20, addr, 12_345, "Công nghệ thông tin");
		
		System.out.println(s.toString());
		System.out.println(e.toString());
	
	}

}
