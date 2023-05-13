package model;
import java.util.Calendar;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * This class represents an invoice of a product.
 */
public class Invoice {

	/**
	 * This attribute represents the name of the product.
	 */
	private String productName;
	/**
	 * This attribute represents the price of the product.
	 */
	private double price;
	/**
	 * This attribute represents the date of the invoice.
	 */
	private Calendar date;

	public Invoice(String productName, double price, Calendar date) {
		this.productName = productName;
		this.price = price;
		this.date = date;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * This function returns the invoice as a string.
	 * @return the invoice as a string with the product name, price and date.
	 */
	public String toString() {
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();	
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);	
		return "-----------Invoice------------\n" +
				"Product: " + this.productName + "\n" +
				"Price: " + formatDollars.format(this.price) + "\n" +
				"Date: " + this.date.getTime() + "\n" +
				"-----------------------\n";
	}

}