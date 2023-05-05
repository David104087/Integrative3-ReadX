package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class BibliographicProduct {

	private String name;
	private int pages;
	private Calendar publicationDate;
	private String url;
	private double price;
	private int pagesRead;

	/**
	 * 
	 * @param name
	 * @param pages
	 * @param publicationDate
	 * @param url
	 * @param price
	 * @param id
	 */
	public BibliographicProduct(String name, int pages, Calendar publicationDate, String url, double price) {
		this.name = name;
		this.pages = pages;
		this.publicationDate = publicationDate;
		this.url = url;
		this.price = price;
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

	public int getPages() {
		return this.pages;
	}

	/**
	 * 
	 * @param pages
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	public Calendar getPublicationDate() {
		return this.publicationDate;
	}

	/**
	 * 
	 * @param publicationDate
	 */
	public void setPublicationDate(Calendar publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getUrl() {
		return this.url;
	}

	/**
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public int getPagesRead() {
		return this.pagesRead;
	}

	/**
	 * 
	 * @param pagesRead
	 */
	public void setPagesRead(int pagesRead) {
		this.pagesRead = pagesRead;
	}

	public abstract String generateId();

	public String showAttributesToModify() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);
		return "(1) Name: " + name + "\n(2) Pages: " + pages + "\n(3) Publication Date: " + sdf.format(publicationDate.getTime())
		+ "\n(4) URL: " + url + "\n(5) Price: " + formatDollars.format(price);
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);
		return "\nName: " + name + "\nPages: " + pages + "\nPublication Date: " + sdf.format(publicationDate.getTime()) 
		+ "\nURL: " + url + "\nPrice: " + formatDollars.format(price);
	}

}