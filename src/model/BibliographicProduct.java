package model;
import java.util.Calendar;
import java.text.NumberFormat;
import java.util.Locale;

/*
 * This class represents a bibliographic product.
 */
public abstract class BibliographicProduct {

	/*
	 * This attribute represents the name of the product.
	 */
	private String name;
	/*
	 * This attribute represents the number of pages of the product.
	 */
	private int pages;
	/*
	 * This attribute represents the date of publication of the product.
	 */
	private Calendar publicationDate;
	private String url;
	private double price;
	private int pagesRead;
	private String[] sheets;

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
		this.sheets = new String[pages];
		initSheets(pages);
	}
	
	public void initSheets(int pages) {
		for (int i = 0; i < pages; i++) {
			this.sheets[i] = "Page " + (i + 1);
		}
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
		this.pagesRead += pagesRead;
	}

	public abstract String generateId();

	public String[] getSheets() {
		return this.sheets;
	}

	public void setSheets(String[] sheets) {
		this.sheets = sheets;
	}

	public String showAttributesToModify() {
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);
		return "(1) Name: " + name + "\n(2) Pages: " + pages + "\n(3) Publication Date: " + publicationDate.getTime()
		+ "\n(4) URL: " + url + "\n(5) Price: " + formatDollars.format(price);
	}

	public String toString() {
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);
		return "Name: " + name + "\nPages: " + pages + "\nPublication Date: " + publicationDate.getTime()
		+ "\nURL: " + url + "\nPrice: " + formatDollars.format(price);
	}

}