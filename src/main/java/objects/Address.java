package objects;

public class Address {
	// Constants
	public static final String CITYTNAME = "No CityName";
	public static final String DISTRICTNAME = "No DistrictName";
	public static final String STREETNAME = "No StreetName";

	// Object's properties
	private String cityName;
	private String districtName;
	private String streetName;

	// Constructors methods

	public Address() {
		this(Address.CITYTNAME, Address.DISTRICTNAME, Address.STREETNAME);
	}

	public Address(String cityName) {
		this(cityName, Address.DISTRICTNAME, Address.STREETNAME);
	}

	public Address(String cityName, String districtName) {
		this(cityName, districtName, Address.STREETNAME);
	}

	public Address(String cityName, String districtName, String streetName) {
		this.cityName = cityName;
		this.districtName = districtName;
		this.streetName = streetName;
	}
	
	public Address(Address addr) {
		this(addr.getCityName(), addr.getDistrictName(), addr.getStreetName());
	}

	// Getter methods

	public String getCityName() {
		return cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public String getStreetName() {
		return streetName;
	}

	// Setter methods
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	// Other methods
	public String toString() {
		return cityName + " - " + districtName + " - " + streetName;
	}

	public void finalize() throws Throwable {
		System.gc();
	}
	
	public static void main(String[] args) {
		Address a;
		Address a1 = new Address("Bắc Ninh");
		Address a2 = new Address("Bắc Ninh", "Yên Phong");
		Address a3 = new Address("Bắc Ninh", "Yên Phong", "295");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}
	//Sắp xếp tên theo thứ tụ ABC
}
