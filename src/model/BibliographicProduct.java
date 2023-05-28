package model;
import java.util.Calendar;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * This class represents a bibliographic product.
 */
public abstract class BibliographicProduct {

	/**
	 * This attribute represents the name of the product.
	 */
	private String name;
	/**
	 * This attribute represents the id of the product.
	 */
	private String id;
	/**
	 * This attribute represents the number of pages of the product.
	 */
	private int pages;
	/**
	 * This attribute represents the date of publication of the product.
	 */
	private Calendar publicationDate;
	/**
	 * This attribute represents the URL of the product.
	 */ 
	private String url;
	/**
	 * This attribute represents the price of the product.
	 */
	private double price;
	/**
	 * This attribute represents the number of pages read of the product.
	 */
	private int pagesRead;
	/**
	 * This attribute represents the pages of the product.
	 */
	private String[] sheets;
	/**
	 * This attribute represents the number of units sold of the product.
	 */
	private int unitsSold;
	/**
	 * This attribute represents the total sales of the product.
	 */
	private double totalSales;



	public BibliographicProduct(String name, int pages, Calendar publicationDate, String url, double price) {
		this.name = name;
		this.pages = pages;
		this.publicationDate = publicationDate;
		this.url = url;
		this.price = price;
		this.sheets = new String[pages];
		this.id = generateId();
		initSheets(pages);
	}

	/**
	 * This abstract method will be implemented in the subclasses for generate 
	 * the id of the product.
	 */
	public abstract String generateId();

	
	/**
	 * This function initializes the pages of the product with with a given number of pages.
	 * 
	 * @param pages The number of pages to initialize in the "sheets" array.
	 */
	public void initSheets(int pages) {
		for (int i = 0; i < pages; i++) {
			this.sheets[i] = "Page " + (i + 1);
		}
	}

	/**
	 * The function returns a string that displays the attributes of the product.
	 * 
	 * @return A string containing the attributes of a book object that can be modified, including name,
	 * pages, publication date, URL, and price formatted as a currency.
	 */
	public String showAttributesToModify() {
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);
		return "(1) Name: " + name + "\n(2) Pages: " + pages + "\n(3) Publication Date: " + publicationDate.getTime()
		+ "\n(4) URL: " + url + "\n(5) Price: " + formatDollars.format(price);
	}

	/**
	 * This function returns a string with the information of the product, including its name, pages,
	 * publication date, URL, and price formatted as a currency.
	 * 
	 * @return A string representation of an object that includes the name, number of pages, publication
	 * date, URL, and price of a book. The price is formatted as a currency using the US locale.
	 */
	public String toString() {
		Locale locale = new Locale.Builder()
		.setLanguage("en")
		.setRegion("US")
		.build();
		NumberFormat formatDollars = NumberFormat.getCurrencyInstance(locale);
		return "Name: " + this.name + "\nID:" + this.id +
		"\nPages: " + this.pages + "\nPublication Date: " + this.publicationDate.getTime()
		+ "\nURL: " + this.url + "\nPrice: " + formatDollars.format(this.price);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Calendar getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(Calendar publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPagesRead() {
		return this.pagesRead;
	}

	public void setPagesRead(int pagesRead) {
		this.pagesRead += pagesRead;
	}

	public String[] getSheets() {
		return this.sheets;
	}

	public void setSheets(String[] sheets) {
		this.sheets = sheets;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getUnitsSold() {
		return this.unitsSold;
	}

	public void setUnitsSold(int unitSold) {
		this.unitsSold += unitSold;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public void setTotalSales() {
		this.totalSales = getPrice() * getUnitsSold();
	}

}