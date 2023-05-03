package model;
import java.util.Calendar;

public class Magazine extends BibliographicProduct {

	private String periodicity;
	private int subscriptions;

	public String getPeriodicity() {
		return this.periodicity;
	}

	/**
	 * 
	 * @param periodicity
	 */
	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	/**
	 * 
	 * @param name
	 * @param pages
	 * @param publicationDate
	 * @param url
	 * @param price
	 * @param id
	 * @param preiodicity
	 * @param category
	 */
	public Magazine(String name, int pages, Calendar publicationDate, String url, double price, String id, String preiodicity, Category category) {
		super(name, pages, publicationDate, url, price, id);
		this.periodicity = preiodicity;
		this.category = category;
	}

	public int getSubscriptions() {
		return this.subscriptions;
	}

	/**
	 * 
	 * @param subscriptions
	 */
	public void setSubscriptions(int subscriptions) {//arreglar int en el diagrama
		this.subscriptions = subscriptions;
	}

}