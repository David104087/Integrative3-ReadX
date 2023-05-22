package model;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * This abstract class represents a user, which can be a premium user or a regular user.
 */
public abstract class User {

	/**
	 * This attribute represents the name of the user.
	 */
	private String name;
	/**
	 * This attribute represents the id of the user.
	 */
	private String id;
	/**
	 * This attribute represents the date of linking of the user.
	 */
	private Calendar linkingDate;
	/**
	 * This attribute represents the balance of the user.
	 */
	private double balance;

	/**
	 * This attribute represents the invoices of the user.
	 */
	private ArrayList<Invoice> invoices;
	private Library library;

	public User(String name, String id, Calendar linkingDate, double balance) {
		this.name = name;
		this.id = id;
		this.linkingDate = linkingDate;
		this.balance = balance;
		invoices = new ArrayList<Invoice>();
		library = new Library();
	}


	/**
	 * The function returns a string representation of the User with formatted name, ID, linking date, and
	 * balance.
	 * 
	 * @return A string representation of the User that includes the name, ID, linking date, and balance
	 * formatted as a currency in US dollars.
	 */
	public String toString() {
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();	
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);	
		return "Name: " + this.name + "\nID: " + this.id + "\nLinking date: " + this.linkingDate.getTime() + "\n"
				+ "Balance: " + formatDollars.format(this.balance);
	}




	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getLinkingDate() {
		return this.linkingDate;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setLinkingDate(Calendar linkingDate) {
		this.linkingDate = linkingDate;
	}

	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	public Library getLibrary() {
		return this.library;
	}

	public void addInvocie(Invoice invoice) {
		invoices.add(invoice);
	}





}