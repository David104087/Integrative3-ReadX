package model;
import java.util.Calendar;

/**
 * This class represents a magazine.
 */
public class Magazine extends BibliographicProduct {

	/**
	 * This attribute represents the id of the magazine.
	 */
	private String id;
	/**
	 * This attribute represents the periodicity of the magazine.
	 */
	private String periodicity;
	/**
	 * This attribute represents the subscriptions of the magazine.
	 */
	private int subscriptions;
	/**
	 * This attribute represents the category of the magazine.
	 */
	private Category category;

	public Magazine(String name, int pages, Calendar publicationDate, String url, double price, String periodicity, Category category) {
		super(name, pages, publicationDate, url, price);
		this.id = generateId();
		this.periodicity = periodicity;
		this.category = category;
	}

	/**
	 * This function generates a random alphanumeric ID consisting of three characters.
	 * 
	 * @return A randomly generated alphanumeric string of length 3.
	 */
	@Override
	public  String generateId() {
		String alfanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String alfId = "";
		for (int i = 0; i < 3; i++) {
			alfId += alfanumeric.charAt((int) (Math.random() * alfanumeric.length()));//generate a random character and add it to the id
		}
		return alfId;
	}

	/**
	 * The function returns a string that includes the attributes to modify for a magazine, including
	 * periodicity and category.
	 * 
	 * @return A string that includes the attributes to modify for a magazine, as well as the current
	 * periodicity and category of the magazine, and a list of other categories that can be chosen.
	 */
	@Override
	public String showAttributesToModify() {
		return super.showAttributesToModify() + "\n(6) Periodicity: " + this.periodicity + 
		"\n(7) Category: " + this.category.getName() + "\n"
		+ "   Other categories: " + "\n    (1) Varities \n    (2) Desing \n    (3) Scientific";
	}

	public String getPeriodicity() {
		return this.periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}


	public int getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(int subscriptions) {
		this.subscriptions += subscriptions;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This function overrides the default toString method to include additional information about a
	 * magazine's periodicity, category, and ID.
	 * 
	 * @return A string representation of a magazine, which includes the magazine's superclass's string
	 * representation, the magazine's periodicity, category name, and ID.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPeriodicity: " + this.periodicity + 
		"\nCategory: " + this.category.getName() + "\nID: " + this.id + "\n";
	}

}