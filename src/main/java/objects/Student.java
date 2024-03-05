package objects;

public class Student extends Person {

	// Constants
	public static final int STUDENT_ID = 0;
	public static final String STUDENT_SPECIALY = "NONE";
	
	// Student's properties
	private int student_id;
	private String student_specialy;

	// Contructor's methods
	public Student() {
		this(Student.FIRSTNAME, Student.LASTNAME, Student.AGE, Student.ADDRESS, Student.STUDENT_ID,
				Student.STUDENT_SPECIALY);

	}

	public Student(String firstName, String lastName, byte age, Address address, int student_id,
			String student_specialy) {

		// Khởi tạo thành công lớp cha(Person)
		super(firstName, lastName, age, address);

		// Gán giá trị cho các thuộc tính lớp con (Student)
		this.student_id = student_id;
		this.student_specialy = student_specialy;
	}

	// Getter
	public int getStudent_id() {
		return student_id;
	}

	public String getStudent_specialy() {
		return student_specialy;
	}

	// Setter
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public void setStudent_specialy(String student_specialy) {
		this.student_specialy = student_specialy;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + ": SI= " + student_id + ", SS=" + student_specialy + "]";
	}

	public static void main(String[] args) {
		Address addr = new Address();

		Person s = new Student("Quý", "Nghiêm Đình", (byte) 20, addr, 12_345, "Công nghệ thông tin");
		System.out.println(s.toString());
		
		
	}
}
