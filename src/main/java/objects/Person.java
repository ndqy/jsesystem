package objects;

public class Person implements Comparable<Person>{

	// Constants
	public static final String FIRSTNAME = "No FirstName";
	public static final String LASTNAME = "No LastName";
	public static final byte AGE = 0;
	public static final Address ADDRESS = new Address();

	// Object's properties
	private String firstName;
	private String lastName;
	private byte age;

	private Address address;

	// Constructors methods
	public Person() {
//		this.firstName = "No FirstName";
//		this.lastName = "No LastName";
//		this.age = 0;
		this(Person.FIRSTNAME, Person.LASTNAME, Person.AGE, Person.ADDRESS);
	}

	public Person(byte age) {
//		this.firstName = "No FirstName";
//		this.lastName = "No LastName";
//		this.age = age;
		this(Person.FIRSTNAME, Person.LASTNAME, age, Person.ADDRESS);
	}

	public Person(String firstName, byte age) {
//		this.firstName = firstName;
//		this.lastName = "No LastName";
//		this.age = age;
		this(firstName, Person.LASTNAME, age, Person.ADDRESS);
	}

	public Person(String firstName, String lastName, byte age, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

		// Cách 1 - gán địa chỉ trong bộ nhớ
		// this.address = address;

		// Cách 2 - Khởi tạo vùng nhớ mới và nhận giá trị
		this.address = new Address(address);

	}

//	public Person(byte age, String firstName, String lastName) {
//		age = age;
//		firstName = firstName;
//		lastName = lastName;
//	}

	// Getter methods
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public byte getAge() {
		return age;
	}

	public Address getAddress() {
		return address;
	}

	// Setter methods
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setAddress(String cityName,String districtName, String streetName) {
		this.address = new Address(cityName, districtName, streetName);
	}
	
	// Other methods
	
	public String toString() {
		//return lastName + " " + firstName + " , " + age;
		//return lastName + " " + firstName + " , " + age + " - " + this.address.toString();
		return lastName + " " + firstName + " , " + age;
	}

	
	protected void finalize() throws Throwable {
		System.gc();
		// super.finalize(); Có thể bỏ vì có sẵn
	}

	public static void main(String[] args) {
		// Khai báo và khởi tạo đối tượng
		Person p;
		Person p1 = new Person();
		Address addr = new Address("Hà Nội", "Cầu Giấy", "Trung Hòa");
		Person p2 = new Person((byte) 20);
		Person p3 = new Person("Quý", (byte) 20);
		Person p4 = new Person("Quý", "Nghiêm Đình", (byte) 20, addr);
		//System.out.println(p1);
		//System.out.println(p2);
		//System.out.println(p3);
		System.out.println(p4);
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		
		return this.getAge() - o.getAge();
	}
}
