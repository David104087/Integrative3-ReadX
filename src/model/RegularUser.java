package model;
import java.util.Calendar;


/**
 * This class represents a regular user.
 */
public class RegularUser extends User {

	/**
	 * This attribute represents the number of books purchased by the user.
	 */
	private int booksPurchased;
	/**
	 * This attribute represents the number of magazines suscribed by the user.
	 */
	private int magazinesSuscribed;

	public RegularUser(String name, String id, Calendar linkingDate, double balance) {
		super(name, id, linkingDate, balance);
	}

	public int getBooksPurchased() {
		return this.booksPurchased;
	}

	public void setBooksPurchased(int booksPurchased) {
		this.booksPurchased += booksPurchased;
	}

	public int getMagazinesSuscribed() {
		return this.magazinesSuscribed;
	}

	public void setMagazinesSuscribed(int magazinesSuscribed) {
		this.magazinesSuscribed += magazinesSuscribed;
	}

}