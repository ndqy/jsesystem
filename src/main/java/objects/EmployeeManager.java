package objects;

public class EmployeeManager extends Manager {

	@Override
	public String getInfo(Person p) {
		// TODO Auto-generated method stub
		return "EmployeeManager - " + p.toString();
	}

}
