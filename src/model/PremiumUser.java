package model;
import java.util.Calendar;

public class PremiumUser extends User {

	/**
	 * 
	 * @param name
	 * @param id
	 * @param linkingDate
	 */
	public PremiumUser(String name, String id, Calendar linkingDate, double balance) {
		super(name, id, linkingDate, balance);
	}

}