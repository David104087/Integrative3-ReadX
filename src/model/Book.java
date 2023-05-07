package model;
import java.util.Calendar;

public class Book extends BibliographicProduct {

	private String id;
	private String review;
	private int unitsSold;
	private Genre genre;

	/**
	 * 
	 * @param name
	 * @param pages
	 * @param publicationDate
	 * @param url
	 * @param price
	 * @param id
	 * @param review
	 * @param genre
	 */
	public Book(String name, int pages, Calendar publicationDate, String url, double price, String review, Genre genre) {
		super(name, pages, publicationDate, url, price);
		this.id = generateId();
		this.review = review;
		this.genre = genre;
	}

	public String getReview() {
		return this.review;
	}

	/**
	 * 
	 * @param review
	 */
	public void setReview(String review) {
		this.review = review;
	}

	public int getUnitsSold() {
		return this.unitsSold;
	}

	/**
	 * 
	 * @param unitsSold
	 */
	public void setUnitsSold(int unitsSold) {
		this.unitsSold += unitsSold;
	}

	public Genre getGenre() {
		return this.genre;
	}

	/**
	 * 
	 * @param genre
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String generateId() {
		String hexadecimal = "ABCDEF0123456789";
		String hexId = "";
		for (int i = 0; i < 3; i++) {
			hexId += hexadecimal.charAt((int) (Math.random() * hexadecimal.length()));//generate a random character and add it to the id
		}
		return hexId;
	}

	@Override
	public String showAttributesToModify() {
		return super.showAttributesToModify() + "\n(6) Review: " + this.review + "\n" 
		+ "(7) Genre: " + this.genre.getName() + "\n" + "   Other genres:" + "\n    (1) Sciencie Fiction \n    (2) Fantasy \n    (3) Historical Novel";
	}

	@Override
	public String toString() {
		return super.toString() + "\nReview: " + this.review + "\n" +"Genre: " + this.genre.getName()
		+ "\nID: " + this.id + "\n";
	}

}