package model;
import java.util.Calendar;

public class RegularUser extends User {

	private int booksPurchased;
	private int magazinesSuscribed;

	/**
	 * 
	 * @param name
	 * @param id
	 * @param linkingDate
	 */
	public RegularUser(String name, String id, Calendar linkingDate, double balance) {
		super(name, id, linkingDate, balance);
	}

	public int getBooksPurchased() {
		return this.booksPurchased;
	}

	/**
	 * 
	 * @param booksPurchased
	 */
	public void setBooksPurchased(int booksPurchased) {
		this.booksPurchased += booksPurchased;
	}

	public int getMagazinesSuscribed() {
		return this.magazinesSuscribed;
	}

	/**
	 * 
	 * @param magazinesSuscribed
	 */
	public void setMagazinesSuscribed(int magazinesSuscribed) {
		this.magazinesSuscribed += magazinesSuscribed;
	}

}