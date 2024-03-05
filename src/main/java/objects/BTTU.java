package objects;

import java.util.*;

public interface BTTU  extends CTX, CTH, GDS{
	public List<Person> getAll();
	public List<Person> getPerson(Address addr);
	
	public ArrayList<Person> getNames();
	public ArrayList<Person> getNames(Address addr);
	
	public HashMap<Integer, Person> getPositions();
	public HashMap<Integer, Person> getPositions(Address addr);
}
