package model;
import java.util.Calendar;

public class Magazine extends BibliographicProduct {

	private String id;
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
	public Magazine(String name, int pages, Calendar publicationDate, String url, double price, String periodicity, Category category) {
		super(name, pages, publicationDate, url, price);
		this.id = generateId();
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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public  String generateId() {
		String alfanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String alfId = "";
		for (int i = 0; i < 3; i++) {
			alfId += alfanumeric.charAt((int) (Math.random() * alfanumeric.length()));//generate a random character and add it to the id
		}
		return alfId;
	}

	@Override
	public String showAttributesToModify() {
		return super.showAttributesToModify() + "\n(6) Periodicity: " + this.periodicity + 
		"\n(7) Category: " + this.category.getName() + "\n";
	}

	@Override
	public String toString() {
		return super.toString() + "\nPeriodicity: " + this.periodicity + 
		"\nCategory: " + this.category.getName() + "\nID: " + id + "\n";
	}

}