package objects;

public abstract class Manager {
	// Phương thức trừu tượng
	public abstract String getInfo(Person p);
		
	//Phương thức tường minh
	public String getDetails(Person p) {
		return this.getInfo(p);
	}

}
