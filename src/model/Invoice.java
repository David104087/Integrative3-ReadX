package model;
import java.util.Calendar;
import java.text.NumberFormat;
import java.util.Locale;

public class Invoice {

	private String productName;
	private double price;
	private Calendar date;

	/**
	 * 
	 * @param date
	 * @param amount
	 */
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