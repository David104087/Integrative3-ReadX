package model;
import java.util.Calendar;

public class RegularUser extends User {

	/**
	 * 
	 * @param name
	 * @param id
	 * @param linkingDate
	 */
	public RegularUser(String name, String id, Calendar linkingDate, double balance) {
		super(name, id, linkingDate, balance);
	}

}