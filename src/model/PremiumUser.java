package model;
import java.util.Calendar;

public class PremiumUser extends User {

	/**
	 * 
	 * @param name
	 * @param id
	 * @param linkingDate
	 */
	public PremiumUser(String name, String id, Calendar linkingDate) {
		super(name, id, linkingDate);
	}

}