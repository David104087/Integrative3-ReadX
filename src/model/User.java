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
	 * This attribute represents the products of the user.
	 */
	private ArrayList<BibliographicProduct> products;
	/**
	 * This attribute represents the invoices of the user.
	 */
	private ArrayList<Invoice> invoices;

	public User(String name, String id, Calendar linkingDate, double balance) {
		this.name = name;
		this.id = id;
		this.linkingDate = linkingDate;
		this.balance = balance;
		products = new ArrayList<BibliographicProduct>();
		invoices = new ArrayList<Invoice>();
	}

	
	/**
	 * The function adds a bibliographic product and an invoice to their respective lists.
	 * 
	 * @param product BibliographicProduct object that represents a product being added to the list of
	 * products in the system.
	 * @param invoice The parameter "invoice" is an object of the class "Invoice". It is being passed as an
	 * argument to the method "addProduct". The purpose of this parameter is to associate the product being
	 * added with the invoice to which it belongs.
	 */
	public void addProduct(BibliographicProduct product, Invoice invoice) {
		products.add(product);
		invoices.add(invoice);
	}
	

	/**
	 * This function searches for a product by ID in the list of books and magazines and returns the
	 * matching product.
	 * 
	 * @param productId a String representing the ID of a product that needs to be found in a list of
	 * products.
	 * @return The method is returning a BibliographicProduct object, which is either a Book or a Magazine,
	 * depending on the ID provided as a parameter. If no product is found with the given ID, the method
	 * returns null.
	 */
	public BibliographicProduct findProductById(String productId) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				if ( ( (Magazine) products.get(i) ).getId().equals(productId)) {
					return products.get(i);
				}
			} else {
				if ( ( (Book) products.get(i) ).getId().equals(productId)) {
					return products.get(i);
				}
			} 
		}
		return null;
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


	/**
	 * The function removes a magazine from the list of products and returns a message indicating that the
	 * user has been unsubscribed from the magazine.
	 * 
	 * @param magazineId a String representing the ID of the magazine that the user wants to unsubscribe
	 * from.
	 * @return The method is returning a String message indicating whether the user has been unsubscribed
	 * from a magazine or not. If the magazine is found and the user is unsubscribed, the message will
	 * contain the name of the user and the magazine ID. If the magazine is not found, the message will be
	 * an empty string.
	 */
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

}