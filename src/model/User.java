package model;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;


public abstract class User {

	private String name;
	private String id;
	private Calendar linkingDate;
	private double balance;
	private ArrayList<BibliographicProduct> products;
	private ArrayList<Invoice> invoices;

	/**
	 * 
	 * @param name
	 * @param id
	 * @param linkingDate
	 */
	public User(String name, String id, Calendar linkingDate, double balance) {
		this.name = name;
		this.id = id;
		this.linkingDate = linkingDate;
		this.balance = balance;
		products = new ArrayList<BibliographicProduct>();
		invoices = new ArrayList<Invoice>();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Calendar getLinkingDate() {
		return this.linkingDate;
	}

	public double getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * 
	 * @param linkingDate
	 */
	public void setLinkingDate(Calendar linkingDate) {
		this.linkingDate = linkingDate;
	}

	/**
	 * 
	 * @param product
	 */
	public void addProduct(BibliographicProduct product, Invoice invoice) {
		products.add(product);
		invoices.add(invoice);
	}
	

	/**
	 * 
	 * @param name
	 */
	public Magazine findMagazineById(String id) {
		for (BibliographicProduct product : products) {
			if (product instanceof Magazine) {
				if (product.getName().equals(name)) {
					return (Magazine) product;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 */
	public Book findBookById(String id) {
		for (BibliographicProduct product : products) {
			if (product instanceof Book) {
				if (product.getName().equals(name)) {
					return (Book) product;
				}
			}
		}
		return null;
	}

	public String toString() {
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();	
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);	
		return "Name: " + this.name + "\nID: " + this.id + "\nLinking date: " + this.linkingDate.getTime() + "\n"
				+ "Balance: " + formatDollars.format(this.balance);
	}

	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	public String unsubscribeOfAMagazine(String magazineId) {
		String msg = "";
		boolean isFound = false;
		for (BibliographicProduct product : products) {
			if (product instanceof Magazine) {
				if (( (Magazine) product).getId().equals(magazineId)) {
					products.remove(product);
					msg = "The user " + this.name + " has been unsubscribed of the magazine " + magazineId;
					isFound = true;
					break;
				}
			}
		}
		return msg;
	}

	
	
}