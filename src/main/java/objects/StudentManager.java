package objects;

public class StudentManager extends Manager {

	@Override
	public String getInfo(Person p) {
		// TODO Auto-generated method stub
		return "StudentManager - " + p.toString();
	}
}
