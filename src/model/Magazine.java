package model;
import java.util.Calendar;

public class Magazine extends BibliographicProduct {

	private String periodicity;
	private int subscriptions;
	private Category category;

	/**
	 * 
	 * @param name
	 * @param pages
	 * @param publicationDate
	 * @param url
	 * @param price
	 * @param id
	 * @param periodicity
	 * @param category
	 */
	public Magazine(String name, int pages, Calendar publicationDate, String url, double price, String id, String periodicity, Category category) {
		super(name, pages, publicationDate, url, price, id);
		this.periodicity = periodicity;
		this.category = category;
	}

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

	public Category getCategory() {
		return this.category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return super.toString() + "Periodicity: " + this.periodicity + "\n"
		 + "Category: " + category.getName() + "\n";
	}

}