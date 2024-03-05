package objects;

public class Employee extends Person {
	// Constants
	public static final int NET = 0;
	public static final String POSITION = "NULL";
	// Student's properties
	private int net;
	private String position;

	// Contructor's methods
	public Employee() {
		this(Employee.FIRSTNAME, Employee.LASTNAME, Employee.AGE, Employee.ADDRESS, Employee.NET, Employee.POSITION);

	}

	public Employee(String firstName, String lastName, byte age, Address address, int net, String position) {
		super(firstName, lastName, age, address);

		this.net = net;
		this.position = position;

	}

	// Getter
	public int getNet() {
		return net;
	}

	public String getPosition() {
		return position;
	}
	// Setter

	public void setNet(int net) {
		this.net = net;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [" + super.toString() + ": NET= " + net + ", POSITION=" + position + "]";
	}
/*
	public static void main(String[] args) {
		Address addr = new Address("Bắc Ninh", "Yên Phong", "295");
		Person e = new Employee("Linh", "Nguyễn Văn", (byte) 20, addr, 12_000_000, "Kỹ sư");
		Person s = new Student("Quý", "Nghiêm Đình", (byte) 20, addr, 12_345, "Công nghệ thông tin");
		
		System.out.println(s.toString());
		System.out.println(e);
	}
	*/
}
