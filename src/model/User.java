package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public abstract class User {

	private String name;
	private String id;
	private Calendar linkingDate;
	private double balance;
	private ArrayList<BibliographicProduct> products;

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
	public void addProduct(BibliographicProduct product) {
		products.add(product);
	}


	/**
	 * 
	 * @param name
	 */
	public Magazine findMagazineByName(String name) {
		// TODO - implement User.findMagazineByName
		throw new UnsupportedOperationException();
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Name: " + name + "\nID: " + id + "\nLinking date: " + sdf.format(linkingDate.getTime()) + "\n";
	}


}