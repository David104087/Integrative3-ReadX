package model;
import java.util.Calendar;

/**
 * This class represents a premium user.
 */
public class PremiumUser extends User {

	public PremiumUser(String name, String id, Calendar linkingDate, double balance) {
		super(name, id, linkingDate, balance);
	}

}